package com.dbc.api;

import com.dbc.utils.BaseResult;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/upload")
public class UploadApi {
    public static final String UPLOAD_FOLDER = "";

    @CrossOrigin(value = "http://localhost:8081")
    @PostMapping("/articleTypeCover")
    public BaseResult<String> uploadArticleTypeCover(@RequestParam(value = "file") MultipartFile file) throws FileNotFoundException {
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "static";
        realPath = realPath.replace("/", "\\").substring(1, realPath.length());
        System.out.println("realPath:"+realPath);
        System.out.println("fileName:"+file.getOriginalFilename());
        try {
            File file1 = new File(realPath, file.getOriginalFilename());
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file);
        return BaseResult.successWithData("jj");
    }
}
