package com.dipika.library.presentation;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dipika.library.entity.Book;
import com.dipika.library.entity.IssueBook;
import com.dipika.library.entity.Student;
import com.dipika.library.service.BookService;
import com.dipika.library.service.BookServiceImpl;
import com.dipika.library.service.IssueBookService;
import com.dipika.library.service.IssueBookServiceImpl;
import com.dipika.library.service.StudentService;
import com.dipika.library.service.StudentServiceImpl;

public class IssueBookUserImpl implements IssueBookUser{

	private Scanner scanner=new Scanner(System.in);
	private IssueBookService issueBookService=new IssueBookServiceImpl();
    private BookService bookService=new BookServiceImpl();
    private StudentService studentService=new StudentServiceImpl();
    private Integer bookId;

	public void inputApprovedIssueBook() {
		displayUnIssueBook();
		System.out.println("Do you want to issue any book to the student(Yes/No)");
		String ans=scanner.next();
		if(ans.equalsIgnoreCase("yes")) {
			System.out.println("Enter issue Id:");
			Integer issueId=scanner.nextInt();
			IssueBook bookIssue=issueBookService.findRecordByIssueId(issueId);
			bookIssue.setIssueDate(LocalDate.now());
			bookIssue.setDueDate(LocalDate.now().plusDays(5));
			bookIssue.setBookStatus("ISSUED");
			Book book=bookService.getBookById(bookIssue.getIssueId());
			book.setQuantity(book.getQuantity()-1);
			bookService.updateStock(book);
			System.out.println(issueBookService.ApprovedIssueBook(bookIssue));
		}	
	}
	public void inputIssueBook(Integer studentId)
	{
		System.out.println("===== Issue Book =====");
        System.out.println("Enter the book ID to issue: ");
        bookId=scanner.nextInt();
        
        Book book=bookService.getBookById(bookId);
        Student student=studentService.getStudentById(studentId);
        IssueBook bookIssue=new IssueBook();
        bookIssue.setBook(book);
        bookIssue.setStudent(student);
        bookIssue.setIssueDate(bookIssue.getIssueDate());
        bookIssue.setDueDate(bookIssue.getDueDate());
        bookIssue.setReturnDate(bookIssue.getReturnDate());
        bookIssue.setBookStatus(bookIssue.getBookStatus());
        bookIssue.setFine(bookIssue.getFine());
        
        System.out.println(issueBookService.issueBook(bookIssue));

 	}	
	public void displayUnIssueBook()
	{
		List<IssueBook> list =issueBookService.displayUnIssuedBook();
	    if(list==null)
	    	System.out.println("No Book Avaliable For Approve");
	    else 
	    	{
           	System.out.println("*************************************************************************************************************");
           	System.out.println("IssueBook Id \tBook Id\t\tStudent Id\tBook Status\tBook Name\tStudent Name");
           	System.out.println("*************************************************************************************************************");
	    	  for(IssueBook bi:list) 
	    	  {
	    	  System.out.println(bi.getIssueId()+"\t\t"+bi.getBook().getBookId()+"\t\t"+bi.getStudent().getStudentId()+"\t\t"+bi.getBookStatus()+"\t "+bi.getBook().getBookName()+"\t\t"+bi.getStudent().getStudentName());
	          }
	        }
	}
	public void inputGetIssuedBook() 
	{
		List<IssueBook> l=issueBookService.getIssuedBook(StudentUserImpl.studId);
		if(!l.isEmpty()) 
		{
		Iterator<IssueBook> itr=l.iterator();
       	System.out.println("******************************************************************************************");
       	System.out.println("IssueId  Issue Date     Status   DueDate   ReturnDate  Fine  StudentId");
       	System.out.println("******************************************************************************************");
		while (itr.hasNext()) 
		{
		    IssueBook bi = itr.next();
		    System.out.println( bi.getIssueId() + "\t" +bi.getIssueDate() + "\t" + bi.getBookStatus() + "\t" + bi.getDueDate() + "\t" +bi.getReturnDate() + "\t" +  bi.getFine() + "\t" + bi.getStudent().getStudentId());
		}
		System.out.println();
		}else {
			System.out.println("There is no issue book");
		}
	}
	public void inputGetBookIssuedById()
	{
		System.out.println("Enter the IssueBook Id:");
		Integer issueId=scanner.nextInt();
		IssueBook issueBook=issueBookService.getBookIssueById(issueId);
       	System.out.println("*************************************************************************************************************");
       	System.out.println("\tIssueBook Id\t\t Issue Date\t\t Return Date \t\tDue Date\t\tBook Status");
       	System.out.println("*************************************************************************************************************");
		if(issueBook!=null)
		{
	 	    System.out.println("\t "+issueBook.getIssueId()+"\t\t "+issueBook.getIssueDate()+"\t\t\t "+issueBook.getReturnDate()+"\t\t\t "+issueBook.getDueDate()+"\t\t\t "+issueBook.getBookStatus());	
		}
		else
		{
			System.out.println("Book Id Not Found");
		}
	}
	/*public void inputConfirmIssueBook() 
	{
		displayUnIssueBook();
		System.out.println("Do you want to issue any book to the student(Yes/No)");
		String ans=scanner.next();
		if(ans.equalsIgnoreCase("yes")) {
			System.out.println("Enter issue Id:");
			Integer issueId=scanner.nextInt();
		    IssueBook issueBook=issueBookService.findRecordByIssueId(issueId);
		    issueBook.setIssueDate(LocalDate.now());
		    issueBook.setDueDate(LocalDate.now().plusDays(5));
		    issueBook.setBookStatus("ISSUED");
			Book book=bookService.getBookById(issueBook.getIssueId());
			book.setQuantity(book.getQuantity()-1);
			bookService.updateStock(book);
			System.out.println(issueBookService.confirmIssueBook(issueBook));
		}
	}	*/

