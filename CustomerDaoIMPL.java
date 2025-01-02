package Hibernate.Bank_Management_System.daoIMPL;

import javax.validation.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Hibernate.Bank_Management_System.dao.AccountDao;
import Hibernate.Bank_Management_System.dao.CustomerDao;
import Hibernate.Bank_Management_System.entity.Account;
import Hibernate.Bank_Management_System.entity.Customer;
import Hibernate.Bank_Management_System.util.HibernateUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class CustomerDaoIMPL implements CustomerDao {
    private CustomerDao customerDao;
    //Validation
    private Validator validator;

    public CustomerDaoIMPL() {
        customerDao = new CustomerDaoIMPL();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    //To add and save customer data
    
    @Override
    public void save(Customer customer) {
        //To Validate customer
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Customer> violation : violations) {
                System.out.println(violation.getMessage());
            }
            return;
        }
         // If it is valid, then customer data gets saved
        customerDao.save(customer);
    }
    
    		public void update(Customer customer)
    		{
    			Transaction transaction=null;
    			try(Session session=HibernateUtil.getSessionFactory().openSession())
    			{
    				//Start Transaction
    				transaction=session.beginTransaction();
    				String hql = "UPDATE Customer set name = :name " + "WHERE customer_id = :customer_id";
    				Query query = session.createQuery(hql);
    				query.setParameter("Balance", customer.getName());
    				query.setParameter("customer_id", 1);
    				int result=query.executeUpdate();
    				System.out.println("Rows affected:"+result);
    			transaction.commit();
    			}
    			catch(Exception e)
    			{
    				if(transaction!=null)
    				{
    					transaction.rollback();
    				}
    				e.printStackTrace();
    			}
    		}
    		public void delete(int customer_id)
    		{

    			Transaction transaction=null;
    			try(Session session=HibernateUtil.getSessionFactory().openSession())
    			{
    				//Start Transaction
    				transaction=session.beginTransaction();
    				Account account=session.get(Account.class, customer_id);
    				if(account!=null)
    				{
    					String hql="DELETE FROM Customer "+ "where customer_id=:customer_id";
    					Query query=session.createQuery(hql);
    				
    					query.setParameter("id", customer_id);
    					int result=query.executeUpdate();
    					System.out.println("Rows affected:"+result);
    				}
    					transaction.commit();
    				}
    				catch(Exception e)
    				{
    					if(transaction!=null)
    					{
    						transaction.rollback();
    					}
    					e.printStackTrace();
    				}
    				}
    		public Customer findById(int customer_id)
    		{
    			Transaction transaction=null;
    			Account account=null;
    			try(Session session=HibernateUtil.getSessionFactory().openSession())
    			{
    				//Start Transaction
    				transaction=session.beginTransaction();
    				
    				
    					String hql="FROM Customer C WHERE C.customer_id=:customer_id";
    					Query query=session.createQuery(hql);
    				
    					query.setParameter("id", customer_id);
    					List result=query.getResultList();
    					if( result!=null&&!result.isEmpty())
    					{
    						account=(Account)result.get(0);
    					
    				}
    					transaction.commit();
    				}
    				catch(Exception e)
    				{
    					if(transaction!=null)
    					{
    						transaction.rollback();
    					}
    					e.printStackTrace();
    				}
				return null;
    			}

    		public List<Customer>getAll()
    		{
    			try(Session session=HibernateUtil.getSessionFactory().openSession())
    			{
    				return session.createQuery("from Customer", Customer.class).list();
    			}
    		}
    			
    		}
    		

    				


    					
    					
