package com.disha.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disha.models.Student;
import com.disha.repository.StudentRepository;

@Service

public class StudentServices {
	// here we will connect both Repository and main  class ,from  main  we will call a  method of service because they can talk 
	//and then in that method we will call repository classes save method 
	
	private StudentRepository repo;
	
    //when there is only single constructor @autowired is optional 
	
	@Autowired
	public StudentServices(StudentRepository repo) {
		
		this.repo = repo;
	}
	
	public void addStudent(Student s) {
		repo.save(s);
	}
	public int getCount() {
		return repo.getCount();
	}
	public String findByID(int roll) {
		return repo.findByID(roll);
	}
	

}
