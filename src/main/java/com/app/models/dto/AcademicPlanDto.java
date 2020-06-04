package com.app.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

public class AcademicPlanDto {

    private Long id;

    @NotEmpty
    @Size(max = 255)
    private String fileName;

    @NotNull
    private Date dateStart;

    @NotNull
    private Date dateEnd;

    public AcademicPlanDto(@NotEmpty @Size(max = 255) String fileName, @NotNull Date dateStart, @NotNull Date dateEnd) {
        this.fileName = fileName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public AcademicPlanDto() {
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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
