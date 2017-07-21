package Mapper;

import model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tharindu on 7/21/17.
 */
public class marksmapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("ID"));
        int marks[] = new int[2];
        marks[0] = (rs.getInt("Subject1"));
        marks[1] = (rs.getInt("Subject2"));
        student.setMarks(marks);
        return student;
    }
}
