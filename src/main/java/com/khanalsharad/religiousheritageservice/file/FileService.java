package com.aadiminnovation.cms.file;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service API related to file.
 * 
 * @author yubaraj
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {
  private final FileClient fileClient;

  /**
   * Use this method to upload file.
   * 
   * @param fileData the fileData is the Base64 encoded data of the actual file that can not be
   *        null.
   * @param fileType the type of the file that can not be null
   * @param fileName the name of the file that can be null
   * @return The key of the uploaded file that can be used for future acess.
   */
  public String uploadFile(String fileData, FileType fileType, String fileName) {
    FileUploadRequest request = new FileUploadRequest();
    request.setFileData(fileData);
    request.setFileName(fileName);
    request.setFileType(fileType);

    String key = null;
    try {
      FileResponse uploadFile = fileClient.uploadFile(request);
      if (uploadFile != null)
        key = uploadFile.getKey();
    } catch (Exception e) {
      log.error("Error {}", e);
    }
    return key;
  }

  /**
   * Returns the key and the URL of the file from given key.
   * 
   * @param key the key of the actual file that can not be null.
   */
  public FileResponse getUrl(String key) {
    return fileClient.getUrl(key);
  }

  /**
   * 
   * Deletes the file associated with given key.
   * 
   * @param key the key that can not be null.
   */
  public void deleteFile(String key) {
    fileClient.deleteFile(key);
  }

}
