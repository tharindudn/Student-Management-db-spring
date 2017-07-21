package repository;

import model.Student;

import java.sql.SQLException;

/**
 * Created by tharindu on 7/18/17.
 */
public interface StudentRepository {


    int addstudentDetails(Student student) throws SQLException, ClassNotFoundException;

    Student checkStudent(int id) throws SQLException, ClassNotFoundException;

    int addstudentMarks(Student student) throws SQLException, ClassNotFoundException;

    void updatestudentMarks(Student student) throws SQLException, ClassNotFoundException;
    void deletestudentMarks(Student student) throws SQLException, ClassNotFoundException;
}
