package Hibernate.Bank_Management_System.dao;

import java.util.List;

import Hibernate.Bank_Management_System.entity.Branch;

public interface BranchDao {
    void insert(Branch branch);
    Branch getById(int branch_id);
    List<Branch> getAll();
    void update(Branch branch);
    void delete(int branch_id);
}
