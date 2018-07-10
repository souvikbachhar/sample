package com.app.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dto.Student;
import com.app.service.AppService;

@Repository
public class AppRepository {

	@Autowired
	AppService appService;
	
	public int insertDataFromView(Student student) {
		System.out.println(student.toString());
		return appService.insertData(student);
	}

	public List<Student> getDataFromDb() {
		
		return appService.getDataFromDb();
	}

	public Map<String, Object> getQualifications() {
		
		return appService.getQualifications();
	}

}
