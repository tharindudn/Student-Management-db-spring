package repository.impl;

import connection.DBConnection;
import model.Student;
import repository.StudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tharindu on 7/18/17.
 */
public class StudentImpl implements StudentRepository {
    Connection con;

    public int addstudentDetails(Student student) throws SQLException, ClassNotFoundException {
        String quary = "insert into Student(ID,Stname) Values(?,?)";

        PreparedStatement ps = DBConnection.getConnectionToDB().prepareStatement(quary);
        ps.setInt(1, student.getId());
        ps.setString(2, student.getName());
        int res = ps.executeUpdate();
        return res;
    }

    public Student checkStudent(int id) throws SQLException, ClassNotFoundException {
        String quary = "SELECT * FROM Student WHERE ID=?";
        PreparedStatement ps = DBConnection.getConnectionToDB().prepareStatement(quary);
        ps.setInt(1, id);
        ResultSet rst = null;
        Student student = new Student();
        try {
           rst = ps.executeQuery();


            if (rst.next()) {
                student.setId(rst.getInt(1));
                student.setName(rst.getString(2));
                return student;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return student;
    }

    public int[] checkMarks(int id) throws SQLException, ClassNotFoundException {
        String quary = "SELECT * FROM Marks WHERE ID=?";
        PreparedStatement ps = DBConnection.getConnectionToDB().prepareStatement(quary);
        ps.setInt(1, id);
        ResultSet rst = null;
        int[] marks = new int[2];
        try {
            rst = ps.executeQuery();


            if (rst.next()) {
                marks[0] = rst.getInt(2);
                marks[1] = rst.getInt(3);
                return marks;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return marks;
    }


    public int addstudentMarks(Student student) throws SQLException, ClassNotFoundException {
        int[] marks = student.getMarks();
        String quary = "insert into Marks(ID,Subject1,Subject2) Values(?,?,?)";
        PreparedStatement ps = DBConnection.getConnectionToDB().prepareStatement(quary);
        ps.setInt(1,student.getId());
        ps.setInt(2,marks[0]);
        ps.setInt(3,marks[1]);
        int res = ps.executeUpdate();
        return res;
    }
    public int updatestudentMarks(Student student) throws SQLException, ClassNotFoundException {
        int[] marks = student.getMarks();
        String quary = "update Marks set Subject1=?,Subject2=? where ID=?";
        PreparedStatement ps = DBConnection.getConnectionToDB().prepareStatement(quary);
        ps.setInt(1,marks[0]);
        ps.setInt(2,marks[1]);
        ps.setInt(3,student.getId());
        int res = ps.executeUpdate();
        return res;
    }
    public int deletestudentMarks(int id) throws SQLException, ClassNotFoundException {

        String quary = "delete from Marks where ID=?";
        PreparedStatement ps = DBConnection.getConnectionToDB().prepareStatement(quary);
        ps.setInt(1,id);
        int res = ps.executeUpdate();
        return res;
    }
}
