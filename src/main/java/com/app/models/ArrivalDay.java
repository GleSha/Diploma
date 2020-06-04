package com.app.models;

import javax.persistence.*;

@Entity
@Table(name = "arrival_day")
public class ArrivalDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer day;

    public ArrivalDay(Long id, Integer day) {
        this.id = id;
        this.day = day;
    }

    public ArrivalDay() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
