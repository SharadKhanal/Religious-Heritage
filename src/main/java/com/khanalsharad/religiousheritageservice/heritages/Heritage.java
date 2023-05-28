package com.khanalsharad.religiousheritageservice.heritages;

import com.khanalsharad.religiousheritageservice.core.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.util.ObjectUtils;

@Entity
@Data
public class Heritage  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String heritageName;
    private String provinceName;
    private String districtName;
    private String municipality;
//    private String localMuniciplaiyty;
    @Lob
    private String description;
    private String image;

}
