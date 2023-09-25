package com.calibraint.project.serviceimpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.calibraint.project.entity.Student;

@Service
public class StudentGetAllRecords {
	
	      private final String dataFilePath = "D:\\Practice Source Code\\Calibraint_data_file\\student.csv"; 
	    
	    
	    /**
	     * Get the all student details from CSV file
	     * 
	     * @return All student details
	     * @throws IOException
	     */
	    public List<Student> getAllRecords() throws IOException {
	        List<Student> records = new ArrayList<>();

	        BufferedReader reader = new BufferedReader(new FileReader(dataFilePath));
	        String line;
	        boolean headerSkipped = false;
	        while ((line = reader.readLine()) != null) {
	            if (!headerSkipped) {
	                headerSkipped = true;
	                continue;
	            }
	            String[] parts = line.split(",");
	            if (parts.length >= 3) {
	            	Student record = new Student();
	                record.setId(Long.parseLong(parts[0]));
	                record.setName(parts[1]);
	                record.setStatus(parts[2]);
	                records.add(record);
	            }
	        }
	        reader.close();
	        return records;
	    }
	}


