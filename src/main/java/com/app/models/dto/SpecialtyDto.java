package com.app.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SpecialtyDto {

    private Long id;

    @NotEmpty
    @Size(max = 20)
    private String code;

    @NotEmpty
    @Size(max = 400)
    private String name;

    @NotNull
    private Long academicPlanId;

    public SpecialtyDto(@NotEmpty @Size(max = 20) String code, @NotEmpty @Size(max = 400) String name, @NotNull Long academic_plan_id) {
        this.code = code;
        this.name = name;
        this.academicPlanId = academic_plan_id;
    }

    public SpecialtyDto() {
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

    public Long getAcademicPlanId() {
        return academicPlanId;
    }

    public void setAcademicPlanId(Long academicPlanId) {
        this.academicPlanId = academicPlanId;
    }
}
