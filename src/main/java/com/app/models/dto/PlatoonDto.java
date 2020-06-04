package com.app.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PlatoonDto {

    private Long id;

    @NotEmpty
    @Size(max = 10)
    private String name;

    @NotNull
    private Long platoonTypeId;

    @NotNull
    private Long arrivalDayId;

    @NotNull
    private Long specialtyId;

    @NotNull
    private Long curatorId;

    public PlatoonDto(@NotEmpty @Size(max = 10) String name, @NotNull Long platoon_type_id, @NotNull Long arrival_day_id, @NotNull Long specialty_id, @NotNull Long curator_id) {
        this.name = name;
        this.platoonTypeId = platoon_type_id;
        this.arrivalDayId = arrival_day_id;
        this.specialtyId = specialty_id;
        this.curatorId = curator_id;
    }

    public PlatoonDto() {
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

    public Long getPlatoonTypeId() {
        return platoonTypeId;
    }

    public void setPlatoonTypeId(Long platoonTypeId) {
        this.platoonTypeId = platoonTypeId;
    }

    public Long getArrivalDayId() {
        return arrivalDayId;
    }

    public void setArrivalDayId(Long arrivalDayId) {
        this.arrivalDayId = arrivalDayId;
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }

    public Long getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(Long curatorId) {
        this.curatorId = curatorId;
    }
}
