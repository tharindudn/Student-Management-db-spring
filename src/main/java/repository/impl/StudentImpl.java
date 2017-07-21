package repository.impl;

import Mapper.marksmapper;
import Mapper.studentmapper;
import model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.StudentRepository;

import javax.sql.DataSource;

import java.sql.SQLException;

/**
 * Created by tharindu on 7/18/17.
 */
public class StudentImpl implements StudentRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    public int addstudentDetails(Student student) throws SQLException, ClassNotFoundException {

        String SQL = "insert into Student (ID,Stname) values (?, ?)";
        int res = jdbcTemplateObject.update(SQL, student.getId(), student.getName());
        return res;

    }

    public Student checkStudent(int id) throws SQLException, ClassNotFoundException {

        String SQL = "select * from Student where ID = ?";
        Student student = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new studentmapper());
        return student;

    }

    public Student checkMarks(int id) throws SQLException, ClassNotFoundException {
        String SQL = "select * from Marks where ID = ?";
        Student student = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new marksmapper());

        return student;

    }


    public int addstudentMarks(Student student) throws SQLException, ClassNotFoundException {
        int[] marks = student.getMarks();
        String SQL = "insert into Marks (ID,Subject1,Subject2) values (?, ?,?)";
        int res = jdbcTemplateObject.update(SQL, student.getId(), marks[0],marks[1]);
        //System.out.println("Created Record Name = " + name + " Age = " + age);
        return res;

    }

    public int updatestudentMarks(Student student) throws SQLException, ClassNotFoundException {
        int[] marks = student.getMarks();
        String SQL = "update Marks set Subject1=?,Subject2=? where ID=?";
        int res=jdbcTemplateObject.update(SQL, marks[0],marks[1],student.getId());
        System.out.println("Updated Record with ID = " + student.getId());
        return res;
    }

    public int deletestudentMarks(int id) throws SQLException, ClassNotFoundException {
        String SQL = "delete from Marks where ID=?";
        int res=jdbcTemplateObject.update(SQL,id);
        System.out.println("Delete Record with ID = " + id);
        return res;

    }
}
