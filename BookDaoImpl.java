package com.dipika.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Parameter;
import javax.persistence.Query;

import com.dipika.library.entity.Book;
import com.dipika.library.entity.IssueBook;

public class BookDaoImpl implements BookDao
{
	EntityManager entityManager=MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction=entityManager.getTransaction();
    Query query;
	public String addBook(Book book) 
	{
		entityTransaction.begin();
		entityManager.persist(book);
		entityTransaction.commit();				
		return "Book Registered";
	}

	public List<Book> getAllBooks() {
		String jpql="select b from Book b";
		query=entityManager.createQuery(jpql);
		List<Book> list=query.getResultList();
		return list;
	}

	public Book getBookById(Integer bookId) {
		Book book=entityManager.find(Book.class, bookId);
		return book;
	}

	public List<Book> getBookByName(String bookName) {
		String jpql="select b from Book b where b.bookName LIKE :bookName";
		query=entityManager.createQuery(jpql);
		query.setParameter("bookName","%"+bookName+"%");
		List<Book> list=query.getResultList();
		return list;
	}

	public List<Book> getBookByType(String bookType) {
		String jpql="select b from Book b where b.bookType LIKE :bookType";
		query=entityManager.createQuery(jpql);
		query.setParameter("bookType","%"+bookType+"%");
		List<Book> list=query.getResultList();
		return list;
	}

	public String updateStock(Book book) {
			entityTransaction.begin();
			query=entityManager.createQuery("update Book b set b.quantity=b.quantity+?1 where b.bookId=?2");
			query.setParameter(1, book.getQuantity());
			query.setParameter(2, book.getBookId());
			query.executeUpdate();
			entityTransaction.commit();
			entityManager.clear();
			return "Stock Updated";
		}	

	public List<Book> getBookByAuthorName(String authorName) {
		String jpql="select b from Book b where b.authorName LIKE :authorName";
		query=entityManager.createQuery(jpql);
		query.setParameter("authorName","%"+authorName+"%");
		List<Book> list=query.getResultList();
		return list;
	}
}


