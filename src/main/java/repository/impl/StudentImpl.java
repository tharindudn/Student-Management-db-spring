package repository.impl;

import model.Student;
import org.springframework.orm.hibernate3.HibernateTemplate;
import repository.StudentRepository;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tharindu on 7/18/17.
 */
public class StudentImpl implements StudentRepository {
    private DataSource dataSource;
    HibernateTemplate template;
    Student retrievestudent;
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

    }


    public int addstudentDetails(Student student){
        int res =(Integer) template.save(student);
        return res;
    }

    public Student checkStudent(int id){
        Student student=(Student) template.get(Student.class,id);
        return student;

    }


    public int addstudentMarks(Student student){

        template.update(student);
        return student.getId();
    }

    public void updatestudentMarks(Student student){
        retrievestudent=(Student) template.get(Student.class,student.getId());
        student.setName(retrievestudent.getName());
        template.update(student);

    }

    public void deletestudentMarks(Student student){
        template.delete(student);


    }
}
