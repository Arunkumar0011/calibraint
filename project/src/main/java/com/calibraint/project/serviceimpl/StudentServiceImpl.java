package com.calibraint.project.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calibraint.project.entity.Student;
import com.calibraint.project.exception.InvalidQueryException;
import com.calibraint.project.exception.StudentDataNotFoundException;
import com.calibraint.project.service.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI{
	

	    /**
	     * Get the student details from CSV file based on the SQL query.
	     *  
	     * @param  SQL Query.
	     * @return List of Student details.
	     * @throws InvalidQueryException If query invalid as per our business  logics will throw the exception.
	     * @throws StudentDataNotFoundException If student details empty as per our business logics will throw the exception.
	     * 
	     */
	    public List<Student> getStudentDetaislUsingQuery(String query) throws IOException {
	       
	    	//Get All records from file
	    	StudentGetAllRecords studentGetAllRecords = new StudentGetAllRecords();
	    	List<Student> allRecords = studentGetAllRecords.getAllRecords();

	        String[] parts = query.split(" ");
	        if (parts.length != 8) {
	            throw new InvalidQueryException("Invalid query format");
	        }

	        String columnName = parts[5];
	        String operator = parts[6];
	        String value = parts[7];

	        List<Student> data = allRecords.stream()
	                .filter(record -> matchesQuery(record, columnName, operator, value))
	                .collect(Collectors.toList());
	        
	        //Data is empty throw the exception
	        if(data.isEmpty()) {
	        	 throw new StudentDataNotFoundException("No data");
	        }
	        return data;
	    }

	    private boolean matchesQuery(Student record, String columnName, String operator, String value) {
	        switch (columnName.toLowerCase()) {
	            case "id":
	                return operator.equals("=") && record.getId().toString().equals(value);
	            case "name":
	                return operator.equals("=") && record.getName().equals(value.replace("'", ""));
	            case "description":
	                return operator.equals("=") && record.getStatus().equals(value.replace("'", ""));
	            default:
	                return false;
	        }
	    }
	}

