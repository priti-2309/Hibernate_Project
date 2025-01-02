package Hibernate.Bank_Management_System.dao;

import java.util.List;

import Hibernate.Bank_Management_System.entity.Employee;

public interface EmployeeDao {
    void insert(Employee employee);
    Employee getById(int emp_id);
    List<Employee> getAll();
    void update(Employee employee);
    void delete(int emp_id);
}
