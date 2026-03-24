package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeManager {
	
	
	public String InsertEmployee(Employee E) throws Exception
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.persist(E);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
		return "Employee Record Inserted...";
	}
	
	public List<Employee> getData() throws Exception
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		List<Employee> elist = session.createQuery("FROM Employee", Employee.class).list();
		session.getTransaction().commit();
		session.close();
		factory.close();
		return elist;
	}
	
	public String updateData(Employee E) throws Exception
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		Employee temp = session.find(Employee.class, E.getEmpid());
		temp.setName(E.getName());
		temp.setSalary(E.getSalary());
		session.merge(temp);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return "Employee Record Updated...";
	}
	
	public String deleteData(int empid) throws Exception
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		Employee temp = session.find(Employee.class, empid);
		session.remove(temp);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
		return "Employee Record Deleted..";
	}
	
	
	
	
	

}
