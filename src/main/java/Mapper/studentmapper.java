package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Student;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by tharindu on 7/21/17.
 */
public class studentmapper implements RowMapper<Student> {


    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("ID"));
        student.setName(rs.getString("Stname"));
        return student;
    }
}

