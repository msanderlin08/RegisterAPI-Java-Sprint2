package edu.uark.models.api;

import org.apache.commons.lang3.StringUtils;

public class EmployeeLogin {
	private String employeeId;
	public String getEmployeeId() {
		return this.employeeId;
	}
	public EmployeeLogin setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	private String password;
	public String getPassword() {
		return this.password;
	}
	public EmployeeLogin setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public EmployeeLogin() {
		this.password = StringUtils.EMPTY;
		this.employeeId = StringUtils.EMPTY;
	}
}
