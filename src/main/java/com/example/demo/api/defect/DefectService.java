package com.example.demo.api.defect;

import com.example.demo.api.inspection.Inspection;
import com.example.demo.api.inspection.InspectionRepository;
import com.example.demo.api.part.Part;
import com.example.demo.api.part.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefectService {

    private DefectRepository defectRepository;
    private PartRepository partRepository;

    private InspectionRepository inspectionRepository;

    @Autowired
    public DefectService(DefectRepository defectRepository, PartRepository partRepository, InspectionRepository inspectionRepository){
        this.defectRepository = defectRepository;
        this.partRepository = partRepository;
        this.inspectionRepository = inspectionRepository;
    }
    public List<Defect> getDefects() {
        List<Defect> defects = defectRepository.findAll();
        return defects;
    }

    public void addDefect(Defect defect) {

        setPartForDefect(defect.getPartId(), defect);
        setInspectionForDefect(defect.getInspectionId(),defect);
        defectRepository.save(defect);
    }

    private void setPartForDefect(Long partId, Defect defect){
        if(partId!=null){
            Optional<Part> part = partRepository.findById(partId);
            if(part.isPresent()){
                defect.setPart(part.get());
            }
        }
    }

    private void setInspectionForDefect(Long inspectionId, Defect defect){
        if(inspectionId!=null){
            Optional<Inspection> inspection = inspectionRepository.findById(inspectionId);
            if(inspection.isPresent()){
                defect.setInspection(inspection.get());
            }
        }
    }


    public void deleteDefect(Long defectId) {
        boolean exists = defectRepository.existsById(defectId);
        if (!exists) {
            throw new IllegalStateException("Defect with id " + defectId + " does not exists");
        }
        defectRepository.deleteById(defectId);
    }
}
