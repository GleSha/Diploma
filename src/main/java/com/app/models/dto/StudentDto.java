package com.app.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDto {

    private Long id;

    @NotBlank
    @Size(max = 255)
    private String fio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Size(min = 8, max = 8)
    private Integer recordBookNumber;

    @NotNull
    private Long platoonId;

    public StudentDto(@NotBlank @Size(max = 255) String fio, @NotNull @Size(min = 8, max = 8) Integer recordBookNumber, @NotNull Long platoon_id) {
        this.fio = fio;
        this.recordBookNumber = recordBookNumber;
        this.platoonId = platoon_id;
    }

    public StudentDto() {
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getRecordBookNumber() {
        return recordBookNumber;
    }

    public void setRecordBookNumber(Integer recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    public Long getPlatoonId() {
        return platoonId;
    }

    public void setPlatoonId(Long platoonId) {
        this.platoonId = platoonId;
    }
}
