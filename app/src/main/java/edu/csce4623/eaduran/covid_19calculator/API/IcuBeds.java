package edu.csce4623.eaduran.covid_19calculator.API;

public class IcuBeds{
	private Object currentUsageTotal;
	private Object currentUsageCovid;
	private Object typicalUsageRate;
	private Object capacity;

	public void setCurrentUsageTotal(Object currentUsageTotal){
		this.currentUsageTotal = currentUsageTotal;
	}

	public Object getCurrentUsageTotal(){
		return currentUsageTotal;
	}

	public void setCurrentUsageCovid(Object currentUsageCovid){
		this.currentUsageCovid = currentUsageCovid;
	}

	public Object getCurrentUsageCovid(){
		return currentUsageCovid;
	}

	public void setTypicalUsageRate(Object typicalUsageRate){
		this.typicalUsageRate = typicalUsageRate;
	}

	public Object getTypicalUsageRate(){
		return typicalUsageRate;
	}

	public void setCapacity(Object capacity){
		this.capacity = capacity;
	}

	public Object getCapacity(){
		return capacity;
	}
}
