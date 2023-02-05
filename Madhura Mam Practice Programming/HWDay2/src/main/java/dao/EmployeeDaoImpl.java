package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import pojos.Department;
import pojos.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	@Override
	public List<Employee> getAllEmployees() {
		String mesg = "Displaying all Employees";
		// getting session from session factory
		Session session = getFactory().getCurrentSession();
		// begining a transaction
		Transaction tx = session.beginTransaction();
		List<Employee> emps;
		try {
			String jpql = "select e from Employee e";
			emps = session.createQuery(jpql, Employee.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emps;
	}
	
	@Override
	public 	List<Employee> getEmpsByDeptAndMinSalary(Department dept,double minSal){
		List<Employee> emps;
		//creating session from session factory
		Session session=getFactory().getCurrentSession();
		//Beginning of transaction
		Transaction tx=session.beginTransaction();
		try {
			String jpql="select e from Employee e where e.dept=:department and e.salary>:sal";
			emps=session.createQuery(jpql, Employee.class).setParameter("department", dept).setParameter("sal", minSal).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return  emps;
	}
	@Override
	public String addEmpDetails(Employee emp) {
		String mesg="Adding employee failed!!";
		//creation the session
		Session session=getFactory().getCurrentSession();
		//Begin the Transaction
		Transaction tx=session.beginTransaction();
		try {
			Long id=(Long)session.save(emp);
			mesg="Successfully added"+id;
			tx.commit();//ERROR: Connection leak detected: there are 1 unclosed connections upon shutting down pool jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
		}catch(RuntimeException e) {
			if(tx!=null) 
				tx.rollback();
			throw e;
		}
		return mesg;
	}
}
