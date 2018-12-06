package com.jp.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS_JPQL")
@NamedQueries({ @NamedQuery(name = "getAllBooks", query = "from Book"),
		@NamedQuery(name = "getBookById", query = "SELECT b FROM Book b where b.id = :id") ,
		@NamedQuery(name = "getAuthorBooks", query = "SELECT b FROM Book b where b.author = :author"),
		@NamedQuery(name = "getBooksInPriceRange", query = "SELECT b FROM Book b where b.price > :low and b.price < :high")
})


public class Book implements Serializable {

	private static final long serialVersionUID = 8790526270745296307L;

	@Id
	private Integer id;
	private String title;
	private String author;
	private Double price;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "\n Book  [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}

}
