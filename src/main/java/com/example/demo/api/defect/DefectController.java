package com.example.demo.api.defect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    @GetMapping(path="{defectId}")
    public ResponseEntity<Defect> getDefect(@PathVariable("defectId") Long defectId){
        return defectService.getDefect(defectId);
    }

    @PostMapping
    public void addDefect(@RequestBody Defect defect){
        defectService.addDefect(defect);
    }


    @DeleteMapping(path = "{defectId}")
    public void deleteDefect(@PathVariable("defectId") Long defectId){
        defectService.deleteDefect(defectId);

    }

    @PutMapping(path="{defectId}")
    public ResponseEntity<Defect> updateDefect(@PathVariable("defectId") Long id, @RequestBody Defect defect){
        return defectService.updateDefect(id,defect);
    }



}
