package edu.uark.models.api;

public class ActiveEmployeeCounts {
	private int activeCashierCount;
	public int getActiveCashierCount() {
		return this.activeCashierCount;
	}
	public ActiveEmployeeCounts setActiveCashierCount(int activeCashierCount) {
		this.activeCashierCount = activeCashierCount;
		return this;
	}

	private int activeShiftManagerCount;
	public int getActiveShiftManagerCount() {
		return this.activeShiftManagerCount;
	}
	public ActiveEmployeeCounts setActiveShiftManagerCount(int activeShiftManagerCount) {
		this.activeShiftManagerCount = activeShiftManagerCount;
		return this;
	}

	private int activeGeneralManagerCount;
	public int getActiveGeneralManagerCount() {
		return this.activeGeneralManagerCount;
	}
	public ActiveEmployeeCounts setActiveGeneralManagerCount(int activeGeneralManagerCount) {
		this.activeGeneralManagerCount = activeGeneralManagerCount;
		return this;
	}
	
	public ActiveEmployeeCounts() {
		this.activeCashierCount = 0;
		this.activeShiftManagerCount = 0;
		this.activeGeneralManagerCount = 0;
	}
}
