package com.example.demo.api.part;

import com.example.demo.api.defect.Defect;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Part {

    @Id
    @SequenceGenerator(name = "part_sequence", sequenceName = "part_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "part_sequence")
    private Long id;

    @OneToMany(mappedBy = "part", cascade = CascadeType.REMOVE)
    Set<Defect> defects = new HashSet<>();

    private String name;

    public Part(){

    }

    public Part(Long id, String name) {
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
}
