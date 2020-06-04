package com.app.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterTeacherDto {

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
    private Long position_id;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public RegisterTeacherDto(@NotBlank @Size(max = 255) String fio, @NotNull Integer personnelNumber,
                              @NotNull Long position_id, @NotBlank @Size(min = 3, max = 20) String username,
                              @NotBlank @Size(min = 6, max = 40) String password) {
        this.fio = fio;
        this.personnelNumber = personnelNumber;
        this.position_id = position_id;
        this.username = username;
        this.password = password;
    }

    public Integer getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(Integer personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public Long getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Long position_id) {
        this.position_id = position_id;
    }

    public RegisterTeacherDto() {}

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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
