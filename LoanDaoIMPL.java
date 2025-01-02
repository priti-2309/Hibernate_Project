package Hibernate.Bank_Management_System.daoIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hibernate.Bank_Management_System.dao.LoanDao;
import Hibernate.Bank_Management_System.entity.Loan;

public class LoanDaoIMPL implements LoanDao {
    private Connection connection;

    public LoanDaoIMPL() {
        
    }

    @Override
    public void insert(Loan loan) {
        String query = "INSERT INTO loans (branch_id, amount) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, loan.getLoan_id());
            stmt.setDouble(2, loan.getAmount());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Loan getById(int loan_id) {
        String query = "SELECT * FROM loans WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, loan_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Loan();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Loan> getAll() {
        String query = "SELECT * FROM loans";
        List<Loan> loans = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                loans.add(new Loan());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loans;
    }

    @Override
    public void update(Loan loan) {
        String query = "UPDATE loans SET amount = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, loan.getAmount());
            stmt.setLong(2, loan.getLoan_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int deleteLoanId) {
        String query = "DELETE FROM loans WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, deleteLoanId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



		
	}

