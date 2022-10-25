package com.example.demo.api.part;

import com.example.demo.api.defect.Defect;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class PartDTO {


    private Long id;


    private Set<Defect> defects = new HashSet<>();

    private String name;

    public PartDTO(){

    }

    public PartDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Defect> getDefects() {
        return defects;
    }

    public void setDefects(Set<Defect> defects) {
        this.defects = defects;
    }
}
