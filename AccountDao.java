package Hibernate.Bank_Management_System.dao;

import java.util.List;

import Hibernate.Bank_Management_System.entity.Account;


import java.util.List;

public interface AccountDao {
    void save(Account account);
    void update(Account account);
    void delete(Long acc_id);
    Account findById(Long acc_id);
	List<Account> getAll();
}