package com.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "specialty")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 20)
    private String code;

    @Column
    @Size(max = 400)
    private String name;

    @ManyToOne
    @JoinColumn(name = "academic_plan_id")
    private AcademicPlan academicPlan;

    public Set<SemesterPlan> getSemesterPlanList() {
        return semesterPlanList;
    }

    public void setSemesterPlanList(Set<SemesterPlan> semesterPlanList) {
        this.semesterPlanList = semesterPlanList;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "specialty")
    private Set<SemesterPlan> semesterPlanList = new HashSet<SemesterPlan>();

    public Specialty(Long id, @Size(max = 20) String code, @Size(max = 400) String name, AcademicPlan academicPlan) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.academicPlan = academicPlan;
    }

    public Specialty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AcademicPlan getAcademicPlan() {
        return academicPlan;
    }

    public void setAcademicPlan(AcademicPlan academicPlan) {
        this.academicPlan = academicPlan;
    }
}
