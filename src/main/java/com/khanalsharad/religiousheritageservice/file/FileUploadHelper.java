package com.khanalsharad.religiousheritageservice.file;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR= "C:\\6thSem\\University_Project\\IMAGE";


    public boolean uploadFile(MultipartFile file){
        boolean f= false;
        try{

//            //read
//            InputStream is = file.getInputStream();
//            byte data[] = new byte[is.available()];
//            is.read(data);
//
//            //write
//            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+ File.separator+file.getOriginalFilename());
//            fos.write(data);
//            fos.flush();
//            fos.close();
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
