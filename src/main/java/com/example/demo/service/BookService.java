package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	public String addBook(Book book) {
		Book book1=bookRepo.save(book);
		if(book1!=null)
		    return "Book registered successfully";
		else
			return "something went wrong";
	}

	public String deleteBook(int id) {
		try {
		bookRepo.deleteById(id);;
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "Deleted successfully";
	}
	
	public List<Book> getAllBooks()
	{
		List<Book> books=bookRepo.findAll();
	    return books;
	}
}
