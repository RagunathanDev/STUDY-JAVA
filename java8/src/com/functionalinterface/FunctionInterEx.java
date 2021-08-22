package com.functionalinterface;

import java.util.Collections;
import java.util.List;

public class FunctionInterEx {

//	An functional interface is -> the interface can contain only one abstract method.

//	Example -> Runnable , comparator, comparable, callable

	public static void main(String[] args) {

		BookService serv = new BookService();
		List<BookModel> books = serv.getAllBook();
		System.out.println(books);
		Collections.sort(books, (b1, b2) -> b1.getPrice().compareTo(b2.getPrice()));
		System.out.println(books);
	}

}
