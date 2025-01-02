package Hibernate.Bank_Management_System.daoIMPL;

import java.io.Serializable;
import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Hibernate.Bank_Management_System.dao.AccountDao;
import Hibernate.Bank_Management_System.dao.CustomerDao;
import Hibernate.Bank_Management_System.entity.Account;
import Hibernate.Bank_Management_System.entity.Customer;
import Hibernate.Bank_Management_System.util.HibernateUtil;

public class AccountDaoIMPL implements AccountDao {
	private AccountDao accountDao;
    //Validation
    private Validator validator;

    public AccountDaoIMPL() {
        accountDao = new AccountDaoIMPL();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }
		public void save(Account account)
		{
			//To Validate account
	        Set<ConstraintViolation<Account>> violations = validator.validate(account);
	        if (!violations.isEmpty()) {
	            for (ConstraintViolation<Account> violation : violations) {
	                System.out.println(violation.getMessage());
	            }
	            return;
	        }
			Transaction t=null;
			try(Session session=HibernateUtil.getSessionFactory().openSession())
			{
				//Start transaction
				session.beginTransaction();
				//operation1 	
				Object obj=session.save(account);
				//oprtn2
				session.get(Account.class, (Serializable)obj);
				//commit transaction
				t.commit();
				}
			catch(Exception e)
			{
				if(t!=null)
				{
					t.rollback();
				}
				e.printStackTrace();
			}
		}

		public void update(Account account)
		{
			Transaction transaction=null;
			try(Session session=HibernateUtil.getSessionFactory().openSession())
			{
				//Start Transaction
				transaction=session.beginTransaction();
				String hql = "UPDATE Account set balance = :balance " + "WHERE acc_id = :acc_id";
				Query query = session.createQuery(hql);
				query.setParameter("Balance", account.getBalance());
				query.setParameter("acc_id", 1);
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
		public void delete(Long acc_id)
		{

			Transaction transaction=null;
			try(Session session=HibernateUtil.getSessionFactory().openSession())
			{
				//Start Transaction
				transaction=session.beginTransaction();
				Account account=session.get(Account.class, acc_id);
				if(account!=null)
				{
					String hql="DELETE FROM Account "+ "where acc_id=:acc_id";
					Query query=session.createQuery(hql);
				
					query.setParameter("id", acc_id);
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
		public Account findById(Long acc_id)

		{

			Transaction transaction=null;
			Account account=null;
			try(Session session=HibernateUtil.getSessionFactory().openSession())
			{
				//Start Transaction
				transaction=session.beginTransaction();
				
				
					String hql="FROM Account A WHERE A.acc_id=:acc_id";
					Query query=session.createQuery(hql);
				
					query.setParameter("id", acc_id);
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
			return account;
			}

		//GetAll Accounts
		public List<Account>getAll()
		{
			try(Session session=HibernateUtil.getSessionFactory().openSession())
			{
				return session.createQuery("from Student", Account.class).list();
			}
		}
			
		}
		

				


					
					
