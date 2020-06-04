package com.app.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date lessonDate;

    @Column
    private Time startTime;

    @Column
    private Time endTime;

    @Column
    @Size(max = 400)
    private String theme;

    @Column
    @Size(max = 200)
    private String homeWork;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "platoon_id")
    private Platoon platoon;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public Lesson() {
    }

    public Lesson(Long id, Date lessonDate, Time startTime, Time endTime,
                  @Size(max = 400) String theme, Subject subject, Teacher teacher,
                  Platoon platoon, Classroom classroom) {
        this.id = id;
        this.lessonDate = lessonDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.theme = theme;
        this.subject = subject;
        this.teacher = teacher;
        this.platoon = platoon;
        this.classroom = classroom;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(Date lessonDate) {
        this.lessonDate = lessonDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homeWork) {
        this.homeWork = homeWork;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Platoon getPlatoon() {
        return platoon;
    }

    public void setPlatoon(Platoon platoon) {
        this.platoon = platoon;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
