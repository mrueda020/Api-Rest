package com.example.demo.api.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(path = "api/v1/parts")
public class PartController {

    private PartService partService;

    @Autowired
    public PartController(PartService partService){
        this.partService = partService;
    }

    @GetMapping
    public ResponseEntity<List<Part>> getParts(){
        return new ResponseEntity<List<Part>>(partService.getParts(), HttpStatus.OK);
    }

    @GetMapping(path = "{partId}")
    public ResponseEntity<Part> getPartById(@PathVariable("partId") Long partId){
        return partService.getPartById(partId);
    }

    @DeleteMapping(path = "{partId}")
    public ResponseEntity<?> deletePart(@PathVariable("partId") Long partId){
       return partService.deletePart(partId);
    }


    @PutMapping(path = "{partId}")
    public ResponseEntity<Part> updatePart(@PathVariable("partId") Long partId, @RequestParam(required = false) String name){
        return partService.updatePart(partId, name);
    }


    @PostMapping
    public void addPart(@RequestBody Part part){
        this.partService.addPart(part);

    }
}
