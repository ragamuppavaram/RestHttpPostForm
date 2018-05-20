package com.grabnotes.book.service;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grabnotes.book.dao.BooksDAO;
import com.grabnotes.book.model.Book;

@Controller
public class Books {
	BooksDAO dao = new BooksDAO();

	@GetMapping("/books")
	@ResponseBody
	public List<Book> getAllAvailableBooks() throws Exception {
		return dao.getAllBooks();
	}

	@PostMapping("/bookinsert")
	@ResponseBody
	public Book insertNewBook(@RequestParam(value = "author") String author,
			@RequestParam(value = "title") String title, @RequestParam(value = "edition") String edition,
			@RequestParam(value = "genre") String genre) throws Exception {

		return dao.insert(author, title, edition, genre);

	}

	@PostMapping("/bookupdate")
	@ResponseBody
	public Book updateBook(@RequestParam(value = "author") String author, @RequestParam(value = "title") String title,
			@RequestParam(value = "edition") String edition, @RequestParam(value = "genre") String genre,
			@RequestParam(value = "id") int id) throws Exception {

		return dao.update(author, title, edition, genre, id);

	}

	@PostMapping("/bookdel")
	@ResponseBody
	public Book deleteBook(@RequestParam(value = "id") int id) throws Exception {
		return dao.delete(id);
	}

	@GetMapping("/post")
	public String postBook() {
		return "book.html";
	}

}
