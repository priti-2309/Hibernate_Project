package Hibernate.Bank_Management_System.daoIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hibernate.Bank_Management_System.dao.BranchDao;
import Hibernate.Bank_Management_System.entity.Branch;

public class BranchDaoIMPL implements BranchDao {
    private Connection connection;

    public BranchDaoIMPL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Branch branch) {
        String query = "INSERT INTO branches (name, location) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, branch.getName());
            stmt.setString(2, branch.getAddress());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Branch getById(int branchId) {
        String query = "SELECT * FROM branches WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, branchId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Branch();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Branch> getAll() {
        String query = "SELECT * FROM branches";
        List<Branch> branches = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                branches.add(new Branch());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return branches;
    }

    @Override
    public void update(Branch branch) {
        String query = "UPDATE branches SET name = ?, location = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, branch.getName());
            stmt.setString(2, branch.getAddress());
            stmt.setLong(3, branch.getBranch_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int branchId) {
        String query = "DELETE FROM branches WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, branchId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
