package Hibernate.Bank_Management_System.service;

import java.util.List;

import Hibernate.Bank_Management_System.dao.AccountDao;
import Hibernate.Bank_Management_System.entity.Account;

public class AccountService {
    private AccountDao accountDAO;

    public AccountService(AccountDao accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account getAccountById(Long acc_id) {
        return accountDAO.findById(acc_id);
    }

    public List<Account> getAllAccounts() {
        return accountDAO.getAll();
    }

    public void updateAccount(Account account) {
        accountDAO.update(account);
    }

    public void deleteAccount(Long acc_id) {
        accountDAO.delete(acc_id);
    }
}
