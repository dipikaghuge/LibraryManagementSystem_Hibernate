package com.dipika.library.presentation;

import java.util.Scanner;
import com.dipika.library.validation.MyValidation;

public class Library {
	public static void main(String[] args) {
		Integer userType = 0;
		Scanner scanner = new Scanner(System.in);

		while (userType != 3) {
			System.out.println("_______________________________________________");
			System.out.println();
			System.out.println("\t AbsoluteMinds Library ");
			System.out.println("_______________________________________________");
			System.out.println("1.Admin:: ");
			System.out.println("2.Student:: ");
			System.out.println("3.Exit");
			System.out.println("You want to login(Admin/Student):");
			userType =scanner.nextInt();	
			System.out.println("_______________________________________________");

			switch (userType) {
			case 1:
				adminMenu();
				break;
			case 2:
				studentMenu();
				break;
			case 3:
				System.out.println("_______________________________________________");
				System.out.println("");
				System.out.println("\t Application Terminated..!!!");
				System.out.println("_______________________________________________");
				System.out.println("_______________________________________________");
				break;
			default:
				System.out.println("Invalid user type. Please try again.");
			}//switch case end
		}//while loop end
	}//main method end

	private static void adminMenu() 
	{
		while(true)
		{

			System.out.println("");
			System.out.println("____________ADMIN USER______________________");
			boolean flagAdminName=true;
			boolean flagAdminPassword=true;
			String adminId;
			String adminPassword;

			Scanner scanner= new Scanner(System.in);
			while(flagAdminName) {
				System.out.println("Enter User name:");
				adminId=scanner.next();
				if(MyValidation.isValidAdminName(adminId)&& adminId.equals("admin")) {
					flagAdminName=false;
					while(flagAdminPassword) {
						System.out.println("Enter Password:");
						adminPassword=scanner.next();

						if(MyValidation.isValidAdminPassword(adminPassword)&&  adminPassword.equals("Admin")) {


							flagAdminPassword=false;
							Integer adminChoice = 0;
							BookUser bookUser=new BookUserImpl();
							IssueBookUser bookIssueUser=new IssueBookUserImpl();
							StudentUser studentUser=new StudentUserImpl();

							while(adminChoice!=11) {
								System.out.println("_______________________________________________");
								System.out.println();
								System.out.println("\t Admin Functionality");
								System.out.println("_______________________________________________");
								System.out.println("1.Add New Book");
								System.out.println("2.Update Book Stock");
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
								adminChoice = scanner.nextInt(); 

								switch(adminChoice) {
								case 1:
									bookUser.inputAddBook();
									System.out.println("Added New Book Successfully");
									break;
								case 2:
									bookUser.inputUpdateStock();            	 
									break; 
								case 3:
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
									Integer choice=scanner.nextInt();
									switch(choice){
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
									}
									break;
								case 4:          
									bookIssueUser.displayReturnBook();
									System.out.println("Display unreturned Book ");
									break;	

								case 5:            	
									bookIssueUser.displayUnIssueBook();
									System.out.println("View UnIssuBook Details..");
									break;
								case 6:
									//issueBookuser.inputPayFine();
									System.out.println("Display Fine Details");
									break;
								case 7:
									 //bookIssueUser.inputConfirmIssueBook();
					            	 bookIssueUser.inputApprovedIssueBook();            	 
									break;
								case 8:            	 
									//bookIssueUser.inputConfirmReturnBook();
									bookIssueUser.inputApprovedReturnBook();
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
			}
			System.out.println("Do you want to continue... ");
			String ch=scanner.next();
			if(ch.equals("no"))
			{
				System.out.println("Admin User does not want to continue.... ..Thank you");
				break;
			}
		}
	}//admin method end
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
	private static void studentMenu() 
	{
		while(true)
		{
			System.out.println("____________STUDENT USER______________________");
			System.out.println("");
			System.out.println("\t 1.Student Registration Page");
			System.out.println("\t 2.Student Login Page");
			System.out.println("_______________________________________________");

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the choice");
			Integer choice=scanner.nextInt();

			Integer studentChoice = 0;
			StudentUser studentUser=new StudentUserImpl();
			BookUser bookUser=new BookUserImpl();
			IssueBookUser issueBookuser=new IssueBookUserImpl(); 
			switch(choice) {
			case 1:
				studentUser.inputRegisterStudent();
				System.out.println("Student Registration Done Successfully");

			case 2:
				Boolean login;
				login= studentUser.inputStudentLogin();

				if(login==true) 
				{
					System.out.println("Student Login Done Successfully");
					while(studentChoice!=7) {
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
						studentChoice = scanner.nextInt();
						switch(studentChoice) {
						case 1:
							System.out.println("_______________________________________________");
							System.out.println("");
							System.out.println("Search Book By");
							System.out.println("_______________________________________________");
							System.out.println("1.Get Book by Id.");
							System.out.println("2.Get Book by Name");
							System.out.println("3.Get Book by Type");
							System.out.println("4.Get Book by AuthorName");
							System.out.println("5.Show All Books Details");
							System.out.println("6.Exit.. ");
							System.out.println("_______________________________________________");
							System.out.println("Please Enter Your Choice");
							Integer choice1=scanner.nextInt();
							switch(choice1) {
							case 1:
								bookUser.inputGetBookById();
								System.out.println("Search Book by Id");
								break;
							case 2:
								bookUser.inputGetBookByName();
								System.out.println("Search Book by Name");
								break;	
							case 3:
								bookUser.inputGetBookByType();
								System.out.println("Search Book by Type");
								break;
							case 4:
								bookUser.getBookByAuthorName();
								System.out.println("Search Book by Author Name");
								break;
							case 5:
								bookUser.inputGetAllBooks();
								System.out.println("Show All Books");
								break;
							}//3 rd switch end
							break;
						case 2:
					    	studentUser.issueBook();
							System.out.println("Issue Book..");
							break;
						case 3:
							issueBookuser.inputReturnBook();
							System.out.println("Returned Book...");
							break;
						case 4:
							System.out.println("View Fine Details...");
							break;
						case 5:
							System.out.println("Pay Fine...");                	
							break;
						case 6:
							issueBookuser.inputGetIssuedBook();
							System.out.println("view IssueBook Details");
							break;
						case 7:	
							System.out.println(" Logout Successfully !!");
							break;	
						}//2 nd switch case end
					}//while loop end
				}//if statement end 
				//break;
				else
				{
					System.out.println("student id not found");
				}
			}//1 st switch end
			System.out.println("Do you want to continue... ");
			String ch=scanner.next();
			if(ch.equals("no"))
			{
				System.out.println("Student User does not want to continue.... ..Thank you");
				break;
			}
		}//while end
	}//student method end
}//main class end



