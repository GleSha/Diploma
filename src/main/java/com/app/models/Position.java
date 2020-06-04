package com.app.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 255)
    private String name;

    public Position(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Position() {}

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
