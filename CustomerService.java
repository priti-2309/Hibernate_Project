package Hibernate.Bank_Management_System.service;

import java.util.List;

import Hibernate.Bank_Management_System.dao.CustomerDao;
import Hibernate.Bank_Management_System.daoIMPL.CustomerDaoIMPL;
import Hibernate.Bank_Management_System.entity.Customer;

public class CustomerService {
    private CustomerDao customerDAO= new CustomerDaoIMPL();

    public CustomerService() {
        customerDAO = new CustomerDaoIMPL();  
    }

    public void save(Customer customer) {
        customerDAO.save(customer);
    }
    
    public void update(Customer customer) {
        customerDAO.save(customer);
    }
    
    public void delete(Customer customer) {
        customerDAO.save(customer);
    }
    
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }
}
