package com.fileUpload.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "file")
@Data
public class FileStorageProperties {
	@Value("file.upload-dir")
	private String uploadDir;
	@Value("file.unzip-dir")
	private String unzipDir;
}
