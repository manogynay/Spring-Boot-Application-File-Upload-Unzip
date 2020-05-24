package com.fileUpload.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fileUpload.exception.FileUploadException;
import com.fileUpload.property.FileStorageProperties;

import net.lingala.zip4j.ZipFile;

@Service
public class FileUploadService {
	
	private final Path fileStorageLocation;
	
	private final Path fileUnzipLocation;
	
	 @Autowired
	    public FileUploadService(FileStorageProperties fileStorageProperties) {
	        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
	                .toAbsolutePath().normalize();
	        this.fileUnzipLocation=Paths.get(fileStorageProperties.getUnzipDir()).toAbsolutePath()
	        		.normalize();
	        try {
	            Files.createDirectories(this.fileStorageLocation);
	        } catch (Exception ex) {
	            throw new FileUploadException("Could not create the directory where the uploaded files will be stored.", ex);
	        }
	    }
	 public String storeFile(MultipartFile file) {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	                throw new FileUploadException("Sorry! Filename contains invalid path sequence " + fileName);
	            }

	            // Copy file to the target location (Replacing existing file with the same name)
	            Path targetLocation = this.fileStorageLocation.resolve(fileName);
	            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

	            ZipFile zipFile=new ZipFile(targetLocation.normalize().toString());
	            zipFile.extractAll( this.fileUnzipLocation.toString());
	            return fileName;
	        } catch (IOException ex) {
	            throw new FileUploadException("Could not store file " + fileName + ". Please try again!", ex);
	        }
	    }

}
