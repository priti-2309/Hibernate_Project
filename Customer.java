package Hibernate.Bank_Management_System.entity;
import jakarta.persistence.*;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity  
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    
    @Column(length=20,nullable=false)
    @NotNull(message="Name is required")
    @Size(min=2,max=20)
    private String name;
    
    @Column(length=30,nullable=false,unique=true)
    @NotNull(message="Email is required")
    @Email(message="Email should be valid")
    private String email;
    
    @Column(length=30,nullable=false,unique=true)
    @NotNull(message="Phone number is required")
    @Pattern(regexp="[6789]{1}[0-9]{9}",message="Enter proper phone number")
    private String phone;
    
    @ManyToOne
    @JoinColumn(name = "branch_id")  // Foreign key to Branch
    private Branch branch;  // Each customer belongs to one branch (via their account)

    @OneToOne(cascade=CascadeType.ALL,mappedBy="customer",fetch=FetchType.LAZY)
    @JoinColumn(name="acc_id") //Foreign key to Account
    private Account account;
    @Column(name="balance") //joining balance column to customer table
    private Double balance;

    //Getters and setters
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
    //non-parameterized constructor
	public Customer() {
		super();
	}

	//parameterized constructor
	public Customer(int id, @NotNull(message = "Name is required") @Size(min = 2, max = 20) String name,
			@NotNull(message = "Email is required") @Email(message = "Email should be valid") String email,
			@NotNull(message = "Phone number is required") @Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter proper phone number") String phone) {
		super();
		this.customer_id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	//toString() 
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", name=" + name + ", email=" + email + ", phone="
				+ phone + "]";
	}
}