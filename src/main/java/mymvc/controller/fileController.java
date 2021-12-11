package mymvc.controller;


import mymvc.annotation.*;
import mymvc.model.MyModelView;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import mymvc.service.FileService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@MyController
public class fileController {

    @MyAutowired
    private FileService fileService;

    @MyRequestMapping(value = "/upload", method = "GET")
    @ResponseView
    public MyModelView upload_page() {
        MyModelView mv = new MyModelView();
        mv.setView("upload");
        return mv;
    }

    @MyRequestMapping(value = "/upload", method = "POST")
    @ResponseView
    public MyModelView upload(@MyRequestParam("file") FileItem source) {

        String path = "D:/code/temp/"; // 假定这里路径是固定的

        MyModelView mv = new MyModelView();
        mv.setView("download");
        if (fileService.uploadFile(source, path)){
            mv.addModel("info", "Successfully upload");
        }else{
            mv.addModel("info", "Failure to upload");
        }
        return mv;
    }

    @MyRequestMapping(value = "download",method = "GET")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @MyRequestParam("filename") String filename)throws Exception{
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path+File.separator+filename);
        HttpHeaders headers = new HttpHeaders();
        String downloadFile = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment",downloadFile);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
}
