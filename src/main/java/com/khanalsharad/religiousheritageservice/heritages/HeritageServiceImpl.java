package com.khanalsharad.religiousheritageservice.heritages;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HeritageServiceImpl implements HeritageService {
    private final HeritageRepository heritageRepository;
    @Override
    public Heritage saveHeritage(HeritageDto heritageDto) {
        Heritage heritage = new Heritage();
        heritage.setHeritageName(heritageDto.getHeritageName());
        heritage.setDescription(heritageDto.getDescription());
        heritage.setDistrictName(heritageDto.getDistrictName());
        heritage.setProvinceName(heritageDto.getProvinceName());
        heritage.setMunicipality(heritageDto.getMunicipality());
//        heritage.setLocalMuniciplaiyty(heritageDto.getLocalMuniciplaiyty());
        Heritage savedHeritage=  heritageRepository.save(heritage);

        return savedHeritage;
    }

    public HeritageResponseDto getHeritageResponse(Heritage heritage){
        HeritageResponseDto response = new HeritageResponseDto();
        response.setId(heritage.getId());
        response.setHeritageName(heritage.getHeritageName());
        response.setDescription(heritage.getDescription());
        response.setProvinceName(heritage.getProvinceName());
        response.setDistrictName(heritage.getDistrictName());
        response.setMunicipality(heritage.getMunicipality());
        return  response;

    }

    @Override
    public Heritage getById(long id, HeritageDto heritageDto) {
        Optional<Heritage> optionalHeritage = heritageRepository.findById(id);

        if(optionalHeritage.isPresent()){
            Heritage  heritage = optionalHeritage.get();
            return heritage;
        }
        else{
            System.out.println("Oops not found");
        }
        return null;
    }

    @Override
    public HeritageResponseListDto getHeritages() {
        List<HeritageResponseDto>  heritageResponseDto =  new ArrayList<>();
        List<Heritage> heritages = heritageRepository.findAll();
     for(Heritage heritage: heritages){
         heritageResponseDto.add(getHeritageResponse(heritage));
     }

     HeritageResponseListDto response = new HeritageResponseListDto();
     response.setHeritages(heritageResponseDto);
     response.setTotal(heritageResponseDto.size());
        return response;
    }

    @Override
    public Heritage updateHeritage(long id, HeritageDto heritageDto) {
      Optional<Heritage> optionalHeritage= heritageRepository.findById(id);
      if(optionalHeritage.isPresent()){
          Heritage heritage =optionalHeritage.get();
          heritage.setHeritageName(heritageDto.getHeritageName());
          heritage.setDescription(heritageDto.getDescription());
          heritage.setProvinceName(heritageDto.getProvinceName());
          heritage.setDistrictName(heritageDto.getDistrictName());
          heritage.setMunicipality(heritageDto.getMunicipality());

          return heritageRepository.save(heritage);
//          Heritage savedHeritage= heritageRepository.save(heritage);
      }
        return null;
    }

}
