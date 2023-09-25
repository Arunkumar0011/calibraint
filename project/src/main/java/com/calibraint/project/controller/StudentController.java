package com.calibraint.project.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calibraint.project.entity.Student;
import com.calibraint.project.service.StudentServiceI;

@RestController
public class StudentController {
	
	@Autowired
	StudentServiceI studentServiceI;
	
	 @GetMapping("/getstudent")
	    public List<Student> getStudentDetaislUsingQuery(@RequestParam String query) throws IOException {
		 List<Student> studentList = studentServiceI.getStudentDetaislUsingQuery(query);
	     return studentList;
	}

}
