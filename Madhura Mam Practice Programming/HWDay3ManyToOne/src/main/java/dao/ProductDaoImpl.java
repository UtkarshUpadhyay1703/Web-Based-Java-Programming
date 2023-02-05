package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.Category;
import pojos.Product;

public class ProductDaoImpl implements ProductDao {
	public String addProductToCategory(String categoryName, Product product) {
		String msg = "Not added";
		String jpql = "select c from Category c where c.categoryName=:cn";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Category category = session.createQuery(jpql, Category.class).setParameter("cn", categoryName)
					.getSingleResult();
			if (category != null) {
				category.addProduct(product);
			}
			msg = "Added successfully";
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
	public String removeProductToCategory(String categoryName,String productName) {
		String msg="Not removed";
		String jpql = "select c from Category c where c.categoryName=:cn";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {Category category = session.createQuery(jpql, Category.class).setParameter("cn", categoryName)
				.getSingleResult();
		if (category != null) {
			String jpql1 = "select p from Product p where p.productName=:pn";
			Product  product=session.createQuery(jpql1, Product.class).setParameter("pn", productName).getSingleResult();
			System.out.println(product.getProductName());
			category.removeProduct(product);
		}
		msg = "removed successfully";
		tx.commit();

	} catch (RuntimeException e) {
		if (tx != null)
			tx.rollback();
		throw e;
	}
	return msg;
	}
}
