package org.parul.pmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
    public static String uploadDirectory=System.getProperty("user.dir")+"/uploads";
    @GetMapping
    public String uploadPage(Model model)
    {
        return "uploadview";
    }


}
