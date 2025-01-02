package Hibernate.Bank_Management_System.service;

import java.util.List;

import Hibernate.Bank_Management_System.dao.BranchDao;
import Hibernate.Bank_Management_System.entity.Branch;

public class BranchService {
    private BranchDao branchDAO;

    public BranchService(BranchDao branchDAO) {
        this.branchDAO = branchDAO;
    }

    public void addBranch(Branch branch) {
        branchDAO.insert(branch);
    }

    public Branch getBranchById(int branchId) {
        return branchDAO.getById(branchId);
    }

    public List<Branch> getAllBranches() {
        return branchDAO.getAll();
    }

    public void updateBranch(Branch branch) {
        branchDAO.update(branch);
    }

    public void deleteBranch(int branchId) {
        branchDAO.delete(branchId);
    }
}
