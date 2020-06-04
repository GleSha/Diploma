package com.app.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 400)
    private String name;

    @Column
    @Size(max = 20)
    private String shortName;

    @Column
    @Size(max = 400)
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "semester_plan_id")
    private SemesterPlan semesterPlan;

    public Subject() {
    }

    public Subject(Long id, @Size(max = 400) String name, @Size(max = 20) String shortName, @Size(max = 400) String fileName, SemesterPlan semesterPlan) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.fileName = fileName;
        this.semesterPlan = semesterPlan;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public SemesterPlan getSemesterPlan() {
        return semesterPlan;
    }

    public void setSemesterPlan(SemesterPlan semesterPlan) {
        this.semesterPlan = semesterPlan;
    }
}
