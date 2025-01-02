package Hibernate.Bank_Management_System.daoIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hibernate.Bank_Management_System.dao.EmployeeDao;
import Hibernate.Bank_Management_System.entity.Employee;

public class EmployeeDaoIMPL implements EmployeeDao {
    private Connection connection;

    public EmployeeDaoIMPL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Employee employee) {
        String query = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getPosition());
            stmt.setDouble(3, employee.getSalary());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getById(int employeeId) {
        String query = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("position"), rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAll() {
        String query = "SELECT * FROM employees";
        List<Employee> employees = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("position"), rs.getDouble("salary")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void update(Employee employee) {
        String query = "UPDATE employees SET name = ?, position = ?, salary = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getPosition());
            stmt.setDouble(2, employee.getSalary());
            stmt.setInt(3, employee.getEmp_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int employeeId) {
        String query = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
