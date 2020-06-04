package com.app.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 100)
    private String name;

    public Classroom(Long id, @Size(max = 100) String name) {
        this.id = id;
        this.name = name;
    }

    public Classroom(@Size(max = 100) String name) {
        this.name = name;
    }

    public Classroom() {
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
