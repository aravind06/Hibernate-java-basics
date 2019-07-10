package simpleHibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import pojo.Employee;

public class SimpeInsert {

	public static void main(String[] args) {
		
		Employee myEmployee = new Employee();
		
		myEmployee.setId(1001);
		myEmployee.setName("Aravind Kumar P");
		myEmployee.setSalary(50000);
		myEmployee.setState("Tamil Nadu");
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		
		ServiceRegistry serviceReg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory factory = con.buildSessionFactory(serviceReg);
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(myEmployee);
		
		tx.commit();
		
	}

}
