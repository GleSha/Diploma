package com.app.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterStudentDto {

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
    private Long platoon_id;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;


    public RegisterStudentDto(@NotBlank @Size(max = 255) String fio, @NotNull @Size(min = 8, max = 8) Integer recordBookNumber,
                              @NotNull Long platoon_id, @NotBlank @Size(min = 3, max = 20) String username,
                              @NotBlank @Size(min = 6, max = 40) String password) {
        this.fio = fio;
        this.recordBookNumber = recordBookNumber;
        this.platoon_id = platoon_id;
        this.username = username;
        this.password = password;
    }

    public RegisterStudentDto() {}

    public String getFio() {
        return fio;
    }

    public Integer getRecordBookNumber() {
        return recordBookNumber;
    }

    public void setRecordBookNumber(Integer recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    public Long getPlatoon_id() {
        return platoon_id;
    }

    public void setPlatoon_id(Long platoon_id) {
        this.platoon_id = platoon_id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
