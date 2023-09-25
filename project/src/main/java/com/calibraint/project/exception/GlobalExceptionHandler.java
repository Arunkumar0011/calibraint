package com.calibraint.project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.calibraint.project.entity.CommonException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = InvalidQueryException.class)
	public  ResponseEntity<CommonException> InvalidQueryException(){
		LocalDateTime localDateTime = LocalDateTime.now();
		CommonException CommonException = new CommonException("Invalid Query", localDateTime);
		return new ResponseEntity<CommonException>(CommonException, HttpStatus.BAD_REQUEST); 
	} 
	
	@ExceptionHandler(value = StudentDataNotFoundException.class)
	public  ResponseEntity<CommonException> StudentDataNotFoundException(){
		LocalDateTime localDateTime = LocalDateTime.now();
		CommonException CommonException = new CommonException("Student Details Not Found", localDateTime);
		return new ResponseEntity<CommonException>(CommonException, HttpStatus.NOT_FOUND); 
	} 
		
}