		public void inputReturnBook()
		{
			displayReturnBook();
	        System.out.println("Enter Book Issue Id");
	        int issueBookId = scanner.nextInt();
	        IssueBook issueBook = issueBookService.findRecordByIssueId(issueBookId);
			if (issueBook != null) {
	            System.out.println("Enter Return Date (yyyy-MM-dd):");
	            String returnDate = scanner.next();
	            issueBookService.updateReturnDate(issueBookId, returnDate);
	            System.out.println("Book successfully returned.");
	        } else {
	            System.out.println("Book issue record not found.");
	        }

		}
			/*
			if (issueBook != null && issueBook.getReturnDate() == null)
			{
				issueBook.setReturnDate(LocalDate.now());
	            LocalDate dueDate = issueBook.getDueDate();
	            LocalDate returnDate = issueBook.getReturnDate();
	            if (returnDate.isAfter(dueDate))
	            {
	            	long daysOverdue = ChronoUnit.DAYS.between(dueDate, returnDate);
	            	System.out.println("line150="+daysOverdue);
	                double fineRate = 10; // Fine rate per day
	                double fineAmount = daysOverdue * fineRate;
	                issueBook.setFine(fineAmount);
	                System.out.println("Fine calculated: $" + fineAmount);
	            }
	            else{
	            System.out.println(issueBookService.returnBook(issueBook));
	            }
	        } 
			else
			{
	            System.out.println("Book already returned.");
	         }
	         */
	
  /*  public void calculateFineAmount() 
    {
    	IssueBook issueBook=new IssueBook();
    	LocalDate dueDate =LocalDate.now();
    	LocalDate issueDate =issueBook.getIssueDate();
		long daysOverdue = ChronoUnit.DAYS.between(dueDate, issueDate);
        double finePerDay = 10; // Set your fine amount per day
        System.out.println("Fine:"+(daysOverdue * finePerDay));
    }*/

	    /* public void inputPayFine() {
	    	 //calculateFineAmount();
	 		System.out.println("Enter the IssueBook Id:");
			Integer issueId=scanner.nextInt();
			IssueBook issueBook=issueBookService.getBookIssueById(issueId);
	       	System.out.println("*************************************************************************************************************");
	       	System.out.println("\tIssueBook Id\t\t PayFine\t\tIssue Date\t\t Return Date \t\tDue Date\t\tBook Status");
	       	System.out.println("*************************************************************************************************************");
			if(issueBook!=null)
			{
		 	    System.out.println("\t "+issueBook.getIssueId()+"\t\t"+issueBook.getFine() +"\t\t "+issueBook.getIssueDate()+"\t\t\t "+issueBook.getReturnDate()+"\t\t\t "+issueBook.getDueDate()+"\t\t\t "+issueBook.getBookStatus());	
			}
			else
			{
				System.out.println("fine Not Found");
			}
	    }*/
	     
	 /*	public void inputConfirmReturnBook() 
		{
	 		displayReturnBook();
	 		//inputPayFine();
			System.out.println("Do you want to return any book to the student (yes/no)");
			String ans = scanner.next();
			if (ans.equalsIgnoreCase("yes")) {
			    System.out.println("Enter issued Id:");
			    Integer issueId = scanner.nextInt();
			    IssueBook issueBook = issueBookService.findRecordByIssueId(issueId);
			    
			    if (issueBook != null) 
			    {
			    	LocalDate issueDate =issueBook.getIssueDate();
			    	//issueBook.setReturnDate(LocalDate.now());
			    	issueBook.setBookStatus("Not issued");
			        Book book = bookService.getBookById(issueBook.getIssueId());
			        if (book != null && book.getQuantity() > 0) {
			            book.setQuantity(book.getQuantity() + 1); // Decrease the quantity by 1
			            bookService.updateStock(book);
			            System.out.println("Book Return successfully.");
			        } 
			        System.out.println(issueBookService.confirmIssueBook(issueBook));
			    } else {
			        System.out.println("Book return record not found.");
			    }
			}
		}*/
		
		public void displayReturnBook() {
			List<IssueBook> list =issueBookService.displayReturnBook();
		    if(list==null)
		    	System.out.println("No Book Avaliable For Confrm");
		    else 
		    	{
	           	System.out.println("*************************************************************************************************************");
	           	System.out.println("IssueBook Id \tBook Id\t\tStudent Id\tBook Status\tBook Name\tStudent Name");
	           	System.out.println("*************************************************************************************************************");
		    	  for(IssueBook bi:list) 
		    	  {
		    	  System.out.println(bi.getIssueId()+"\t\t"+bi.getBook().getBookId()+"\t\t"+bi.getStudent().getStudentId()+"\t\t"+bi.getBookStatus()+"\t\t "+bi.getBook().getBookName()+"\t\t"+bi.getStudent().getStudentName());
		          }
		        }			
		}

		public void inputApprovedReturnBook() {
			displayReturnBook();
			System.out.println("Do you want to Return any book to the Admin(Yes/No)");
			String ans=scanner.next();
			if(ans.equalsIgnoreCase("yes")) {
				System.out.println("Enter issued Id:");
				Integer issueId=scanner.nextInt();
				IssueBook bookIssue=issueBookService.findRecordByIssueId(issueId);
				bookIssue.setIssueDate(LocalDate.now());
				bookIssue.setDueDate(LocalDate.now().plusDays(5));
				bookIssue.setBookStatus("NOT ISSUED");
				Book book=bookService.getBookById(bookIssue.getIssueId());
				book.setQuantity(book.getQuantity()+1);
				bookService.updateStock(book);
				System.out.println(issueBookService.ApprovedReturnBook(bookIssue));
			}	
		}
	}


