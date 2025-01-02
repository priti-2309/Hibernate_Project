package Hibernate.Bank_Management_System.entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long acc_id;
    
    @Column(length=10,nullable=false)
    @NotNull(message="Enter the amount")
    @Size(min=3,max=10)
    private Double balance;

    @OneToOne(cascade=CascadeType.ALL,mappedBy="account",fetch=FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
  
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;
    
    //getters and setters
	public Long getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(Long acc_id) {
		this.acc_id = acc_id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	//non-parameterized constructor
	public Account() {
		super();
	}

	//parameterized constructor
	public Account(Long acc_id,
			@NotNull(message = "Enter the amount") @Size(min = 3, max = 10) Double balance) {
		super();
		this.acc_id = acc_id;
		this.balance = balance;
	}

	//toString()
	@Override
	public String toString() {
		return "Account [acc_id=" + acc_id + ", balance=" + balance + "]";
	}
}
	
	

    