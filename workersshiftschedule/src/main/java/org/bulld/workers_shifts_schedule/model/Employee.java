package org.bulld.workers_shifts_schedule.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	private long id;
	private EmployeePosition position;
	private String phone;
	private String firstName;
	private String lastName;
	private String middleName;
	
	public Employee() {
		
	}

	public Employee(EmployeePosition position, String phone, String firstName, String lastName, String middleName) {
		this.position = position;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "position_id", nullable = false)
	public EmployeePosition getPosition() {
		return position;
	}
	public void setPosition(EmployeePosition position) {
		this.position = position;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middle_name")
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id +", position=" + position + ", phone=" + phone + ", lastName=" + lastName + ", firstName=" + firstName + ", middleName=" + middleName
				+ "]";
	}
	
}
