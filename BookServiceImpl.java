package com.dipika.library.service;

import java.util.List;

import javax.persistence.Parameter;

import com.dipika.library.dao.BookDao;
import com.dipika.library.dao.BookDaoImpl;
import com.dipika.library.entity.Book;

public class BookServiceImpl implements BookService
{
	BookDao bookDao=new BookDaoImpl();

	public String addBook(Book book) {
		return bookDao.addBook(book);
	}

	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	public Book getBookById(Integer bookId) {
		return bookDao.getBookById(bookId);
	}

	public List<Book> getBookByName(String bookName) {
		return bookDao.getBookByName(bookName);
	}

	public List<Book> getBookByType(String bookType) {
		return bookDao.getBookByType(bookType);
	}

	public String updateStock(Book book) {
		return bookDao.updateStock(book);
	}

	public List<Book> getBookByAuthorName(String authorName) {
		return bookDao.getBookByAuthorName(authorName);
	}

	

}
