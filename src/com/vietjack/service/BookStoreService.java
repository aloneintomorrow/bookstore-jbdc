package com.vietjack.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.vietjack.core.Author;
import com.vietjack.core.Category;
import com.vietjack.dao.AuthorDao;
import com.vietjack.dao.CategoryDao;

class RevenueAuthorComparator implements Comparator<Author> {
	public int compare(Author o1, Author o2) {
		if (o1.getRevenue() > o2.getRevenue()) {
			return 1;
		}
		if (o1.getRevenue() < o2.getRevenue()) {
			return -1;
		}
		return 0;
	}
}

public class BookStoreService {
	public static AuthorDao authorDao = new AuthorDao();
	public static CategoryDao categoryDao = new CategoryDao();
	public static Scanner scanner = new Scanner(System.in);

	public static void topAuthorByRevenue() throws SQLException {
		ArrayList<Author> arrayListAuthor = authorDao.calculateRevenueOfAuthor();
		// Collections.sort(arrayListAuthor,new RevenueAuthorComparator());
		for (Author author : arrayListAuthor) {
			System.out.println(author);
			System.out.println("Tuoi: " + author.calculateAge());
			System.out.println("Doanh thu ban: " + author.getRevenue());
		}

	}


	//bao cao xep hang doanh thu theo the loai
	public static void topCategoryByRevenueDB() throws SQLException  {
		ArrayList<Category> arrayCategoryList = categoryDao.calculateRevenueOfCategory();
		for(Category category : arrayCategoryList) {
			System.out.println(category);
		}
		//lam bai tap phan nay
	}
	//bao cao xep hang so luong ban duoc theo tac gia
	public static void topAuthorBySoldNumber() throws SQLException {
		ArrayList<Author> arrayAuthor = authorDao.findTopAuthorBySoldNumber();
		for(Author author : arrayAuthor) {
			System.out.println(author);
			System.out.println(author.getName());
		}
		//lam bai tap phan nay
	}
	//bao cao the loai the so dau sach (moi quyen sach khac nhau la 1 dau sach, vd: doremon la 1, hinh hoc 11 la 2....)
	public static void  topCategoryByHeadBook() throws SQLException{
		// lam bai tap phan nay
	}
	public void topAuthorBySoldNumberDB() throws SQLException {
		
	}

	public void printBookStoreMenu() {
		System.out.println("1.Top Author by revenue");
		System.out.println("2.Top Category by revenue");
		System.out.println("3.top Author By Sold Number");
		System.out.println("4.Calculate revenue of time");
		System.out.println("5.Author with revenue");

		System.out.println("6.Exit");
	}
}
