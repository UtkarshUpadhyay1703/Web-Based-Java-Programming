package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;
import pojos.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String addNewCategory(Category newCategory) {
		String mesg = "Failed to add";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(newCategory);
			tx.commit();
			mesg = "added successfully";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
	public String removeCategory(String categoryName) {
		String msg="deletion failed";
		String jpql="select c from Category c where c.categoryName=:cn";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Category category=session.createQuery(jpql, Category.class).setParameter("cn", categoryName).getSingleResult();
			session.delete(category);
			msg="deleted successfully";
			tx.commit();
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
}
