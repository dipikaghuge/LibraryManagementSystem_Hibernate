package com.dipika.library.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.dipika.library.entity.Student;
import com.dipika.library.service.StudentService;
import com.dipika.library.service.StudentServiceImpl;
import com.dipika.library.validation.MyValidation;

public class StudentUserImpl implements StudentUser{

	private Scanner scanner=new Scanner(System.in);
	StudentService studentService=new StudentServiceImpl();
	IssueBookUser issueBookUser=new IssueBookUserImpl();
	//private static Integer studentId;
	//static Integer studId;
	
	private Integer studentId;
	private String studentPassword;
    //private StudentService studentService=new StudentServiceImpl();
    private BookUser bookUser=new BookUserImpl();
    //private BookIssueUser bookIssueUser=new BookIssueUserImpl();
    static Integer studId;


	public void inputRegisterStudent() 
	{
        boolean flagStudentName=true;
    	boolean flagStudentPassword=true;
    	boolean flagStudentEmailId=true;
    	boolean flagStudentContactNo=true;
        boolean flagStudentAddress=true;

    	while(flagStudentName) {
		System.out.println("Enter the Student Name::");
		String studentName=scanner.nextLine();
		if(MyValidation.isValidStudentName(studentName))
		{
			flagStudentName=false;
		while(flagStudentEmailId) {	
		System.out.println("Enter the Student Email Id::");
		String studentEmailId=scanner.next();
		if(MyValidation.isValidStudentEmailId(studentEmailId)) 
		{
			flagStudentEmailId=false;
			while(flagStudentAddress) {	
				System.out.println("Enter the Student Address::");
				String StudentAddress=scanner.next();
				if(MyValidation.isValidStudentAddress(StudentAddress)) 
				{
					flagStudentAddress=false;

		while(flagStudentContactNo)
		{
		System.out.println("Enter the Student Contact No::");
		String studentContactNo1=scanner.next();
		if(MyValidation.isValidStudentContactNo(studentContactNo1)) {
			flagStudentContactNo=false;
		while(flagStudentPassword) {	
		System.out.println("Enter the Password::");
		String password=scanner.next();
		if(MyValidation.isValidStudentPassword(password)) {
		flagStudentPassword=false;
		
		Student student=new Student();
		student.setStudentName(studentName);
		student.setStudentEmail(studentEmailId);
		student.setStudentAddress(StudentAddress);
		student.setStudentContactNo(studentContactNo1);
		student.setPassword(password);
		
		System.out.println(studentService.registerStudent(student));
		}else {
			System.out.println("Enter valid password");
		 }
		}
		}
		else {
			System.out.println("Enter valid contact no.");
		}
		}
		}else {
			System.out.println("Enter valid Address");
		}
		}
		}else {
			System.out.println("Enter valid EmailId");
		}
		}
		}else {
			System.out.println("Enter valid student name");
		}  
    	}
	}
	public void inputGetStudentById() 
	{
		System.out.println("Enter Studnet Id:");
		Integer studentId=scanner.nextInt();
         Student student=studentService.getStudentById(studentId);
        if(student!=null)
        {
	       	System.out.println("********************************************************************************************************************************************************************************");
	       	System.out.println("Student Id\t\tStudent Name\t\tStudent ContactNo\t\tStudent Email\t\tStudent Password");
	       	System.out.println("*********************************************************************************************************************************************************************************");
	 	    System.out.println("\t"+student.getStudentId()+"\t\t"+student.getStudentName()+"\t\t\t"+student.getStudentAddress()+"\t\t\t"+student.getStudentContactNo()+"\t\t\t"+student.getStudentEmail()+"\t\t"+student.getPassword());

        }
        else {
        	System.out.println("Object not found");
        }
    	
	}

	public Boolean inputStudentLogin() 
	{
		Boolean res=false;
		System.out.println("Login");
		System.out.println("Enter Student Id:");
		studentId=scanner.nextInt();
		Student student=studentService.getStudentById(studentId);
		if(student!=null) 
		{
			System.out.println("Enter Student Password:");
		    studentPassword=scanner.next();
		    if(student.getPassword().equals(studentPassword)) 
		    {
		    	studId=studentId;
		    	res=true;
		    }
		    else 
		    {
		    	res=false;
		    }
		}
		else 
		{	
		  res=false;
		}
		return res;
	}
	
	public void issueBook() 
	{
		BookUser bookUser=new BookUserImpl();		
		bookUser.inputGetAllBooks();
		System.out.println("BOOKIssue:"+studentId);
		issueBookUser.inputIssueBook(studentId);

	}
	
	public void inputGetAllRegisteredStudent() {
		List<Student> l=studentService.getAllStudents();
		Iterator<Student> itr=l.iterator();
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%-10s %-15s %-20s %-15s%n", "StudentId", "StudentName", "StudentEmailId", "StudentContactNo", "StudentAddress");
		System.out.println("----------------------------------------------------------------------");

		while (itr.hasNext()) {
		    Student s = itr.next();
		    System.out.printf("%-10d %-15s %-20s%-15s%n",
		            s.getStudentId(),
		            s.getStudentName(),
		            s.getStudentEmail(),
		            s.getStudentContactNo()
		           );
		}
		System.out.println("--------------------------------------------------------------------");
		    System.out.println();
		}
}
