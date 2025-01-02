package Hibernate.Bank_Management_System.entity;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;
    
    @Column(length=20,nullable=false)
    @NotNull(message="Enter the employee's name")
    @Size(min=2,max=20)
    private String name;
    
    @Column(length=20,nullable=false)
    @NotNull(message="Enter the employee's position")
    private String position;
    
    @Column(length=6,nullable=false)
    @NotNull(message="Enter the employee's salary")
    @Size(min=5,max=6)
    private Double salary;

    //getter and setter
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	//non-parameterized constructor
	public Employee() {
		super();
	}

	//parameterized constructor
	public Employee(int emp_id, @NotNull(message = "Enter the employee's name") @Size(min = 2, max = 20) String name,
			@NotNull(message = "Enter the employee's position") String position,
			@NotNull(message = "Enter the employee's salary") @Size(min = 5, max = 6) Double salary) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.position = position;
		this.salary = salary;
	}

	//toString()
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", position=" + position + ", salary=" + salary + "]";
	}

}

	