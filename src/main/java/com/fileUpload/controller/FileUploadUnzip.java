package com.fileUpload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fileUpload.model.UploadFileResponse;
import com.fileUpload.service.FileUploadService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FileUploadUnzip {
	

	@Autowired
	private FileUploadService uploadService;
	@PostMapping("uploadFile")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile fileSent){
		String fileName=uploadService.storeFile(fileSent);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
		log.info(fileDownloadUri);
        return new UploadFileResponse(fileName, fileDownloadUri,
        		fileSent.getContentType(), fileSent.getSize());
	}
}
