package com.example.imageUploader.service;

import com.example.imageUploader.entity.Image;
import com.example.imageUploader.exception.ImageStorageException;
import com.example.imageUploader.exception.MyFileNotFoundException;
import com.example.imageUploader.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image storeFile(MultipartFile file){
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        try{
            if(filename.contains("..")){
                throw new ImageStorageException("Sorry! filename contains invalid path  sequence"+ filename);
            }

            Image profilePicture = new Image(filename, file.getContentType(), file.getBytes());
            return imageRepository.save(profilePicture);
        }
        catch (IOException ex){
            throw new ImageStorageException("Could not store file "+filename+". Please try again! "+ex);
        }

    }

    public Image getImage(Integer fileId){
        return imageRepository.findById(fileId).orElseThrow(()->
                new MyFileNotFoundException("File not found with id "+fileId));
    }
}
