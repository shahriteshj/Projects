package com.jp.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jp.jpa.entity.Book;
import com.jp.jpa.util.JPAUtil;

public class BookDaoImpl implements BookDao {

	private EntityManager entityManager;
	private Logger logger;

	public BookDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
		logger = LoggerFactory.getLogger(BookDaoImpl.class);
	}

	@Override
	public Book getBookById(int id) {
		TypedQuery<Book> q = entityManager.createNamedQuery("getBookById", Book.class);

		q.setParameter("id", id);
		Book b = q.getSingleResult();
		logger.info("Invoked getBookById at BookDaoImpl and book found is: " ,b.toString());
		return b;
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		TypedQuery<Book> q = (TypedQuery<Book>) entityManager
				.createQuery("SELECT b FROM Book b where b.title like :title", Book.class);
		q.setParameter("title", "%" + title + "%");
		List<Book> bookList = q.getResultList();
		return bookList;
	}

	@Override
	public Long getBookCount() {
		String qStr = "SELECT COUNT(b.id) from Book b";
		TypedQuery<Long> q = (TypedQuery<Long>) entityManager.createQuery(qStr, Long.class);
		Long count = q.getSingleResult();
		return count;
	}

	@Override
	public List<Book> getAuthorBooks(String author) {
		TypedQuery<Book> q =  entityManager.createNamedQuery("getAuthorBooks",Book.class);
		q.setParameter("author", author);
		List<Book> bookList = q.getResultList();
		return bookList;
	}

	@Override
	public List<Book> getAllBooks() {
		TypedQuery<Book> q = entityManager.createNamedQuery("getAllBooks", Book.class);
		List<Book> bookList = q.getResultList();
		return bookList;

	}

	@Override
	public List<Book> getBooksInPriceRange(double low, double high) {
		TypedQuery<Book> q = entityManager.createNamedQuery("getBooksInPriceRange", Book.class);
		q.setParameter("low", low);
		q.setParameter("high", high);
		List<Book> bookList = q.getResultList();
		return bookList;
	}

}
