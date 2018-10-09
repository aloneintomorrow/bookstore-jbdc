package com.vietjack.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.vietjack.core.Author;
import com.vietjack.dbconnection.DBConnection;

public class AuthorDao {
	private Connection conn;

	public Connection getConnection() throws SQLException {
		return DBConnection.getDbCon().getConn();
	}

	public ArrayList<Author> calculateRevenueOfAuthor() throws SQLException {
		String query = "SELECT ba.*,sum(bb.sold_number*bb.price *bab.revenue_share) as revenue FROM bs_author ba"
				+ " inner join bs_author_book bab on ba.id=bab.author_id "
				+ " inner join bs_book bb on bab.book_id=bb.id " + " group by ba.id" + " order by revenue desc";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		ArrayList<Author> authorList = new ArrayList<Author>();

		while (resultSet.next()) {
			Author author = new Author(resultSet);
			author.setRevenue(resultSet.getDouble("revenue"));
			authorList.add(author);
		}

		return authorList;
	}
	
	

	public Author findAuthorWithRevenue(String name) throws SQLException {

		return null;
	}

	public ArrayList<Author> findTopAuthorBySoldNumber() throws SQLException {
		String query ="select ba.name ,bb.sold_number from bs_author ba" + 
				"inner join bs_book bb on ba.id = bb.id order by sold_number desc; ";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		ArrayList<Author> authorList = new ArrayList<Author>();
		while(resultSet.next()) {
			Author author = new Author(resultSet);
			author.setSoldNumber(resultSet.getInt("sold_number"));
			authorList.add(author);
		}
		return authorList;
	}
	public ArrayList<Author> findTopCategoryByHeadBook() throws SQLException {
		return null;
	}

	public ArrayList<Author> findAllAuthor() throws SQLException {
		String query = "select * from bs_author ";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		ArrayList<Author> authorList = new ArrayList<Author>();

		while (resultSet.next()) {
			Author author = new Author(resultSet);
			// Long revenue = calculateRevenueOfAuthor(resultSet.getLong("id"));
			// author.setRevenue(revenue);
			authorList.add(author);
		}

		return authorList;
	}

	public ArrayList<Author> findAuthorOfBook(long bookId) throws SQLException {
		
			String query="select ba.*" 
					 +" from bs_author ba"
					+" inner join bs_author_book bab"
					+" on ba.id= bab.author_id"
					+" inner join bs_book bb"
					+" on bb.id = bab.book_id"
					+" where bb.id="+bookId ;
			Statement stmt = getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			ArrayList<Author> authorList = new ArrayList<Author>();
			while (resultSet.next()) {
				Author author = new Author(resultSet);
				// Long revenue = calculateRevenueOfAuthor(resultSet.getLong("id"));
				// author.setRevenue(revenue);
				authorList.add(author);
			}

			return authorList;
	}

	public boolean addNewAuthor(Author author) throws SQLException {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String query = "insert into bs_author(id,name,dob) values (" + author.getId() + ",'" + author.getName() + "','"
				+ sdf.format(author.getDob()) + "')";
		Statement stmt = getConnection().createStatement();
		int n = stmt.executeUpdate(query);
		// return (n!=0);
		if (n != 0)
			return true;
		return false;
	}

	public boolean modifyAuthor(Author author) throws SQLException {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String query = "update bs_author set name='" + author.getName() + "' , dob='" + sdf.format(author.getDob())
				+ "' where id=" + author.getId();
		Statement stmt = getConnection().createStatement();
		int n = stmt.executeUpdate(query);
		// return (n!=0);
		if (n != 0)
			return true;
		return false;
	}

	public boolean deleteAuthorByName(String name) throws SQLException {
		String query = "delete from bs_author where name = ?";
		java.sql.PreparedStatement stmt = getConnection().prepareStatement(query);
		stmt.setString(1, name);
		int n = stmt.executeUpdate();
		// return (n!=0);
		if (n != 0) {
			System.out.println(n + " rows deleted");
		}
		return false;
	}

	public Author findAuthorByName(String name) throws SQLException {
		String query = "select * from bs_author where name='" + name + "'";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);

		if (resultSet.next()) {
			Author author = new Author(resultSet);
			return author;
		} else
			return null;

	}

	public Author findAuthorById(long id) throws SQLException {
		String query = "select * from bs_author where id='" + id + "'";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);

		if (resultSet.next()) {
			Author author = new Author(resultSet);
			return author;
		} else
			return null;

	}

	public long generateId() throws SQLException {
		String query = "select max(id) as maxId from bs_author ";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		if (resultSet.next()) {
			return resultSet.getLong("maxId") + 1;
		} else {
			return 0;
		}
	}

	public ArrayList<Author> findAuthorAbove20() throws SQLException {
		return null;
	}
	public ArrayList<Author> sumSoldAuthor() throws SQLException{
		String query ="select ba.* ," + 
				"sum(bb.sold_number) as revenue from bs_author ba" + 
				"inner join bs_author_book bab on bab.author_id = ba.id" + 
				"inner join bs_book bb on bab.book_id = bb.id" + 
				"group by ba.id" + 
				";";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		ArrayList<Author> authorList = new ArrayList<Author>();
		while(resultSet.next()) {
			Author author = new Author(resultSet);
			authorList.add(author);
		}
		return authorList;
	}
}
