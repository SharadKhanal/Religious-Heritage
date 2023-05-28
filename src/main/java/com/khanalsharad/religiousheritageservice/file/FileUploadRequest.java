package com.aadiminnovation.cms.file;

import lombok.Data;

/**
 * Request payload to upload file
 * 
 * @author yubaraj
 *
 */

@Data
public class FileUploadRequest {

  private String fileData;

  private Long customerId = 0L;

  private String fileName;

  private FileType fileType = FileType.IMAGE;

}
