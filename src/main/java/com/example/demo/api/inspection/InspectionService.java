package com.example.demo.api.inspection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class InspectionService {

    private InspectionRepository inspectionRepository;

    @Autowired
    public InspectionService(InspectionRepository inspectionRepository){
        this.inspectionRepository = inspectionRepository;
    }

    public List<Inspection> getInspections() {
        return inspectionRepository.findAll();
    }

    public void addInspection(Inspection inspection) {

        inspectionRepository.save(inspection);

    }

    public Optional<Inspection> getInspection(Long id) {

        Optional<Inspection> inspection = inspectionRepository.findById(id);
        return inspection;

    }
}
