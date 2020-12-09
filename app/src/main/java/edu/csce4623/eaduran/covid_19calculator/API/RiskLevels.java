package edu.csce4623.eaduran.covid_19calculator.API;

public class RiskLevels{
	private int icuHeadroomRatio;
	private int testPositivityRatio;
	private int infectionRate;
	private int caseDensity;
	private int overall;
	private int contactTracerCapacityRatio;

	public void setIcuHeadroomRatio(int icuHeadroomRatio){
		this.icuHeadroomRatio = icuHeadroomRatio;
	}

	public int getIcuHeadroomRatio(){
		return icuHeadroomRatio;
	}

	public void setTestPositivityRatio(int testPositivityRatio){
		this.testPositivityRatio = testPositivityRatio;
	}

	public int getTestPositivityRatio(){
		return testPositivityRatio;
	}

	public void setInfectionRate(int infectionRate){
		this.infectionRate = infectionRate;
	}

	public int getInfectionRate(){
		return infectionRate;
	}

	public void setCaseDensity(int caseDensity){
		this.caseDensity = caseDensity;
	}

	public int getCaseDensity(){
		return caseDensity;
	}

	public void setOverall(int overall){
		this.overall = overall;
	}

	public int getOverall(){
		return overall;
	}

	public void setContactTracerCapacityRatio(int contactTracerCapacityRatio){
		this.contactTracerCapacityRatio = contactTracerCapacityRatio;
	}

	public int getContactTracerCapacityRatio(){
		return contactTracerCapacityRatio;
	}
}
