package model;


import javax.persistence.*;

/**
 * Created by tharindu on 7/17/17.
 */
@Entity
@Table(name="StudentDetails")
public class Student {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "Stname")
    private String name;
    @Column(name="Subject1")
    int marks1;
    @Column(name="Subject2")
    int marks2;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getMarks1() {
        return marks1;
    }

    public void setMarks1(int marks1) {
        this.marks1 = marks1;
    }

    public int getMarks2() {
        return marks2;
    }

    public void setMarks2(int marks2) {
        this.marks2 = marks2;
    }
}
