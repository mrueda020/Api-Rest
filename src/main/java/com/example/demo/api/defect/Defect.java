package com.example.demo.api.defect;

import com.example.demo.api.inspection.Inspection;
import com.example.demo.api.part.Part;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Defect {

    @Id
    @SequenceGenerator(name = "defect_sequence", sequenceName = "defect_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "defect_sequence")
    public Long id;

    @ManyToOne( cascade = CascadeType.REMOVE)
    @JoinColumn(name="inspectionId")
    Inspection inspection;


    @Transient
    private Long inspectionId;

    @Transient
    private Long partId;

    @ManyToOne
    @JoinColumn(name="partId")
    Part part;

    public String status;

    private String comments;

    private Date createdDate;

    private Date repairedDate;

    public Defect(){

    }

    public Defect(Long id, Inspection inspection, Part part, String status, String comments, Date createdDate, Date repairedDate) {
        this.id = id;
        this.inspection = inspection;
        this.part = part;
        this.status = status;
        this.comments = comments;
        this.createdDate = createdDate;
        this.repairedDate = repairedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inspection getInspection() {
        return inspection;
    }

    public void setInspection(Inspection inspection) {
        this.inspection = inspection;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getRepairedDate() {
        return repairedDate;
    }

    public void setRepairedDate(Date repairedDate) {
        this.repairedDate = repairedDate;
    }

    public Long getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(Long inspectionId) {
        this.inspectionId = inspectionId;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }
}
