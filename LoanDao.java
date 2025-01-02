package Hibernate.Bank_Management_System.dao;

import java.util.List;

import Hibernate.Bank_Management_System.entity.Loan;

public interface LoanDao {
    void insert(Loan loan);
    Loan getById(int loanId);
    List<Loan> getAll();
    void update(Loan loan);
    void delete(int deleteLoanId);
}
