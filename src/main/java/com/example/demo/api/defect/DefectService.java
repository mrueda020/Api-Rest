package com.example.demo.api.defect;

import com.example.demo.api.inspection.Inspection;
import com.example.demo.api.inspection.InspectionRepository;
import com.example.demo.api.part.Part;
import com.example.demo.api.part.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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
                defect.setPartId(partId);
            }
        }
    }

    private void setInspectionForDefect(Long inspectionId, Defect defect){
        if(inspectionId!=null){
            Optional<Inspection> inspection = inspectionRepository.findById(inspectionId);
            if(inspection.isPresent()){
                defect.setInspection(inspection.get());
                defect.setInspectionId(inspectionId);
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

    @Transactional
    public ResponseEntity<Defect> updateDefect(Long id, Defect defect) {
        try{
            Optional<Defect> defectBeforeEditing = defectRepository.findById(id);
            if(defectBeforeEditing.isEmpty()){
                return new ResponseEntity("Defect Not found",HttpStatus.NOT_FOUND);
            }

            Defect defect1 = defectBeforeEditing.get();
            defect1.setInspectionId(defect.getInspectionId()!=null ? defect.getInspectionId(): defect1.getInspectionId());
            defect1.setPartId(defect.getPartId()!=null ? defect.getPartId(): defect1.getInspectionId() );
            defect1.setStatus(defect.getStatus()!=null && !defect.getStatus().isBlank()? defect.getStatus(): defect1.getStatus());
            defect1.setComments(defect.getComments() !=null && !defect.getComments().isBlank()? defect.getComments(): defect1.getComments() );
            defect1.setCreatedDate(defect.getCreatedDate()!=null? defect.getCreatedDate(): defect1.getCreatedDate() );
            defect1.setRepairedDate(defect.getRepairedDate()!=null? defect.getRepairedDate(): defect1.getRepairedDate() );

            setInspectionForDefect(defect.getInspectionId(), defect1);
            setPartForDefect(defect.getPartId(), defect1);

            return new ResponseEntity(defect1,HttpStatus.OK);

        }
        catch(Exception e){
            System.out.println(e);
            return new ResponseEntity("Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
