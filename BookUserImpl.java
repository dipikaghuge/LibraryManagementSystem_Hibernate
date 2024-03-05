package com.dipika.library.presentation;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.dipika.library.entity.Book;
import com.dipika.library.service.BookService;
import com.dipika.library.service.BookServiceImpl;
import com.dipika.library.validation.MyValidation;

public class BookUserImpl implements BookUser{

	private Scanner scanner=new Scanner(System.in);
	BookService bookService=new BookServiceImpl();
	
	public void inputAddBook() 
	{
		/*System.out.println("Enter the Book Name:");
		String bookName=scanner.nextLine();
		System.out.println("Enter the Book Auther Name:");
		String autherName=scanner.nextLine();
		System.out.println("Enter the Book Quantity:");
		int bookQuantity=scanner.nextInt();
		System.out.println("Enter the Book Type:");
		String bookType=scanner.next();
		
		Book book=new Book();
		book.setBookName(bookName);
		book.setAuthorName(autherName);
		book.setBookType(bookType);
		book.setQuantity(bookQuantity);
		book.setIssueBook(null);	
		BookService bookService=new BookServiceImpl();
		System.out.println(bookService.addBook(book)); */
		
	    boolean flagBookName=true;
		boolean flagBookType=true;
		boolean flagAutherName=true;
		while(flagBookName) {
			System.out.println("Enter the Book Name:");
			String bookName=scanner.nextLine();
		if(MyValidation.isValidBookName(bookName))
		{
			flagBookName=false;
		while(flagAutherName) {	
			System.out.println("Enter the Book Auther Name:");
			String autherName=scanner.nextLine();
		if(MyValidation.isValidAutherName(autherName)) 
		{
			flagAutherName=false;
			System.out.println("Enter the Book Quantity:");
			Integer bookQuantity=scanner.nextInt();
		while(flagBookType) {	
			System.out.println("Enter the Book Type:");
			String bookType=scanner.next();
		if(MyValidation.isValidBookType(bookType)) {
			flagBookType=false;
		
			Book book=new Book();
			book.setBookName(bookName);
			book.setAuthorName(autherName);
			book.setBookType(bookType);
			book.setQuantity(bookQuantity);
			book.setIssueBook(null);	
			BookService bookService=new BookServiceImpl();
			System.out.println(bookService.addBook(book));		
		
		}else {
			System.out.println("Enter valid BookType");
		 }
		}
		}else {
			System.out.println("Enter valid Auther Name");
		}
		}
		}else {
			System.out.println("Enter valid book Name");
		}  
		}

		
		
	}
	public void inputGetAllBooks() 
	{
		List<Book> l=bookService.getAllBooks();
		Iterator<Book> itr=l.iterator();
	     System.out.println("**************************************************************************");
	     System.out.println("BookId  BookName    AuthorName    BookQuantity  BookType");
	     System.out.println("**************************************************************************");
		while(itr.hasNext())
		{
			Book book=itr.next();
	   	 	 System.out.println(book.getBookId()+"\t"+book.getBookName()+"\t    "+book.getAuthorName()+"\t"+book.getQuantity()+"\t"+book.getBookType());
	   }	
	}
	public void inputGetBookById() 
	{
		inputGetAllBooks();
		System.out.println("Enter Book Id:");
		Integer bookId=scanner.nextInt();
         Book book= bookService.getBookById(bookId);
        if(book!=null)
        {
   	     System.out.println("**************************************************************************");
   	     System.out.println("BookId  BookName    AuthorName    BookQuantity  BookType");
   	     System.out.println("**************************************************************************");
   	 	 System.out.println(book.getBookId()+"\t"+book.getBookName()+"\t    "+book.getAuthorName()+"\t"+book.getQuantity()+"\t"+book.getBookType());
        }
        else {
        	System.out.println("Object not found");
        }	
	}
	public void inputGetBookByName() 
	{      
 	   System.out.println("Book Name is:");
 	   String bookName=scanner.next();
		List<Book> l=bookService.getBookByName(bookName);
		Iterator<Book> itr=l.iterator();

 	   while(itr.hasNext())
 	   {
 		 Book book=itr.next();
	     System.out.println("**************************************************************************");
	     System.out.println("BookId  BookName    AuthorName    BookQuantity  BookType");
	     System.out.println("**************************************************************************");
	 	 System.out.println(book.getBookId()+"\t"+book.getBookName()+"\t    "+book.getAuthorName()+"\t"+book.getQuantity()+"\t"+book.getBookType());
 	   }
	}
	public void inputGetBookByType()
	{      
	 	   System.out.println("Book Type is:");
	 	   String bookType=scanner.next();
			List<Book> l=bookService.getBookByType(bookType);
			Iterator<Book> itr=l.iterator();
		     System.out.println("**************************************************************************");
		     System.out.println("BookId  BookName    AuthorName    BookQuantity  BookType");
		     System.out.println("**************************************************************************");

	 	   while(itr.hasNext())
	 	   {
	 		 Book book=itr.next();
		 	 System.out.println(book.getBookId()+"\t"+book.getBookName()+"\t    "+book.getAuthorName()+"\t"+book.getQuantity()+"\t"+book.getBookType());
	 	   }
	  }
	 public void inputUpdateStock() 
	   {
			System.out.println("Enter the Book Id::");	    
	 	    Integer bookId =scanner.nextInt();
	 	    System.out.println("Enter the Book Quantity::");	    
	 	    Integer quantity =scanner.nextInt();
	 	    Book book=new Book();
	 	    book.setBookId(bookId);
	 	    book.setQuantity(quantity);
	 	   System.out.println(bookService.updateStock(book));
		}
	  public void getBookByAuthorName() 
    	{
	 	   System.out.println("Book AuthorName is:");
	 	   String authorName=scanner.next();
			List<Book> l=bookService.getBookByAuthorName(authorName);
			Iterator<Book> itr=l.iterator();
		     System.out.println("**************************************************************************");
		     System.out.println("BookId  BookName    AuthorName    BookQuantity  BookType");
		     System.out.println("**************************************************************************");
	 	   while(itr.hasNext())
	 	   {
	 		 Book book=itr.next();
		 	 System.out.println(book.getBookId()+"\t"+book.getBookName()+"\t    "+book.getAuthorName()+"\t"+book.getQuantity()+"\t"+book.getBookType());
	 	   }
	    }
 }
