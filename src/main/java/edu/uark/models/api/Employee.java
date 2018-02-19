package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.enums.EmployeeClassification;

public class Employee {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Employee setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String employeeId;
	public String getEmployeeId() {
		return this.employeeId;
	}
	public Employee setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	private String firstName;
	public String getFirstName() {
		return this.firstName;
	}
	public Employee setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	private String lastName;
	public String getLastName() {
		return this.lastName;
	}
	public Employee setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	private String password;
	public String getPassword() {
		return this.password;
	}
	public Employee setPassword(String password) {
		this.password = password;
		return this;
	}

	private boolean active;
	public boolean getActive() {
		return this.active;
	}
	public Employee setActive(boolean active) {
		this.active = active;
		return this;
	}

	private int classification;
	public int getClassification() {
		return this.classification;
	}
	public Employee setClassification(int classification) {
		this.classification = classification;
		return this;
	}

	private UUID managerId;
	public UUID getManagerId() {
		return this.managerId;
	}
	public Employee setManagerId(UUID managerId) {
		this.managerId = managerId;
		return this;
	}
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Employee setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	public Employee() {
		this.active = false;
		this.id = new UUID(0, 0);
		this.managerId = new UUID(0, 0);
		this.lastName = StringUtils.EMPTY;
		this.password = StringUtils.EMPTY;
		this.firstName = StringUtils.EMPTY;
		this.employeeId = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
		this.classification = EmployeeClassification.NOT_DEFINED.getValue();
	}
	
	public Employee(EmployeeEntity employeeEntity) {
		this.id = employeeEntity.getId();
		this.password = StringUtils.EMPTY;
		this.active = employeeEntity.getActive();
		this.lastName = employeeEntity.getLastName();
		this.createdOn = employeeEntity.getCreatedOn();
		this.firstName = employeeEntity.getFirstName();
		this.managerId = employeeEntity.getManagerId();
		this.employeeId = employeeEntity.getEmployeeId();
		this.classification = employeeEntity.getClassification().getValue();
	}
}
