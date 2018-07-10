package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dto.Student;
import com.app.repository.AppRepository;

@Controller
public class AppController {

	@Autowired
	AppRepository appRepository;
	
	@GetMapping("/hello")
	public @ResponseBody String sayHello() {
		return "hello";
	}
	
	@PostMapping("insertData")
	public @ResponseBody int insertData(@RequestBody Student student){
		System.out.println(student);
		return appRepository.insertDataFromView(student);
	}
	
	@GetMapping("/getAllData")
	public @ResponseBody List<Student> getDataFromDb(){
		
		return appRepository.getDataFromDb();
	}
	
	@GetMapping("/getQualifications")
	public @ResponseBody Map<String,Object> getQualifications(){
		
		return appRepository.getQualifications();
	}
}
