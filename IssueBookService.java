package com.dipika.library.service;

import java.time.LocalDate;
import java.util.List;

import com.dipika.library.entity.IssueBook;
import com.dipika.library.entity.Student;

public interface IssueBookService 
{
	 String issueBook(IssueBook issueBook) ;
	 String returnBook(IssueBook issueBook);
	 IssueBook getBookIssueById(Integer issueId);
     List<IssueBook> getIssuedBook(Integer studentId);
     void inputConfirmIssueBook();
     List<IssueBook> displayUnIssuedBook();
	 IssueBook findRecordByIssueId(Integer issueId);
	 //String confirmIssueBook(IssueBook issueBook);
	 
		String ApprovedIssueBook(IssueBook bookIssue);
		String ApprovedReturnBook(IssueBook bookIssue);

	 
	 IssueBook payFine(Integer issueId);
	 double calculateFineAmount(LocalDate currentDate, LocalDate dueDate);
	List<IssueBook> displayReturnBook();
	void updateReturnDate(int issueBookId, String returnDate);

}
