package com.grabnotes.book.model;

public class Book {

	private String author;
	private String title;
	private String edition;
	private String genre;

	private int id;

	public Book() {

	}

	public Book(int id) {

	}

	public Book(String author, String title, String edition, String genre, int id) {
		super();
		this.author = author;
		this.title = title;
		this.edition = edition;
		this.genre = genre;
		this.id = id;
	}

	public Book(String author, String title, String edition, String genre) {
		super();
		this.author = author;
		this.title = title;
		this.edition = edition;
		this.genre = genre;
	}

	// Getters and Setters for fields
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
