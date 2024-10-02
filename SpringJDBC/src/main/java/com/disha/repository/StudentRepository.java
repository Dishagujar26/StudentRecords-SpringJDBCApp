package com.disha.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.disha.models.Student;

@Repository
public class StudentRepository {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public StudentRepository(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void save(Student s) {
		String sql = "Insert into Students Values (?,?,?)";
		// jitne placeholder utne data value in update  
		int count = jdbcTemplate.update(sql,s.getRoll(),s.getName(),s.getPer());
		System.out.println("Record inserted : "+count);
	}
	
	// main ---- service  ---- repository 
	
	public int getCount(){
		String sql = "Select count(*) from Students";
		int count = jdbcTemplate.queryForObject(sql,Integer.class);
		return count;
	}
	

	public String findByID(int roll) {
		String name= "";
		String sql =  "Select name from Students where roll = ?";
		try {
			name = jdbcTemplate.queryForObject(sql, String.class,roll);
		}
		catch (DataAccessException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			name = null;
		}
		finally {
			return name;
		}
	}
}
