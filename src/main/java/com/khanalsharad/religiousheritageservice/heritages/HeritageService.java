package com.khanalsharad.religiousheritageservice.heritages;

import java.util.List;

public interface HeritageService {
    Heritage saveHeritage(HeritageDto heritageDto);

    Heritage getById(long id, HeritageDto heritageDto);


    HeritageResponseListDto getHeritages();

    Heritage updateHeritage(long id, HeritageDto heritageDto);
}
