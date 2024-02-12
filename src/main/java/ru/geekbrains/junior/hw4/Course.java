package ru.geekbrains.junior.hw4;

import javax.persistence.*;

@Entity
@Table(name = "SchoolDB.Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private int duration;

    //region Constructors

    public Course() {
    }

    private Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    //endregion

    public static Course getNewCourse(String title, int duration) {
        return new Course(title, duration);
    }

    //region Getters

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    //endregion

    //region Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    //endregion


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
