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
@RequestMapping("/uploadFile")
public class FileUploadController {
    private static String UPLOADED_FOLDER = "F://";
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

    @PostMapping("/upload")
    public String uploadDocument(@RequestParam("file") MultipartFile file,Model model) {
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
        if (file.isEmpty()) {
            model.addAttribute("msg", "Please select a file to upload");
            return "fileUpload";
        }
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            model.addAttribute("msg",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "fileUpload";
    }

}
