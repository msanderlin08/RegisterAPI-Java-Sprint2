package edu.uark.commands.employees;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.UnauthorizedException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.api.EmployeeLogin;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeLoginCommand implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		//Validations
		if (StringUtils.isBlank(this.employeeLogin.getEmployeeId())) {
			throw new UnprocessableEntityException("employee ID");
		}
		
		EmployeeEntity employeeEntity = this.employeeRepository.byEmployeeId(this.employeeLogin.getEmployeeId());
		if ((employeeEntity == null) || !employeeEntity.getPassword().equals(EmployeeEntity.hashPassword(this.employeeLogin.getPassword()))) {
			throw new UnauthorizedException();
		}

		return new Employee(employeeEntity);
	}

	//Properties
	private EmployeeLogin employeeLogin;
	public EmployeeLogin getEmployeeLogin() {
		return this.employeeLogin;
	}
	public EmployeeLoginCommand setEmployeeLogin(EmployeeLogin employeeLogin) {
		this.employeeLogin = employeeLogin;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getProductRepository() {
		return this.employeeRepository;
	}
	public EmployeeLoginCommand setProductRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeLoginCommand() {
		this.employeeLogin = new EmployeeLogin();
		this.employeeRepository = new EmployeeRepository();
	}
}
