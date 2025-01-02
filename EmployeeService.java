package Hibernate.Bank_Management_System.service;

import java.util.List;

import Hibernate.Bank_Management_System.dao.EmployeeDao;
import Hibernate.Bank_Management_System.entity.Employee;

public class EmployeeService {
    private EmployeeDao employeeDAO;

    public EmployeeService(EmployeeDao employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void addEmployee(Employee employee) {
        employeeDAO.insert(employee);
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeDAO.getById(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    public void deleteEmployee(int employeeId) {
        employeeDAO.delete(employeeId);
    }
}
