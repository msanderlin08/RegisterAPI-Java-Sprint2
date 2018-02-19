package edu.uark.commands.employees;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.ActiveEmployeeCounts;
import edu.uark.models.enums.EmployeeClassification;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class ActiveEmployeeCountsQuery implements ResultCommandInterface<ActiveEmployeeCounts> {
	@Override
	public ActiveEmployeeCounts execute() {
		return ((EmployeeClassification.map(this.classification) == EmployeeClassification.NOT_DEFINED)
			? this.queryAllActiveCounts()
			: this.queryActiveCountsByClassification());
	}
	
	private ActiveEmployeeCounts queryActiveCountsByClassification() {
		ActiveEmployeeCounts activeEmployeeCounts = new ActiveEmployeeCounts();
		EmployeeClassification mappedEmployeeClassification = EmployeeClassification.map(this.classification);
		int activeCount = this.employeeRepository.activeCountByClassification(mappedEmployeeClassification);
		
		if (mappedEmployeeClassification == EmployeeClassification.CASHIER) {
			activeEmployeeCounts.setActiveCashierCount(activeCount);
		} else if (mappedEmployeeClassification == EmployeeClassification.SHIFT_MANAGER) {
			activeEmployeeCounts.setActiveShiftManagerCount(activeCount);
		} else if (mappedEmployeeClassification == EmployeeClassification.GENERAL_MANAGER) {
			activeEmployeeCounts.setActiveGeneralManagerCount(activeCount);
		}
		
		return activeEmployeeCounts;
	}
	
	private ActiveEmployeeCounts queryAllActiveCounts() {
		//Generally it would be better to run a single query, probably using a GROUP BY clause, to count all records by classification.
		return (new ActiveEmployeeCounts()).
			setActiveCashierCount(
				this.employeeRepository.activeCountByClassification(EmployeeClassification.CASHIER)
			).
			setActiveShiftManagerCount(
				this.employeeRepository.activeCountByClassification(EmployeeClassification.SHIFT_MANAGER)
			).
			setActiveGeneralManagerCount(
				this.employeeRepository.activeCountByClassification(EmployeeClassification.GENERAL_MANAGER)
			);
	}
	
	private int classification;
	public int getEmployeeClassification() {
		return this.classification;
	}
	public ActiveEmployeeCountsQuery setEmployeeClassification(int classification) {
		this.classification = classification;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getProductRepository() {
		return this.employeeRepository;
	}
	public ActiveEmployeeCountsQuery setProductRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public ActiveEmployeeCountsQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
}
