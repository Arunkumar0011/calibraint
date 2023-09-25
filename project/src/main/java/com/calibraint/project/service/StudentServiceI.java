package com.calibraint.project.service;

import java.io.IOException;
import java.util.List;

import com.calibraint.project.entity.Student;

public interface StudentServiceI {

	List<Student> getStudentDetaislUsingQuery(String query) throws IOException;

}
