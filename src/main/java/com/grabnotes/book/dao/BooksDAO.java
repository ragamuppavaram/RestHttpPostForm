package com.grabnotes.book.dao;

import com.grabnotes.book.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BooksDAO {

	public Book insert(String author, String title, String edition, String genre) throws Exception {

		try (Connection con = MySqlDbConnection.getDbConnection()) {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_QUERY);
			preparedStatement.setString(1, author);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, edition);
			preparedStatement.setString(4, genre);
			preparedStatement.executeUpdate();
			return new Book(author, title, edition, genre);
		}

	}

	public Book update(String author, String title, String edition, String genre, int id) throws Exception {
		try (Connection con = MySqlDbConnection.getDbConnection()) {
			PreparedStatement preparedStatement = con.prepareStatement(UPDATE_QUERY);
			preparedStatement.setString(1, author);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, edition);
			preparedStatement.setString(4, genre);
			preparedStatement.setInt(5, id);
			preparedStatement.executeUpdate();
			return new Book(author, title, edition, genre, id);
		}

	}

	public Book delete(int id) throws Exception {
		try (Connection con = MySqlDbConnection.getDbConnection()) {
			PreparedStatement preparedStatement = con.prepareStatement(DELETE_QUERY);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			return new Book(id);
		}

	}

	public List<Book> getAllBooks() throws Exception {
		try (Connection con = MySqlDbConnection.getDbConnection()) {
			PreparedStatement preparedStatement = con.prepareStatement(RETRIEVE_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();

			List<Book> result = new ArrayList<Book>();
			while (resultSet.next()) {
				Book b = new Book();
				b.setAuthor(resultSet.getString(1));
				b.setTitle(resultSet.getString(2));
				b.setEdition(resultSet.getString(3));
				b.setGenre(resultSet.getString(4));
				b.setId(resultSet.getInt(5));

				result.add(b);

				System.out.println("Author: " + resultSet.getString(1) + " " + "Title: " + resultSet.getString(2) + " "
						+ "Edition: " + resultSet.getString(3) + " " + "Genre: " + resultSet.getString(4) + " " + "Id:"
						+ resultSet.getInt(5));
			}
			return result;
		}

	}

	private static final String INSERT_QUERY = "insert into book(author,title,edition,genre) values(?,?,?,?)";
	private static final String UPDATE_QUERY = "update book set author=?, title=?,edition=?,genre=? where id=?";
	private static final String DELETE_QUERY = "delete from book where id=?";
	private static final String RETRIEVE_QUERY = "select author,title,edition,genre,id from book";

}
