package com.codescan.admin.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Component
public class ZipUtils {
    @Value("${zip.filepath}")
    private String filepath;

    public String unzipFile(String file) throws IOException {
        String location = filepath + new Date().getTime() + File.separator;
        File f = new File(location);
        if(!f.isDirectory()){
            f.mkdirs();
        }
        ZipInputStream zin = new ZipInputStream(new FileInputStream(file));
        try {
            ZipEntry ze = null;
            while ((ze = zin.getNextEntry()) != null) {
                String path = location + ze.getName();

                if (ze.isDirectory()) {
                    File unzipFile = new File(path);
                    if(!unzipFile.isDirectory()) {
                        unzipFile.mkdirs();
                    }
                }
                else {
                    FileOutputStream fout = new FileOutputStream(path, false);
                    try {
                        for (int c = zin.read(); c != -1; c = zin.read()) {
                            fout.write(c);
                        }
                        zin.closeEntry();
                    }
                    finally {
                        fout.close();
                    }
                }
            }
        }
        finally {
            zin.close();
        }
        return location;
    }
}
