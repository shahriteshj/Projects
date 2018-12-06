package com.jp.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jp.jpa.entity.Book;
import com.jp.jpa.util.JPAUtil;

public class BookDaoImpl implements BookDao {

	private EntityManager entityManager;
	
	public BookDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Book getBookById(int id) {
		TypedQuery<Book> q = (TypedQuery<Book>) entityManager.createNamedQuery("getBookById");
		q.setParameter("id", id);
		return q.getSingleResult();
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		TypedQuery<Book> q = (TypedQuery<Book>)entityManager.createQuery("SELECT b FROM Book b where b.title like :title",Book.class);
		q.setParameter("title", "%"+title+"%");
		return q.getResultList();
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
		TypedQuery<Book> q = (TypedQuery<Book>) entityManager.createNamedQuery("getAuthorBooks");
		q.setParameter("author", author);
		return q.getResultList();
	}

	@Override
	public List<Book> getAllBooks() {
		TypedQuery<Book> q = (TypedQuery<Book>) entityManager.createNamedQuery("getAllBooks");
		return q.getResultList();
		
	}

	@Override
	public List<Book> getBooksInPriceRange(double low, double high) {
		TypedQuery<Book> q = (TypedQuery<Book>) entityManager.createNamedQuery("getBooksInPriceRange");
		q.setParameter("low", low);
		q.setParameter("high", high);
		return q.getResultList();
	}

}
