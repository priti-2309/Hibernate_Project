package Hibernate.Bank_Management_System.entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.*;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loan_id;
    
    @Column(length=10,nullable=false)
    @NotNull(message="Enter the loan amount")
    @Size(min=5,max=10)
    private Double amount;

    //getter and setter
	public Long getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(Long loan_id) {
		this.loan_id = loan_id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	//non-parameterized constructor
	public Loan() {
		super();
	}

	//parameterized constructor
	public Loan(Long loan_id, @NotNull(message = "Enter the loan amount") @Size(min = 5, max = 10) Double amount) {
		super();
		this.loan_id = loan_id;
		this.amount = amount;
	}

	//toString()
	@Override
	public String toString() {
		return "Loan [loan_id=" + loan_id + ", amount=" + amount + "]";
	}

}