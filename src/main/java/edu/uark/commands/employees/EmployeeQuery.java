package edu.uark.commands.employees;

import java.util.UUID;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeQuery implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		EmployeeEntity employeeEntity = this.employeeRepository.get(this.employeeId);
		if (employeeEntity != null) {
			return new Employee(employeeEntity);
		} else {
			throw new NotFoundException("Employee");
		}
	}

	//Properties
	private UUID employeeId;
	public UUID getEmployeeId() {
		return this.employeeId;
	}
	public EmployeeQuery setEmployeeId(UUID employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getProductRepository() {
		return this.employeeRepository;
	}
	public EmployeeQuery setProductRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
}
