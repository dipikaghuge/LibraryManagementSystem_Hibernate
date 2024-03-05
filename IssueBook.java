package com.dipika.library.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IssueBook 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer issueId;
	private LocalDate issueDate=LocalDate.now();
	private LocalDate dueDate;
	private String returnDate;
	@Column(length = 15)
	private String bookStatus="NOT ISSUED";
	private Double fine=0.0;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="studentId")
	private Student student;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bookId")
	private Book book;

	
	//getter setter
	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public Double getFine() {
		return fine;
	}

	public void setFine(Double fine) {
		this.fine = fine;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	
}
