package com.app.models;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "platoon")
public class Platoon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 10)
    private String name;

    @ManyToOne
    @JoinColumn(name = "platoon_type_id")
    private PlatoonType platoonType;

    @ManyToOne
    @JoinColumn(name = "arrival_day_id")
    private ArrivalDay arrivalDay;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @ManyToOne
    @JoinColumn(name = "curator_id")
    private Teacher curator;

    public Platoon(Long id, @Size(max = 10) String name, PlatoonType platoonType, ArrivalDay arrivalDay, Specialty specialty, Teacher curator) {
        this.id = id;
        this.name = name;
        this.platoonType = platoonType;
        this.arrivalDay = arrivalDay;
        this.specialty = specialty;
        this.curator = curator;
    }

    public ArrivalDay getArrivalDay() {
        return arrivalDay;
    }

    public void setArrivalDay(ArrivalDay arrivalDay) {
        this.arrivalDay = arrivalDay;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }

    public Platoon() {}

    public PlatoonType getPlatoonType() {
        return platoonType;
    }

    public void setPlatoonType(PlatoonType platoonType) {
        this.platoonType = platoonType;
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
