package com.fileUpload.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UploadFileResponse {
	
	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;

}
