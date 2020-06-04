package com.app.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 200)
    private String fio;

    @Column
    private Integer personnelNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public Teacher(Long id, @Size(max = 200) String fio, Integer personnelNumber, User user, Position position) {
        this.id = id;
        this.fio = fio;
        this.personnelNumber = personnelNumber;
        this.user = user;
        this.position = position;
    }

    public Teacher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(Integer personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
