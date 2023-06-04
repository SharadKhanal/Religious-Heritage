package com.khanalsharad.religiousheritageservice.file;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileUploadController {
    public final FileUploadHelper fileUploadHelper;

    public FileUploadController(FileUploadHelper fileUploadHelper) {
        this.fileUploadHelper = fileUploadHelper;
    }

    @PostMapping("/file-upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getName());
//        System.out.println(file.getContentType());
//        System.out.println(file.getSize());

        try {
            //validation
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file!!");
            }

            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG image are allowed!!");
            }
            boolean f = fileUploadHelper.uploadFile(file);
            if (f) {
                return ResponseEntity.ok("File is Successfully uploaded");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wro ng!!");

    }
}
