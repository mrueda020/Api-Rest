package com.example.demo.api.inspection;

import com.example.demo.api.defect.Defect;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Inspection {

    @Id
    @SequenceGenerator(name = "inspection_sequence", sequenceName = "inspection_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inspection_sequence")
    private Long id;

    @OneToMany(mappedBy = "inspection",  cascade = CascadeType.REMOVE)
    Set<Defect> defects;

    private int vehiculeId;

    private int driverId;

    private String comments;

    private Date createdDate;

    public Inspection(){

    }

    public Inspection(Long id, int vehiculeId, int driverId, String comments, Date createdDate) {
        this.id = id;
        this.vehiculeId = vehiculeId;
        this.driverId = driverId;
        this.comments = comments;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVehiculeId() {
        return vehiculeId;
    }

    public void setVehiculeId(int vehiculeId) {
        this.vehiculeId = vehiculeId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
