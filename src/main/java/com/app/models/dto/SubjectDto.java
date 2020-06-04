package com.app.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SubjectDto {

    private Long id;

    @NotEmpty
    @Size(max = 400)
    private String name;

    @NotEmpty
    @Size(max = 20)
    private String shortName;

    @NotEmpty
    @Size(max = 400)
    private String fileName;

    @NotNull
    private Long semesterPlanId;

    public SubjectDto(@NotEmpty @Size(max = 400) String name, @NotEmpty @Size(max = 20) String shortName, @NotEmpty @Size(max = 400) String fileName, @NotNull Long semester_plan_id) {
        this.name = name;
        this.shortName = shortName;
        this.fileName = fileName;
        this.semesterPlanId = semester_plan_id;
    }

    public SubjectDto() {
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

    public Long getSemesterPlanId() {
        return semesterPlanId;
    }

    public void setSemesterPlanId(Long semesterPlanId) {
        this.semesterPlanId = semesterPlanId;
    }
}
