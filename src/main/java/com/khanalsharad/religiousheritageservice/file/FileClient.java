package com.aadiminnovation.cms.file;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "file-service", url = "http://192.168.0.100/file-service/v1/files")
public interface FileClient {

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public FileResponse uploadFile(@RequestBody FileUploadRequest request);

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public FileResponse getUrl(@RequestParam String key);

  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  public void deleteFile(@RequestParam String key);
}
