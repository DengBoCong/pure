package com.dbc.api;

import com.dbc.entity.entity.PurePhotoEntity;
import com.dbc.service.PhotoService;
import com.dbc.utils.BaseResult;
import com.dbc.utils.DateUtils;
import com.dbc.utils.PublicContant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

@RestController
@RequestMapping("/upload")
public class UploadApi {
    public static final String URL_IMG = "http://localhost:8080/upload/img/";

    @Autowired
    PhotoService photoService;

    @CrossOrigin(value = PublicContant.baseUrl)
    @PostMapping("/articleTypeCover")
    public BaseResult<String> uploadArticleTypeCover(@RequestParam(value = "file") MultipartFile file) {
        String realPath = "";
        String path = DateUtils.dateFolderStr(LocalDate.now(), "article");
        String fileName = System.currentTimeMillis() + PublicContant.random() + "";
        try {
            realPath = ResourceUtils.getURL("classpath:").getPath() + "static/upload/img/" + path;
            realPath = realPath.replace("/", "\\").substring(1, realPath.length());
            PublicContant.createDir(realPath);
            File file1 = new File(realPath, fileName + file.getOriginalFilename());
            if (!file1.exists()) file1.mkdir();
            file.transferTo(file1);
        }catch (Exception e) {
            e.printStackTrace();
        }
        PurePhotoEntity photoEntity = new PurePhotoEntity();
        photoEntity.setAddTime(DateUtils.NewDateInt());
        photoEntity.setUrl(URL_IMG + path + "/" + fileName + file.getOriginalFilename());
        photoEntity.setDescription("文章分类专栏封面");
        photoEntity.setOrigin("未知");
        photoService.oneInsert(photoEntity);
        return BaseResult.successWithData(URL_IMG + path + "/" + fileName + file.getOriginalFilename());
    }
}
