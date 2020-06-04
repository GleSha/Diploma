package com.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "academic_plan")
public class AcademicPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 400)
    @NotBlank
    private String fileName;

    @Column
    @NotNull
    private Date dateStart;

    @Column
    @NotNull
    private Date dateEnd;

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "academicPlan")
    private Set<Specialty> specialties = new HashSet<Specialty>();

    public AcademicPlan(Long id, @Size(max = 400) String fileName, Date dateStart, Date dateEnd) {
        this.id = id;
        this.fileName = fileName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public AcademicPlan(@Size(max = 400) String fileName, Date dateStart, Date dateEnd) {
        this.fileName = fileName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public AcademicPlan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
