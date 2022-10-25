package com.example.demo.api.defect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/defect")
public class DefectController {

    private DefectService defectService;

    @Autowired
    public DefectController(DefectService defectService){
        this.defectService = defectService;
    }

    @GetMapping
    public List<Defect> getDefects(){
        return defectService.getDefects();
    }


    @PostMapping
    public void addDefect(@RequestBody Defect defect){
        defectService.addDefect(defect);
    }


    @DeleteMapping(path = "{defectId}")
    public void deleteDefect(@PathVariable("defectId") Long defectId){
        defectService.deleteDefect(defectId);

    }

}
