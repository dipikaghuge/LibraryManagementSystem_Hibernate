package com.dipika.library.service;

import java.time.LocalDate;
import java.util.List;

import com.dipika.library.dao.IssueBookDao;
import com.dipika.library.dao.IssueBookDaoImpl;
import com.dipika.library.entity.Book;
import com.dipika.library.entity.IssueBook;
import com.dipika.library.entity.Student;

public  class IssueBookServiceImpl implements IssueBookService {

	IssueBookDao issueBookDao=new IssueBookDaoImpl();

	public String ApprovedIssueBook(IssueBook bookIssue) {
		return issueBookDao.ApprovedIssueBook(bookIssue);
	}
	
	public String issueBook(IssueBook issueBook) {
		return issueBookDao.issueBook(issueBook);
	}

	public String returnBook(IssueBook issueBook) {
		return issueBookDao.returnBook(issueBook);
	}

	public IssueBook getBookIssueById(Integer issueId) {
		return issueBookDao.getBookIssueById(issueId);
	}

	public List<IssueBook> getIssuedBook(Integer studentId) {
		return issueBookDao.getIssuedBook(studentId);
	}

	public void inputConfirmIssueBook() 
	{ 		
	}

	public List<IssueBook> displayUnIssuedBook() {
		List< IssueBook> list=issueBookDao.displayUnIssuedBook();
       if(list!=null)
       {
    	  return list;
       }
       else {
    	   return null;
       }
	}

	public String confirmIssueBook(IssueBook issueBook) 
	{
		return issueBookDao.confirmIssueBook(issueBook);
	}	
	public IssueBook findRecordByIssueId(Integer issueId)
	{
		
		return issueBookDao.findRecordByIssueId(issueId);
	}

    public IssueBook payFine(Integer issueId) {
         return issueBookDao.payFine(issueId);
    }
	
	public double calculateFineAmount(LocalDate currentDate, LocalDate dueDate) {
		return issueBookDao.calculateFineAmount(currentDate, dueDate);
	}

	public List<IssueBook> displayReturnBook() {
		List< IssueBook> list=issueBookDao.displayReturnBook();
	       if(list!=null)
	       {
	    	  return list;
	       }
	       else {
	    	   return null;
	       }
	}

	public void updateReturnDate(int issueBookId, String returnDate) {
        System.out.println("Updating return date for issue ID " + issueBookId + " to " + returnDate);		
	}

	public String ApprovedReturnBook(IssueBook bookIssue) {
		return issueBookDao.ApprovedReturnBook(bookIssue);
	}
}
