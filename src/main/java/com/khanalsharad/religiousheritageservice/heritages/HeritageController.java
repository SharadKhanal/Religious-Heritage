package com.khanalsharad.religiousheritageservice.heritages;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/religious-heritages/place")
public class HeritageController {
    public final HeritageService heritageService;

    public HeritageController(HeritageService heritageService) {
        this.heritageService = heritageService;
    }

    @PostMapping
    public Heritage saveHeritage(@RequestBody HeritageDto heritageDto){
        return heritageService.saveHeritage(heritageDto);
    }
    @GetMapping
    public HeritageResponseListDto getReligiousHeritages(){
        return heritageService.getHeritages();
    }

    @GetMapping("/{id}")
    public  Heritage getHeritageById(@PathVariable("id") long id , @RequestBody HeritageDto heritageDto){
        return heritageService.getById(id, heritageDto);
    }
    @PutMapping("/{id}")
    public Heritage updateHeritage( @PathVariable("id") long id,@RequestBody HeritageDto heritageDto ){
        return heritageService.updateHeritage(id,heritageDto);
    }

    @DeleteMapping("/{id}")
    public Heritage deleteHeritage(@PathVariable("id") long id){
       return heritageService.deleteHeritage(id);
    }

}
