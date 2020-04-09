package com.shu.labrary.controller;
import com.shu.labrary.service.surface.Teacherservice;
import com.shu.labrary.tools.FastDFSClient;
import com.shu.labrary.pojo.response.WangUploadPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@CrossOrigin
@Controller
public class FileFdsController {
    @Autowired
    Teacherservice teacherservice;
    @RequestMapping(value = "uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public String fileuploadpicture(@RequestParam MultipartFile uploadfile) throws IOException {
        String fileID = FastDFSClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
        return fileID;
    }

    @RequestMapping(value = "WangUploadfile", method = RequestMethod.POST)
    @ResponseBody
    public WangUploadPic WangUploadfile(@RequestParam MultipartFile uploadfile) throws IOException {
        WangUploadPic wangUploadPic = new WangUploadPic();
        String[] data = new String[2];
        String fileID = FastDFSClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
        String picSrc = "http://114.55.93.118/" + fileID;
        data[0] = picSrc;
        wangUploadPic.setErrno(0);
        wangUploadPic.setData(data);
        return wangUploadPic;
    }

}


