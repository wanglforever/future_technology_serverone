package com.future.technology.serverone.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by wangl on 2017/6/1.
 */
@Slf4j
@Component
public class FileUploadUtil {
    /**
     * 删除保存的文件
     * @param localPath  删除的目录
     * @param requestUrl 对应的可访问URl
     * @return boolean 是否删除成功
     */
    public static boolean deleteFile(String localPath,String requestUrl){
        boolean isDelete = false;
        if(!StringUtils.isEmpty(requestUrl)){
            String fileName = requestUrl.substring(requestUrl.lastIndexOf("/") + 1);
            File file = new File(localPath + "/" + fileName);
            isDelete  = file.delete();
        }
        return isDelete;
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        log.info("copyFile start!!");
        if(!destFile.exists()) {
            log.info("copyFile destFile create!!");
            try {
                destFile.createNewFile();
            } catch (IOException e) {
                log.error("copyFile destFile create error!!");
                e.printStackTrace();
            }
        }
        FileInputStream ins = null;
        FileOutputStream outs = null;
        try {
            ins = new FileInputStream(sourceFile);
            outs = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = ins.read(buffer)) > 0) {
                outs.write(buffer, 0, length);
            }
            ins.close();
            outs.close();
            log.info("copyFile successfully!!");
        } finally {
            if(ins != null){
                ins.close();
            }
            if(outs != null){
                outs.close();
            }
        }
    }

    /**
     * 删除目录下的所有文件，不删除目录
     * @param file
     * @return
     */
    public static boolean deleteDir(File file){
        if(file.isDirectory()){
            for (File file1:file.listFiles()){
                file1.delete();
            }
        }
        return true;
    }

}


