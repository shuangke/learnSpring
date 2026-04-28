package com.shuangke.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("file")
public class FilterController {
    @PostMapping("upload")
    public String upload(String account, MultipartFile headImage) throws IOException {
        //1.接收文件（已经完成）
        //2. 转存文件（我们先不做）先做读取文件
        System.out.println("account = " + account);
        //获取文件的原始名称
        String originalFilename = headImage.getOriginalFilename();
        System.out.println("the file name = " + originalFilename);

        // 获取前端传过来的key，value对中的key （也就是表单中input标签的name属性值）
        String name = headImage.getName();
        System.out.println("the name = " + name);

        //获取文件的大小
        long size = headImage.getSize();
        System.out.println("the file size = " + size);

        // 获取文件的内容类型
        String contentType = headImage.getContentType();
        System.out.println("contentType = " + contentType);

        //获取文件输入流
        InputStream inputStream = headImage.getInputStream();

        //获取文件的字节数组
        byte[] bytes = headImage.getBytes();
        return "file upload success";
    }
}
