package com.khanalsharad.religiousheritageservice.heritages;

import lombok.Data;

import java.util.List;
@Data
public class HeritageResponseListDto {
    private List<HeritageResponseDto> heritages;
    private long total;
}
