package com.example.demo.api.part;

import com.example.demo.api.defect.Defect;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Part {

    @Id
    @SequenceGenerator(name = "part_sequence", sequenceName = "part_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "part_sequence")
    private Long id;

    @JsonBackReference
    @OneToMany(mappedBy = "part", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Defect> defects = new HashSet<>();

    private String name;

    public Part(){

    }


}
