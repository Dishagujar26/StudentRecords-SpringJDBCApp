package com.disha;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.disha.models.Student;
import com.disha.services.StudentServices;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

    	StudentServices serv =  context.getBean(StudentServices.class);
		Scanner sc = new Scanner(System.in);
		
		String choice;
		
      do{		
		
		System.out.println("Enter Roll Number : ");
		int r = sc.nextInt();
		
		System.out.println("Enter Name : ");
		String n = sc.next();
		
		System.out.println("Enter Precentage  : ");
		double per = sc.nextDouble();
		
		Student student = context.getBean(Student.class);
	    //creating an object for each student (every time the user type yes), spring by default create singleton bean so, we'll change the scope 
	    student.setName(n);
	    student.setPer(per);
    	student.setRoll(r);
    	serv.addStudent(student); 
    	
    	System.out.println("You Want To Add More (yes/no) ? ");
    	choice = sc.next();
    	
      }while(choice.equalsIgnoreCase("yes"));
	   System.out.println("Total Records Saved : "+serv.getCount());
	   System.out.println("So You Want To Search Student (yes/no) ? ");
	   String choice2 = sc.next();
	   
	   if(choice2.equalsIgnoreCase("yes")) {
		   System.out.println("Enter Roll No To Search :");
		   int roll = sc.nextInt();
		   String name = serv.findByID(roll);
		   if(name == null) {
			   System.out.println("Record Not Found ");
		   }
		   else {
			   System.out.println("Roll No " + roll +" Is Of "+name );
		   }
	   }
		
   }

}
