package com.app.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeacherDto {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank
    @Size(max = 255)
    private String fio;

    @NotNull
    private Integer personnelNumber;

    @NotNull
    private Long positionId;

    public TeacherDto(@NotBlank @Size(max = 255) String fio, @NotNull Integer personnelNumber, @NotNull Long position_id) {
        this.fio = fio;
        this.personnelNumber = personnelNumber;
        this.positionId = position_id;
    }

    public TeacherDto() {
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(Integer personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }
}
