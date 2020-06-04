package com.app.models;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fio;

    @Column
    private Integer recordBookNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "platoon_id")
    private Platoon platoon;

    public Student(Long id, String fio, Integer recordBookNumber, User user, Platoon platoon) {
        this.id = id;
        this.fio = fio;
        this.recordBookNumber = recordBookNumber;
        this.user = user;
        this.platoon = platoon;
    }

    public Student() {
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

    public Integer getRecordBookNumber() {
        return recordBookNumber;
    }

    public void setRecordBookNumber(Integer recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Platoon getPlatoon() {
        return platoon;
    }

    public void setPlatoon(Platoon platoon) {
        this.platoon = platoon;
    }
}
