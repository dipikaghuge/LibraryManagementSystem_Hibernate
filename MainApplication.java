package com.dipika.library.presentation;

import java.util.Scanner;
import com.dipika.library.validation.MyValidation;

public class MainApplication 
{
	public static void main(String[] args) 
	{
		     Integer choice=0;
		     Boolean login;
	    	 boolean flagAdminName=true;
	    	 boolean flagAdminPassword=true;
	    	 String adminId;
	    	 String adminPassword;
	    	 Scanner scanner= new Scanner(System.in);
		    
	        BookUser bookUser=new BookUserImpl();
	        IssueBookUser issueBookuser=new IssueBookUserImpl();
	        StudentUser studentUser=new StudentUserImpl();
	       
	        while(choice!=3)
	        {
	        	System.out.println("_______________________________________________");
		    	System.out.println();
		    	System.out.println("\t AbsoluteMinds Library ");
		    	System.out.println("_______________________________________________");
		    	System.out.println("1.Admin:: ");
		    	System.out.println("2.Student:: ");
		    	System.out.println("3.Exit");
		    	System.out.println("You want to login(Admin/Student):");
		    	choice =scanner.nextInt();	
		    	System.out.println("_______________________________________________");
	    	    switch(choice)
	    	    {
	    	   case 1:
	    	    	System.out.println("_______________________________________________");
	    	    	while (flagAdminName) {
	    	    	    System.out.println("Enter Admin Id:");
	    	    	    adminId = scanner.next();

	    	    	    if (MyValidation.isValidAdminName(adminId) && adminId.equals("admin")) {
	    	    	        flagAdminName = false;

	    	    	        while (flagAdminPassword) {
	    	    	            System.out.println("Enter Admin Password:");
	    	    	            adminPassword = scanner.next();

	    	    	            if (MyValidation.isValidAdminPassword(adminPassword) && adminPassword.equals("Admin")) {
	    	    	                flagAdminPassword = false;
	    	    	                System.out.println("_______________________________________________");
	    	    	    
		    while(choice!=11)
		    {
		    	System.out.println("_______________________________________________");
		    	System.out.println();
		    	System.out.println("\t Admin Functionality");
		    	System.out.println("_______________________________________________");
		    	System.out.println("1.Add New Book");
		    	System.out.println("2.Update Stock");
		    	System.out.println("3.Search Book");
		    	System.out.println("4.Display unreturned Book");
		    	System.out.println("5.Display UnIssued Book Details");
		    	System.out.println("6.Display Fine Details");
		    	System.out.println("7.Approved Book-Issue");
		    	System.out.println("8.Approved Book-Return");
				System.out.println("9.View Student Profile ById");
				System.out.println("10.Show All Students Profile");
		    	System.out.println("11.Admin Exit");
		    	System.out.println("_______________________________________________");
		    	System.out.println("Please Enter Your Choice");
		    	choice =scanner.nextInt();			    	
		    	switch(choice)
		    	{
			    case 1:
			    	bookUser.inputAddBook();
			    	break;
			    case 2: 	
			    	bookUser.inputUpdateStock();
			    	break;
			    case 3: 	
			      while(choice!=6)
		          {
			      System.out.println("_______________________________________________");
				  System.out.println("Search Book");
			      System.out.println("_______________________________________________");
				  System.out.println("1.Search Book by Id");
				  System.out.println("2.Search Book by Name");
				  System.out.println("3.Search Book by Type");
				  System.out.println("4.Search Book by AuthorName");
				  System.out.println("5.Show All Book Details");
				  System.out.println("6.Exit");
			      System.out.println("_______________________________________________");
			      System.out.println("Please Enter Your Choice");
			      choice =scanner.nextInt();			    	
				  switch(choice)
				  {
				    case 1:
					    bookUser.inputGetBookById();
					    break;
					case 2:
					    bookUser.inputGetBookByName();
					    break;
					case 3: 	
					    bookUser.inputGetBookByType();
					    break;
					case 4: 	
					    bookUser.getBookByAuthorName();
					    break;
				    case 5: 	
				    	bookUser.inputGetAllBooks();
				    	break;
				    case 6:
					    System.out.println("Exit");
					    break;	
				    }//switch close				    	
				    }//while close 
			    break;
			    case 4:	
			    	issueBookuser.displayReturnBook();
			    	System.out.println("Display unreturned Book ");
			    	break;
			    case 5:
			    	issueBookuser.displayUnIssueBook();
					System.out.println("View UnIssuBook Details..");
			    	break;
			    case 6:
			    	//issueBookuser.inputPayFine();
			    	System.out.println("Display Fine Details");
			    	break;
			    case 7:
			    	//issueBookuser.inputConfirmIssueBook();
			    	issueBookuser.inputApprovedIssueBook();
			    	break;
			    case 8:
			    	issueBookuser.displayReturnBook();
					System.out.println("confirm return book!!");
			    	break;

			    case 9:
			    	studentUser.inputGetStudentById();
			    	break;
			    case 10:
			    	studentUser.inputGetAllRegisteredStudent();
			    	break;
				 case 11:
				    	System.out.println("Admin exit succesfully..!");	
	             }//switch case end
	            }//while loop end
	        
	    	 }else{
	        	    System.out.println("Invalid AdminPassword ");
	        	  }
	    	}
	    }else{
	           System.out.println("Invalid AdminId ");
	         }//else end
	    	 
	    	    	
		     System.out.println("Do you want to continue... ");
	         String ch=scanner.next();
	         if(ch.equals("no"))
	         {
	        	 System.out.println("Admin User does not want to continue.... ..Thank you");
	        	 break;
	         }
	    	    	
	    	   }
	    		   
	        break;
	    	case 2:
			       System.out.println("_______________________________________________");
	    		   System.out.println("1. Register Student");
	    		   System.out.println("2. Login Student");
				   System.out.println("_______________________________________________");
	    		   System.out.println("Enter the choice:");
	    	       choice =scanner.nextInt();
	    	    switch (choice) {
				case 1:
				    System.out.println("_______________________________________________");
					System.out.println("");
					System.out.println("Student Registration Page");
					System.out.println("_______________________________________________");
					studentUser.inputRegisterStudent();
					//break;
				case 2:			
				    System.out.println("_______________________________________________");
					System.out.println("");
					System.out.println("Student Login Page");
					System.out.println("_______________________________________________");

				      login=studentUser.inputStudentLogin();
					  if(login){
						while(choice!=7)
					    {
							System.out.println("_______________________________________________");
					    	System.out.println();
					    	System.out.println("\t Student Functionality");
					    	System.out.println("_______________________________________________");
							System.out.println("1.Search Book");
							System.out.println("2.Issue Book");
							System.out.println("3.Return Book");
							System.out.println("4.Fine Details");
							System.out.println("5.Pay Fine");
							System.out.println("6.View Issue Book Details");
							System.out.println("7.Student Exit");
					    	System.out.println("_______________________________________________");
					    	System.out.println("Please Enter Your Choice");
					    	choice =scanner.nextInt();		
					    	switch(choice)
					    	{
						    case 1: 	
						    	while(choice!=6)
							    {
									System.out.println("_______________________________________________");
							    	System.out.println("");
									System.out.println("Search Book By");
									System.out.println("_______________________________________________");
									System.out.println("1.Get Book by Name.");
									System.out.println("2.Get Book by Type");
									System.out.println("3.Get Book by Id");
									System.out.println("4.Get Book by AuthorName");
									System.out.println("5.Show All Books Details");
							    	System.out.println("6.Exit.. ");
							    	System.out.println("_______________________________________________");
							    	System.out.println("Please Enter Your Choice");
							    	choice =scanner.nextInt();		
							    	switch(choice)
							    	{
								    case 1:
								    	bookUser.inputGetBookByName();
								    	break;
								    case 2: 	
								    	bookUser.inputGetBookByType();
								    	break;
								    case 3: 	
								    	bookUser.inputGetBookById();
								    	break;
								    case 4: 	
								    	bookUser.getBookByAuthorName();
								    	break;
								    case 5: 	
								    	bookUser.inputGetAllBooks();
								    	break;
								    case 6:
								    	System.out.println("Logout");
								    	break;
							    	}				    	
							    } 
						    	 break;
						    case 2: 
						    	studentUser.issueBook();
								System.out.println("Issue Book..");
						    	break;
						    case 3:
						    	//issueBookuser.displayReturnBook();
						    	issueBookuser.inputReturnBook();
								System.out.println("Return Book...");
						    	break;
						    case 4:
								System.out.println("View Fine Details..");
						    	break;
						    case 5:
						    	//issueBookuser.inputPayFine();
								System.out.println("Pay fine..");
						    	break;
						    case 6:
						    	issueBookuser.inputGetIssuedBook();
						    	System.out.println(" view issue Book details.!");
                                 break;
						    case 7:
						    	System.out.println(" Student exit successfully.!");
							}
					    }
					  //}
					  System.out.println("Do you want to continue... ");
				    	String ch1=scanner.next();
						 if(ch1.equals("no"))
						 {
							 System.out.println("Student user does not want to continue....thank you!!");
				    		 //System.exit(0);
							 break;
						 }	 
				  }
	    	    }
  	       break;	 	  	   	 
  	       case 3:
			    	System.out.println("_______________________________________________");
			    	System.out.println("");
			    	System.out.println("Application Terminated.!!!");
			    	System.out.println("_______________________________________________");
			    	System.out.println("_______________________________________________");
			    break;
	        }
	   }
	 }
}