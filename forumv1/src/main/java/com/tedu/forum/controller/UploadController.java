package com.tedu.forum.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @Value("${dirPath}")
    private String dirPath;

    @RequestMapping("/upload")
    public String upload(MultipartFile picFile) throws IOException {
        //得到原文件名 xx.jpg
        String fileName = picFile.getOriginalFilename();
        System.out.println("文件名:"+fileName);
        //得到文件類型 .jpg
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
        //得到唯一文件名 UUID.randomUUID()得到唯一標示
        fileName = UUID.randomUUID()+suffix;
        System.out.println(fileName);
        //得到保存圖片的路徑
        File dirFile = new File(dirPath);
        //判斷如果不在
        if (!dirFile.exists()){
            //創文件夾
            dirFile.mkdirs();
        }
        //完整文件路徑
        String filePath = dirPath+"/"+fileName;
        //把文件存到上面路徑   拋出異常
        picFile.transferTo(new File(filePath));
        System.out.println("保存完成");

        return fileName;

    }

    @RequestMapping("/remove")
    public void remove(String fileName){
        System.out.println("fileName =" +fileName);

        new File("c:/forumPic/"+fileName).delete();
    }
}
