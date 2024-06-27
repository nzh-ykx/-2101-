package com.example.controller;

import cn.hutool.core.io.FileUtil;
import com.example.common.Result;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;


@RestController
@RequestMapping("/files")
public class FileController {
    @Value("${ip}")//@Value从配置文件里获取 ip为localhost
    private String ip;
    @Value("${server.port}")// 端口号 9090
    private String port;
    private  static final String ROOT_PATH = System.getProperty("user.dir") + "/files";//当前项目student的路径下,并创建一个files目录
    //文件上传
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
    String originalFilename =  file.getOriginalFilename();//获取到原始的文件名，比如:login.jpg
        long flag = System.currentTimeMillis();//唯一标识
        String fileName = flag + "_" + originalFilename;//123_login.jpg
        File finalFile = new File(ROOT_PATH +"/"+ fileName);//最终存到磁盘的文件对象
        if (!finalFile.getParentFile().exists()){//如果父级目录不存在。就需要创建
           finalFile.getParentFile().mkdir();//创建目录
         }
        file.transferTo(finalFile);//把文件写到磁盘里
        String url = "http://"+ip+":"+port+"/files/download?fileName=" + fileName;//最终返回给前端的图片的url，，url是由后端来生成的
        //返回图片的url路径
        return Result.success(url);
    }
    //文件下载
    @GetMapping("/download")
    public void download(String fileName, HttpServletResponse response)throws IOException{
        File file = new File(ROOT_PATH +"/"+ fileName);//文件在磁盘存储的对象
        ServletOutputStream os = response.getOutputStream();
        response.setHeader("Content-Disposition","attachment;filename" + URLEncoder.encode(fileName,"UTF-8"));
        response.setContentType("application/octet-stream");
        FileUtil.writeToStream(file,os);
        os.flush();
        os.close();
    }

}
