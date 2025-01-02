package Hibernate.Bank_Management_System.entity;

import jakarta.persistence.*;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branch_id;
    
    @Column(length=20,nullable=false)
    @NotNull(message="Enter branch name")
    private String name;
    
    @Column(length=20,nullable=false)
    @NotNull(message="Enter branch address")
    private String address;
    
    //One-to-Many relationship with Accounts
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;  // A branch has many accounts

    //One-to-Many relationship with Employees
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;  // A branch has many employees

    ////One-to-Many relationship with Customers
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customer> customers;  // A branch has many customers (via accounts)

    //getter setter
	public Long getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(Long branch_id) {
		this.branch_id = branch_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//non-parameterized constructor
	public Branch() {
		super();
	}

	//parameterized constructor
	public Branch(Long branch_id, @NotNull(message = "Enter branch name") String name,
			@NotNull(message = "Enter branch address") String address) {
		super();
		this.branch_id = branch_id;
		this.name = name;
		this.address = address;
	}

	//toString()
	@Override
	public String toString() {
		return "Branch [branch_id=" + branch_id + ", name=" + name + ", address=" + address + "]";
	}

}