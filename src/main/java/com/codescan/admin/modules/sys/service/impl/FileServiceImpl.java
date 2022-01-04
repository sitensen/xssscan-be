package com.codescan.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codescan.admin.common.exception.ApiException;
import com.codescan.admin.modules.sys.mapper.SysFileMapper;
import com.codescan.admin.modules.sys.model.SysFile;
import com.codescan.admin.modules.sys.service.IFileService;
import com.codescan.admin.security.util.JwtTokenUtil;
import com.codescan.admin.utils.MinioUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class FileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements IFileService {
    @Value("${minio.server}")
    private String server;
    @Value("${minio.accessKey}")
    private String username;
    @Value("${minio.secretKey}")
    private String password;
    @Value("${zip.filepath}")
    private String filepath;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public String uploadFile(String filepath) {
        String url = "";
        try {
            File file = new File(filepath);
            MinioUtils minioClient = new MinioUtils(server, username, password);
            url = minioClient.upload(new FileInputStream(file),file.getName());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException("生成报告失败！");
        }
        return url;
    };

    public List<String> uploadFiles(MultipartFile[] files) {
        List<String> result = new ArrayList<>();
        try {
            MinioUtils minioClient = new MinioUtils(server, username, password);
            String host = "xxxx";
            for (MultipartFile file : files) {
                String fileName = minioClient.putObject(file, file.getContentType());
                String url = (host + "/api/file/getFile?fileName=" + fileName);
                result.add(url);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public InputStream getFile(String fileName) {
        try {
            MinioUtils minioClient = new MinioUtils(server, username, password);
            InputStream is = minioClient.getObject(fileName);
            return is;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String uploadFileRtPath(MultipartFile file) {
        try {
            MinioUtils minioClient = new MinioUtils(server, username, password);
            String url = minioClient.putObject(file, file.getContentType());
            String minioUrl = minioClient.getBasisUrl() + url;
            String fileName = file.getOriginalFilename();
            String suffiixName = fileName.substring(fileName.lastIndexOf("."));
            long random = new Date().getTime();
            String localFilePath = filepath + random + File.separator + fileName;
            File dest = new File(localFilePath);
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
                dest.createNewFile();
            }
            file.transferTo(dest);
            log.info("上传的文件名为:{},上传的后缀为:{},minioUrl:{},本地url:{}",fileName,suffiixName,minioUrl,localFilePath);
            SysFile sysFile = SysFile.builder()
                    .minioUrl(minioUrl)
                    .localUrl(localFilePath)
                    .fileSize(file.getSize())
                    .build();
            this.save(sysFile);

            return minioUrl;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException("上传文件失败！");
        }
    }

    @Override
    public SysFile findByMinioUrl(String minioUrl) {
        SysFile sysFile = SysFile.builder()
                .minioUrl(minioUrl)
                .build();
        QueryWrapper<SysFile> wrapper = new QueryWrapper<>(sysFile);
        return baseMapper.selectOne(wrapper);
    }

    public String uploadImage(BufferedImage file, String filename) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(file, "png", os);
            InputStream input = new ByteArrayInputStream(os.toByteArray());
            MinioUtils minioClient = new MinioUtils(server, username, password);
            String url = minioClient.putObject(filename, input);
            return minioClient.getBasisUrl() + url;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String uploadFileRtPath(String fileName) {
        try {
            MinioUtils minioClient = new MinioUtils(server, username, password);
            String url = minioClient.putObject(fileName);
            return minioClient.getBasisUrl() + url;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }



    public List<String> uploadFilesRtPath(MultipartFile[] files) {
        List<String> result = new LinkedList<>();
        try {
            MinioUtils minioClient = new MinioUtils(server, username, password);
            for (MultipartFile file : files) {
                String url = minioClient.putObject(file, file.getContentType());
                result.add(minioClient.getBasisUrl() + url);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
