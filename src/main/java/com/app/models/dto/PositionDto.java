package com.app.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PositionDto {

    private Long id;

    @NotEmpty
    @Size(max = 255)
    private String name;

    public PositionDto() {
    }

    public PositionDto(@NotEmpty @Size(max = 255) String name) {
        this.name = name;
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
}
