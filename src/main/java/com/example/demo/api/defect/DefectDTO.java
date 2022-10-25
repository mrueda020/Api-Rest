package com.example.demo.api.defect;


import com.example.demo.api.inspection.Inspection;
import com.example.demo.api.part.Part;


import java.util.Date;

public class DefectDTO {


    public Long id;

    Inspection inspection;

    private Long inspectionId;


    private Long partId;

    Part part;

    public String status;

    public String comments;

    public Date createdDate;

    public Date repairedDate;


    public DefectDTO() {
    }


    public DefectDTO(Long id, Inspection inspection, Long inspectionId, Long partId, Part part, String status, String comments, Date createdDate, Date repairedDate) {
        this.id = id;
        this.inspection = inspection;
        this.inspectionId = inspectionId;
        this.partId = partId;
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
}
