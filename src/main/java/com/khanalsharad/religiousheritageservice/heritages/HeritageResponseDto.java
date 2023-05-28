package com.khanalsharad.religiousheritageservice.heritages;

import lombok.Data;

@Data
public class HeritageResponseDto {
    private  Long id;
    private String heritageName;
    private String provinceName;
    private String districtName;
    private String municipality;
    private String localMuniciplaiyty;
    private String description;
    private String image;
}
