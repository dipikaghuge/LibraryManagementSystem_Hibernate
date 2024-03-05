package com.dipika.library.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.dipika.library.entity.IssueBook;
import com.dipika.library.service.BookService;
import com.dipika.library.service.BookServiceImpl;

public class IssueBookDaoImpl implements IssueBookDao
{
    EntityManager entityManager=MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	private Query query;
    BookService bookService=new BookServiceImpl();
	
	public String ApprovedIssueBook(IssueBook bookIssue) {
		IssueBook bookIssue1=entityManager.find(IssueBook.class, bookIssue.getIssueId());
		
		entityTransaction.begin();
		bookIssue1.setBookStatus(bookIssue.getBookStatus());
		entityTransaction.commit();
		entityManager.clear();
		return "Book is Approved";
	}

    
	public String issueBook(IssueBook issueBook) 
	   {
		entityTransaction.begin();
		entityManager.persist(issueBook);
		entityTransaction.commit();
		entityManager.clear();
		return "Book issue request sended to the Admin";
	   }
	public String returnBook(IssueBook issueBook) 
	{
		 issueBook=entityManager.find(IssueBook.class, issueBook.getIssueId());
		if(issueBook!=null) {
			entityTransaction.begin();
			issueBook.setReturnDate(issueBook.getReturnDate());
			issueBook.setBookStatus(issueBook.getBookStatus());
			//issueBook.setBookStatus("Return");
			entityTransaction.commit();
			entityManager.clear();
		}
		return "Book Returned";
	 }
	public List<IssueBook> displayUnIssuedBook() 
	{
		query=entityManager.createQuery("select bi from IssueBook bi where bi.bookStatus='NOT ISSUED'");
		return query.getResultList();
	}
	
	public IssueBook findRecordByIssueId(Integer issueId) {
		return entityManager.find(IssueBook.class,issueId);
	}
	public String confirmIssueBook(IssueBook issueBook) 
	{
		IssueBook issueBook1=entityManager.find(IssueBook.class, issueBook.getIssueId());		
		entityTransaction.begin();
		issueBook.setBookStatus(issueBook.getBookStatus());
		entityTransaction.commit();
		entityManager.clear();
		return "Book is Approved";
	}	
	public IssueBook getBookIssueById(Integer issueId) 
	{
		return entityManager.find(IssueBook.class, issueId);
	}
	public List<IssueBook> getIssuedBook(Integer studentId) 
	{
			String jpql="select bi from IssueBook bi where bi.student.studentId=?1";
			query=entityManager.createQuery(jpql);
			query.setParameter(1, studentId);
			List<IssueBook> list=query.getResultList();
			return list;
	}	
    public IssueBook payFine(Integer issueId) {
    	IssueBook issueBook = getBookIssueById(issueId);
        if (issueBook != null) {
            LocalDate currentDate = LocalDate.now();
            LocalDate dueDate = issueBook.getDueDate();
            if (dueDate != null && currentDate.isAfter(dueDate)) {
                double fineAmount = calculateFineAmount(currentDate, dueDate);
                issueBook.setFine(fineAmount);
               }
        }
		return entityManager.find(IssueBook.class, issueId);
    }
    public double calculateFineAmount(LocalDate currentDate, LocalDate dueDate) 
    {
        long daysOverdue = ChronoUnit.DAYS.between(dueDate, currentDate);
        double finePerDay = 10; // Set your fine amount per day
        return  entityManager.merge(daysOverdue * finePerDay);
    }
	public List<IssueBook> displayReturnBook() {
		query=entityManager.createQuery("select bi from IssueBook bi where bi.bookStatus='ISSUED'");
		return query.getResultList();
	}
	public String updateReturnStatus(IssueBook issueBook) {
		//query=entityManager
		return null;
	}


	public String ApprovedReturnBook(IssueBook bookIssue) {
		IssueBook bookIssue1=entityManager.find(IssueBook.class, bookIssue.getIssueId());
		
		entityTransaction.begin();
		bookIssue1.setBookStatus(bookIssue.getBookStatus());
		entityTransaction.commit();
		entityManager.clear();
		return "Book is Approved for the Return";
	}
}

