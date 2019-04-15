package org.parul.pmp.controller;


import org.parul.pmp.entity.UplodedDocuments;
import org.parul.pmp.repository.UploadDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
@RequestMapping("/download")
public class DownloadController {

    @Autowired
    private UploadDocRepository uploadDocRepository;

    @GetMapping
    public void download(HttpServletRequest request, HttpServletResponse response) throws MalformedURLException, URISyntaxException, IOException
    {

        //URL url = new URL("file:/home/atul_saurabh/Documents/atul_aadhar_card_withou_pass.pdf");
        URL url = new URL("file:/C:/Users/shubh/report1.pdf");
        File file=new File(url.toURI());


        if (file.exists())
        {
            Path path=file.toPath();
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition","attachment; filename="+file.getName());
            Files.copy(path,response.getOutputStream());
            response.getOutputStream().flush();
        }
    }
}
