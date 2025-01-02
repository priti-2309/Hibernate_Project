package Hibernate.Bank_Management_System.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import Hibernate.Bank_Management_System.entity.Account;
import Hibernate.Bank_Management_System.entity.Branch;
import Hibernate.Bank_Management_System.entity.Customer;
import Hibernate.Bank_Management_System.entity.Employee;
import Hibernate.Bank_Management_System.entity.Loan;

public class HibernateUtil {
	private static SessionFactory sf;
	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			try {
				Configuration configuration = new Configuration();

				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				//useSSL=false---we can disable warning while connecting to DB to Java
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/bank?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "pritiag23092004");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(Customer.class);
				configuration.addAnnotatedClass(Branch.class);
				configuration.addAnnotatedClass(Employee.class);
				configuration.addAnnotatedClass(Loan.class);
				configuration.addAnnotatedClass(Account.class);
			
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sf = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sf;
	}


}
