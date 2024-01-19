package com.StudentCurdOpeartion.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentCurdOpeartion.entity.Student;
import com.StudentCurdOpeartion.repository.StudentRepository;

@RestController
public class HomeController {
	
	@Autowired
	 private StudentRepository studentRepository;
	
	 @GetMapping("/")
	 public String Home() 
	 {
		 return "welcome to springboot Curdoperation!!";
		 
	 }
	 // Handler for creating new record in database
	 @PostMapping("/saveStudent")
	 public Student saveData(@RequestBody Student student) {
		  studentRepository.save(student);
		  return student;
		  
	 }
	 // Handler for fetching all data in database
	  @GetMapping("/getAllStudents")
	  public List<Student> getAll() {
		 List<Student> studentList =  studentRepository.findAll();
		   return studentList;
	  }
	  
	  // Handler for fetching a single record
	  @GetMapping("/getStudent/{rollNo}")
	  public Student getStudentData(@PathVariable int rollNo) {
		  Optional<Student> student = studentRepository.findById(rollNo);
		     Student student1  = student.get();
		   return student1;
		       
	  }

	  // Handler for delete a particular record from database
	    @DeleteMapping("/deleteStudent/{rollNo}")
	    public String deleteStudent(@PathVariable int rollNo) {
	             Student student =  studentRepository.findById(rollNo).get();
	           if(student != null) {
	            	 studentRepository.delete(student);
	           }
	            	  return "Deleted successfully";  
	    }	
	    
	    // Handler for updating a student 
	     @PutMapping("/UpdateStudent/{rollNo}")
	    public String updateStudent(@PathVariable int rollNo,@RequestBody Student student) {
	    	Optional<Student>  stu = studentRepository.findById(rollNo) ; 
	    	
	    	   if(stu.isPresent()) {
	    		 Student existStudent = stu.get();
	    		    existStudent.setName(student.getName());
	    		    existStudent.setCity(student.getCity());
	    		    existStudent.setAddress(student.getAddress());   
	    		    studentRepository.save(existStudent);
	    		    
	    	//	   System.out.println("Received Address : " + existStudent.getAddress()  );
	    		   System.out.println("Received Student Object: " + student.toString());

	    		    return "Student Details against Id "+rollNo +" updated";
	    		 
	    	   }
	    	   else
	    	   return "Student details does not exist for rollNo " + rollNo ;
	    }
	       
}
