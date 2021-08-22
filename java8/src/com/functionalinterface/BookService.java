package com.functionalinterface;

import java.util.ArrayList;
import java.util.List;

public class BookService {

	static List<BookModel> book = new ArrayList<BookModel>();

	public List<BookModel> getAllBook() {
		BookModel m1 = new BookModel("tamil", "a", "300");
		BookModel m2 = new BookModel("english", "d", "500");
		BookModel m3 = new BookModel("maths", "r", "700");
		BookModel m4 = new BookModel("science", "n", "200");
		BookModel m5 = new BookModel("social", "s", "100");
		book.add(0, m1);
		book.add(1, m2);
		book.add(2, m3);
		book.add(3, m4);
		book.add(4, m5);
		return book;
	}

}
