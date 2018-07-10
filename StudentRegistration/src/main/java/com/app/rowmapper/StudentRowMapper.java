package com.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.dto.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setName(rs.getString("student_name"));
		student.setAddress(rs.getString("student_address"));
		student.setDob(rs.getString("student_dob"));
		student.setQualification(rs.getString("student_qualification"));
		student.setNumber(Long.parseLong((rs.getString("student_number")+"")));
		return student;
	}

}
