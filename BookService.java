package com.dipika.library.service;

import java.util.List;

import javax.persistence.Parameter;

import com.dipika.library.entity.Book;
import com.dipika.library.entity.IssueBook;

public interface BookService
{
	String addBook(Book book);
	List<Book> getAllBooks();
	Book getBookById(Integer bookId);
	List<Book> getBookByName(String bookName);
	List<Book> getBookByType(String bookType);
	List<Book> getBookByAuthorName(String authorName);
	String updateStock(Book book);
}
