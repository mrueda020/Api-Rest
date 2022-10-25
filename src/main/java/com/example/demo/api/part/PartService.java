package com.example.demo.api.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Service

public class PartService {

    private PartRepository partRepository;

    @Autowired
    public PartService(PartRepository partRepository){
        this.partRepository = partRepository;
    }

    public List<Part> getParts(){
        return partRepository.findAll();
    }

    public void addPart(Part part){
        partRepository.save(part);
    }

    public ResponseEntity<PartDTO> getPartById(Long id) {
        try{
            Optional<Part> part = partRepository.findById(id);
            if(part.isPresent()){
                PartDTO partDTO = new PartDTO(part.get().getId(),part.get().getName());
                partDTO.setDefects(part.get().defects);
                return new ResponseEntity<PartDTO>(partDTO, HttpStatus.OK);
            }
            return new ResponseEntity<PartDTO>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<PartDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> deletePart(Long partId) {
        boolean exists = partRepository.existsById(partId);
        if (!exists) {
            return ResponseEntity.notFound().build();
        }

        try{
            partRepository.deleteById(partId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(e.getCause(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @Transactional
    public ResponseEntity<Part> updatePart(Long partId, String name) {
        try {
            Optional<Part> part = partRepository.findById(partId);
            if(!part.isPresent()){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            if(name!=null && !name.isBlank()){
                try{
                    part.get().setName(name);

                    return new ResponseEntity(part.get(),HttpStatus.OK);
                }
                catch(Exception e){
                    return new ResponseEntity(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
                }

            }
            return new ResponseEntity("Name is empty",HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
