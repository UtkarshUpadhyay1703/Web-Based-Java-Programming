package com.tester;

import java.util.Scanner;
import java.util.List;
import com.dal.BookDALImp;
import com.pojo.Book;
import com.util.DBUtil;

public class TestBook {

	public static void main(String[] args) {
		try {
			int option=0;
			DBUtil.openConnection();
			BookDALImp bookDal=new BookDALImp();
			Scanner sc=new Scanner(System.in);
			do {
			System.out.println(" Enter 1.Show all Books 2.Add Book 3.update book 4.Delete Book");
			option=sc.nextInt();
			
			switch (option) {
			case 1:
				List<Book> list=bookDal.GetAllbooks();
				list.forEach(bo->System.out.println(bo));
				break;
			case 2:
				System.out.println("Enter id ,Title,Author,price");
				bookDal.Add(new Book(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble()));
				break;
			case 3:
				System.out.println("Enter id Title author and Price");
				bookDal.Update(new Book(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble()));
				break;
			case 4:
				System.out.println("ENter id");
				bookDal.Delete(sc.nextInt());
				break;
			}
			}while(option!=5);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
