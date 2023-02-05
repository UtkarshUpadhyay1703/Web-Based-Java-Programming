package dao;
import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;

import pojos.Employee;
import pojos.Departmanet;
import org.hibernate.*;
import java.io.Serializable;
import java.util.List;

public class EmployeeDaoImpl {
	public String addEmpDetails(Employee newEmp) {
	String mesg="Failed";
	//1
	//1. get Session from SF(session factory)
	Session session=getFactory().getCurrentSession();
	//2.Begin the transaction
	Transaction tx=session.beginTransaction();
	try{
		//It is Session API: public Serializable save(Object transientObjRef) HibernateExc.
		Long empId=(Long)session.save(tx);
		//new Emp:Persistent=> entity ref added to L1 cache
		tx.commit();//Hibernare perform dirty chacking ->session.flush()
		//DML --insert query will be fired --Session.close()=>L1 cache destroyed, returns 
		//DBCP(database Connection Pool)
		mesg="Added emp details, Id ="+empId;
		
	} catch(RuntimeException e){
		if(tx!=null) 
			tx.rollback();
			throw e;	
	}
	return mesg;
	}
	public List<Employee> getEmpsByDeptAndSalary(Departmanet dept,double minSal){
		List<Employee> emps=null;
		String jpql="select e from Employee e where e.dept=:department";
		Session session =getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			emps=session.createQuery(jpql, Employee.class).
					setParameter("department", dept).
					setParameter("sal", minSal).getResultList();
			tx.commit();
		} catch(RuntimeException r){
			r.printStackTrace();
		}
		return emps;
	}
	
	//3.2 List emp id , first name , last name , salary for all permanent emps
	
	public List<Employees> getEmpSomeDetailById(String fname,String lname,String newdept, double newSal){
		
	String jpql="select new pojo.Employee(empId,firstName,lastName,salary) from Employee e where e.isPermanent=true";
	}

	String jpql="select e from Employee e where e.firstName=:fn and e.lastName=:ln";
	Employee emp=sess
			
			
	String jpql="delete from Employee e where e.isPermanent=false";
	
}
