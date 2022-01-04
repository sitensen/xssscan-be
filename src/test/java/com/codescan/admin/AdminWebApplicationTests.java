package com.codescan.admin;

import com.codescan.admin.modules.sys.model.SysFile;
import com.codescan.admin.modules.sys.service.IFileService;
import com.codescan.admin.utils.ZipUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminWebApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    IFileService fileService;
    @Autowired
    ZipUtils zipUtils;

    @Test
    public void findFileInfo(){
        String url = "http://101.43.151.105:9000/commonfile/8d561dbc-fcdf-42af-9402-3836e3e9965c.log";
        SysFile sysFile = fileService.findByMinioUrl(url);
        System.out.println(sysFile.toString());
    }

    @Test
    public void unzipFileInfo() throws IOException {
        String fileName = "/Users/guoxuehe/Downloads/111/m2.zip";
        zipUtils.unzipFile(fileName);
    }
}
