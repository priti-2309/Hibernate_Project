package Hibernate.Bank_Management_System.dao;

import java.util.List;

import Hibernate.Bank_Management_System.entity.Customer;

public interface CustomerDao {
    //To add customers
	void save(Customer customer);
    
	
	//To get all Customer details
    List<Customer> getAll();
    
}
