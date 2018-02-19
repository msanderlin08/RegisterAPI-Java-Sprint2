package edu.uark.models.repositories.interfaces;

import edu.uark.dataaccess.repository.BaseRepositoryInterface;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.enums.EmployeeClassification;

public interface EmployeeRepositoryInterface extends BaseRepositoryInterface<EmployeeEntity> {
	boolean employeeIdExists(String employeeId);
	EmployeeEntity byEmployeeId(String employeeId);
	int activeCountByClassification(EmployeeClassification employeeClassification);
}
