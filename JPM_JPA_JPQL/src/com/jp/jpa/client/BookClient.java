package com.jp.jpa.client;

import java.util.List;

import com.jp.jpa.entity.Book;
import com.jp.jpa.service.BookService;
import com.jp.jpa.service.BookServiceImpl;

public class BookClient {


	public static void main(String[] args) {
		BookService service = new BookServiceImpl();
		
		System.out.println("*******************************************");
		System.out.println("Listing book with id 101");
		System.out.println(service.getBookById(101));
		System.out.println("*******************************************");
		System.out.println("Listing all books");
		List<Book> bookList = service.getAllBooks();
		System.out.println(bookList);
		System.out.println("*******************************************");
		String title ="Java";
		System.out.println("Listing book with title Java: " + title);
		List<Book> bookList1 = service.getBookByTitle(title);
		System.out.println(bookList1);
		System.out.println("*******************************************");
		String author = "Herbert Schildt";
		System.out.println("Listing books with author: " + author);
		List<Book> bookList2 =  service.getAuthorBooks(author);
		System.out.println(bookList2);
		System.out.println("*******************************************");
		Double low = 300d;
		Double high = 560d;
		System.out.println("Listing books within price " + low + " and " + high);
		List<Book> bookList3 =  service.getBooksInPriceRange(low, high);
		System.out.println(bookList3);
		System.out.println("*******************************************");
		System.out.println("Listing book count");
		Long count =  service.getBookCount();
		System.out.println(count);
		System.out.println("*******************************************");
		
	}

}
