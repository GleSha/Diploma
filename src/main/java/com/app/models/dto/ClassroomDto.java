package com.app.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClassroomDto {

    @NotBlank
    @Size(max = 100)
    private String name;

    private Long id;

    public ClassroomDto(@NotBlank String name) {
        this.name = name;
    }

    public ClassroomDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
