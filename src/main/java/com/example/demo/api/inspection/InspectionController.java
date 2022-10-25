package com.example.demo.api.inspection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/inspection")
public class InspectionController {

    private InspectionService inspectionService;

    @Autowired
    public InspectionController(InspectionService inspectionService){
        this.inspectionService = inspectionService;
    }

    @GetMapping
    public List<Inspection> getInspections(){
        return inspectionService.getInspections();
    }


    @GetMapping(path = "{inspectionId}")
    public ResponseEntity<Inspection> getInspection(@PathVariable("inspectionId")Long id){
        Optional<Inspection> inspection = inspectionService.getInspection(id);
        if(inspection.isPresent())
            return new ResponseEntity<Inspection>(inspection.get(), HttpStatus.OK);
        return new ResponseEntity<Inspection>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public void addInspection(@RequestBody Inspection inspection){

        inspectionService.addInspection(inspection);

    }

  /*  @DeleteMapping(path="{inspectionId}")

    public ResponseEntity<?> deleteInspection(@PathVariable("inspectionId") Long inspectionId){
        return de
    }*/


}
