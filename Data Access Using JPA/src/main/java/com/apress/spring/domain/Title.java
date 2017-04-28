package com.apress.spring.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by HeroDishonest on 28.04.2017.
 */
@Entity
@Table(name = "titl1")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String course;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_course")
    List<Journal> list = new ArrayList<>();

    public Long getId_course() {
        return id;
    }

    public void setId_course(Long id_course) {
        this.id = id_course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<Journal> getList() {
        return list;
    }

    public void setList(List<Journal> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Title)) return false;

        Title title = (Title) o;

        if (getId_course() != null ? !getId_course().equals(title.getId_course()) : title.getId_course() != null)
            return false;
        return getCourse() != null ? getCourse().equals(title.getCourse()) : title.getCourse() == null;
    }

    @Override
    public int hashCode() {
        int result = getId_course() != null ? getId_course().hashCode() : 0;
        result = 31 * result + (getCourse() != null ? getCourse().hashCode() : 0);
        return result;
    }
}
