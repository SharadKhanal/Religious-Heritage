package com.aadiminnovation.cms.file;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FileResponse {

  private String url;

  private String key;
}
