package com.vietjack.core;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {
	private long id;
    private String name;
    private long soldNumber;
    private double revenue;
    private long bookCount;
    
	public long getBookCount() {
		return bookCount;
	}
	public void setBookCount(long bookCount) {
		this.bookCount = bookCount;
	}
	public Category(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(ResultSet resultSet) throws SQLException{
		this.setId(resultSet.getLong("id"));
		this.setName(resultSet.getString("name"));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int)(prime * result + id);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getSoldNumber() {
		return soldNumber;
	}
	public void setSoldNumber(long soldNumber) {
		this.soldNumber = soldNumber;
	}
	
	
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", revenue =" + revenue + "]";
	}
    
}
