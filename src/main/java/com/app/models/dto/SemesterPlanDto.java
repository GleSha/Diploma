package com.app.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SemesterPlanDto {

    private Long id;

    @NotEmpty
    @Size(max = 200)
    private String fileName;

    @NotNull
    private Integer semesterNumber;

    @NotNull
    private Long specialtyId;

    public SemesterPlanDto(@NotEmpty @Size(max = 200) String fileName, @NotNull Integer semesterNumber, @NotNull Long specialty_id) {
        this.fileName = fileName;
        this.semesterNumber = semesterNumber;
        this.specialtyId = specialty_id;
    }

    public SemesterPlanDto() {
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

    public Integer getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(Integer semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }
}
