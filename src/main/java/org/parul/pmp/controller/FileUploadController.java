package org.parul.pmp.controller;

import org.parul.pmp.dto.DocTypeDTO;
import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.dto.UploadDocDTO;
import org.parul.pmp.dto.mapper.DocTypeMapper;
import org.parul.pmp.dto.mapper.UploadDocMapper;
import org.parul.pmp.entity.*;
import org.parul.pmp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
    //private static String UPLOADED_FOLDER = "F://";
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocTypeRepository docTypeRepository;
    @Autowired
    private UploadDocRepository uploadDocRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public String uploadPage(Model model) {


        /*List<DocType> documents = docTypeRepository.findAll();
        List<DocTypeDTO> doctypes = documents.stream().map(DocTypeMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("doctypes", doctypes);
        model.addAttribute("uploaddoc", new UploadDocDTO());*/
        return "fileUpload";
    }

    @PostMapping
    public String uploadFile(@RequestParam(name = "file") MultipartFile file,Model model) {
        //long userid = (long) session.getAttribute("userid");
        //Student student = studentRepository.findById(userid).get();
        //uploaddoc.setUploadedby(student.getEnrollment());
        //Documents documents = documentRepository.findByDocType(doctype).get();

       /* if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile file : fileUpload) {

                System.out.println("Saving file: " + file.getOriginalFilename());

                // uploadFile.setFileName(aFile.getOriginalFilename());
                uploaddoc.setData(file.getBytes());
                UplodedDocuments uplodedDocuments = UploadDocMapper.toEntity(uploaddoc);
                uplodedDocuments.setGroupDetails(student.getProjectGroup());
                uplodedDocuments.setDocuments(documents);
                uploadDocRepository.saveAndFlush(uplodedDocuments);
            }
            model.addAttribute("msg","File Uploaded Successfully");
        }*/
        if (file.isEmpty())
        {
            model.addAttribute("msg","No file present");
        }
        else
        {
            try {
                String uploadDir=getClass().getResource("/templates").getPath()+"/upload";
                File file1=new File(uploadDir);
                if (!file1.exists())
                    file1.mkdir();
                String uploadFiles = uploadDir+"/"+file.getOriginalFilename();
                file.transferTo(new File(uploadFiles));
                model.addAttribute("msg","Uploading done successfully");
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                model.addAttribute("msg","Uploading not done successfully");
            }

        }

        return "result";
    }

}
