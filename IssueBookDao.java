package com.dipika.library.dao;

import java.time.LocalDate;
import java.util.List;

import com.dipika.library.entity.IssueBook;
import com.dipika.library.entity.Student;

public interface IssueBookDao 
{
	 String issueBook(IssueBook issueBook) ;
	 String returnBook(IssueBook issueBook);
	 IssueBook getBookIssueById(Integer issueId);
     List<IssueBook> getIssuedBook(Integer studentId);
     List<IssueBook> displayUnIssuedBook();
	 IssueBook findRecordByIssueId(Integer issueId);
	 String confirmIssueBook(IssueBook issueBook);
     String ApprovedIssueBook(IssueBook bookIssue);

	 
	 IssueBook payFine(Integer issueId);
	 double calculateFineAmount(LocalDate currentDate, LocalDate dueDate);
	List<IssueBook> displayReturnBook();
	
	//
	String updateReturnStatus(IssueBook issueBook);
	String ApprovedReturnBook(IssueBook bookIssue);
	
}
