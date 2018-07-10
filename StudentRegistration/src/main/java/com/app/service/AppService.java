package com.app.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.app.dto.Student;
import com.app.rowmapper.StudentRowMapper;

@Service
public class AppService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("myOracleDs")
	DataSource myDs;
	
	public int insertData(Student student) {
		try{
			final String sql= "insert into student_details values(?,?,?,?,?)";
			DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
			Date studentDOB = format.parse(student.getDob());
			jdbcTemplate.setDataSource(myDs);
			jdbcTemplate.update(sql, new Object[]{student.getName(),studentDOB,student.getQualification(),student.getAddress(),student.getNumber()});
			return 1;
		}
		catch(Exception e)
		{	e.printStackTrace();
			return 0;
		}
		
	}

	public List<Student> getDataFromDb() {
		try{
			final String sql= "select * from student_details";
			jdbcTemplate.setDataSource(myDs);
			return jdbcTemplate.query(sql, new StudentRowMapper());
		}
		catch(Exception e)
		{
			return new ArrayList();
		}
		
	}

	public Map<String, Object> getQualifications() {
		Map<String,Object> result= new LinkedHashMap<String,Object>();
		List<Map<String,Object>> data= new ArrayList<Map<String,Object>>();
		try{
			
			final String sql= "select * from STUDENT_QUALIFICATION";
			jdbcTemplate.setDataSource(myDs);
			 jdbcTemplate.query(sql, new RowMapper<Map<String,Object>>(){

				@Override
				public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					while(rs.next())
					{
						Map<String,Object> res= new LinkedHashMap<String,Object>();
						res.put("QualificationId",rs.getString("QUALIFICATION_ID"));
						res.put("QualificationCode",rs.getString("QUALIFICATION_CODE"));
						data.add(res);
					}
					return null;
				}
				 
			 });
		}
		catch(Exception e){
			return new HashMap<String,Object>();
		}
		result.put("Qualifications",data);
		return result;
	}

}
