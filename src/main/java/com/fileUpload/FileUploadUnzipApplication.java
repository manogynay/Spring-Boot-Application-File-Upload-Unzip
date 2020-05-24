package com.fileUpload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.fileUpload.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(
		{
			FileStorageProperties.class
		})
public class FileUploadUnzipApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadUnzipApplication.class, args);
	}

}
