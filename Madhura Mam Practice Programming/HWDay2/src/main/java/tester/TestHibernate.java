package tester;

import org.hibernate.SessionFactory;
import utils.HibernateUtils;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getFactory()) {
			System.out.println("Hibernate is running up");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
