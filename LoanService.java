package Hibernate.Bank_Management_System.service;

import java.util.List;

import Hibernate.Bank_Management_System.dao.LoanDao;
import Hibernate.Bank_Management_System.entity.Loan;

public class LoanService {
    private LoanDao loanDAO;

    public LoanService(LoanDao loanDAO) {
        this.loanDAO = loanDAO;
    }

    public void addLoan(Loan loan) {
        loanDAO.insert(loan);
    }

    public Loan getLoanById(int loanId) {
        return loanDAO.getById(loanId);
    }

    public List<Loan> getAllLoans() {
        return loanDAO.getAll();
    }

    public void updateLoan(Loan loan) {
        loanDAO.update(loan);
    }

    public void deleteLoan(int deleteLoanId) {
        loanDAO.delete(deleteLoanId);
    }
}
