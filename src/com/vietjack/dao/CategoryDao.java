package com.vietjack.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.vietjack.core.Author;
import com.vietjack.core.Category;
import com.vietjack.dbconnection.DBConnection;

public class CategoryDao {
	private Connection conn;

	public Connection getConnection() throws SQLException {
		return DBConnection.getDbCon().getConn();
	}

	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Category> calculateRevenueOfCategory() throws SQLException{
		String query ="SELECT bc.*,sum(bb.sold_number*bb.price *bab.revenue_share) as revenue FROM bs_category bc" + 
				"inner join bs_author_book bab on bc.id=bab.author_id" + 
				"inner join bs_book bb on bab.book_id=bb.id "+" group by bc.id"+" order by revenue desc;";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		ArrayList<Category> categoryList = new ArrayList<Category>();
		while(resultSet.next()) {
			Category category = new Category(resultSet);
			category.setRevenue(resultSet.getDouble("revenue"));
			categoryList.add(category);
		}
		return categoryList;
	}

	/*public long calculateRevenueOfCategory(long categoryid) throws SQLException {
		
		return 0;
	}*/
	
	public ArrayList<Category> findAllCatergory() throws SQLException {
		String query = "select * from bs_category ";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		ArrayList<Category> categoryList = new ArrayList<Category>();

		while (resultSet.next()) {
			Category category = new Category(resultSet);
			categoryList.add(category);
		}
		return categoryList;
	}

	public Category findCategoryOfBook(long categoryid) throws SQLException {
		return null;
	}

	public boolean addNewCategory(Category category) throws SQLException {
		String query = "insert into bs_category(id,name) values (" + category.getId() + ",'" + category.getName()
				+ "')";
		Statement stmt = getConnection().createStatement();
		int n = stmt.executeUpdate(query);

		if (n != 0)
			return true;
		return false;
	}

	public boolean modifyCategory(Category category) throws SQLException {
		String query = "update bs_category set name='" + category.getName() + "' where id=" + category.getId();
		Statement stmt = getConnection().createStatement();
		int n = stmt.executeUpdate(query);

		if (n != 0)
			return true;
		return false;
	}

	public boolean deleteCategoryByName(String name) throws SQLException {
		String query = "delete from bs_category where name = ?";
		java.sql.PreparedStatement stmt = getConnection().prepareStatement(query);
		stmt.setString(1, name);
		int n = stmt.executeUpdate();

		if (n != 0) {
			System.out.println(n + " rows deleted");
		}
		return false;
	}

	public Category findCategoryByName(String name) throws SQLException {
		String query = "select * from bs_category where name='" + name + "'";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);

		if (resultSet.next()) {
			Category category = new Category(resultSet);
			return category;
		} else
			return null;

	}

	public Category findCategoryById(long id) throws SQLException {
		String query = "select * from bs_category where id='" + id + "'";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);

		if (resultSet.next()) {
			Category category = new Category(resultSet);
			return category;
		} else
			return null;

	}
	// The loai ban chay nhat
	public Category mostRevenueCategory() throws SQLException {
		String query = "select bs_category.name, bs_category.id,"
				+ " sum(bs_book.sold_number*bs_book.price) as 'revenue'"
				+ "from bs_book, bs_category"
				+" where bs_book.category_id = bs_category.id"
				+" group by bs_book.category_id"
				+" order by revenue desc"
				+" limit 0, 1;";
		Statement stm = getConnection().createStatement();
		ResultSet rs = stm.executeQuery(query);
		rs.next();
		Category category = new Category(rs);
		category.setRevenue(rs.getDouble("revenue"));
		return category;

	}
	public Category findByName() throws SQLException{
		return null;
	}

	public long generateId() throws SQLException {
		String query = "select max(id) as maxid from bs_category ";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);

		if (resultSet.next()) {
			return resultSet.getLong("maxid") + 1;
		} else {
			return 0;
		}
	}
	public ArrayList<Category> findTopCategoryBySoldNumber() throws SQLException{
		return null;
	}
	public ArrayList<Category> findTopCategoryByHeadBook() throws SQLException{
		return null;
	}
}

