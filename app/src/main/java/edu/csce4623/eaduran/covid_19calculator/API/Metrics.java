package edu.csce4623.eaduran.covid_19calculator.API;

public class Metrics{
	private Object icuHeadroomRatio;
	private Object icuHeadroomDetails;
	private double testPositivityRatio;
	private Object infectionRate;
	private double caseDensity;
	private TestPositivityRatioDetails testPositivityRatioDetails;
	private Object contactTracerCapacityRatio;
	private Object infectionRateCI90;

	public void setIcuHeadroomRatio(Object icuHeadroomRatio){
		this.icuHeadroomRatio = icuHeadroomRatio;
	}

	public Object getIcuHeadroomRatio(){
		return icuHeadroomRatio;
	}

	public void setIcuHeadroomDetails(Object icuHeadroomDetails){
		this.icuHeadroomDetails = icuHeadroomDetails;
	}

	public Object getIcuHeadroomDetails(){
		return icuHeadroomDetails;
	}

	public void setTestPositivityRatio(double testPositivityRatio){
		this.testPositivityRatio = testPositivityRatio;
	}

	public double getTestPositivityRatio(){
		return testPositivityRatio;
	}

	public void setInfectionRate(Object infectionRate){
		this.infectionRate = infectionRate;
	}

	public Object getInfectionRate(){
		return infectionRate;
	}

	public void setCaseDensity(double caseDensity){
		this.caseDensity = caseDensity;
	}

	public double getCaseDensity(){
		return caseDensity;
	}

	public void setTestPositivityRatioDetails(TestPositivityRatioDetails testPositivityRatioDetails){
		this.testPositivityRatioDetails = testPositivityRatioDetails;
	}

	public TestPositivityRatioDetails getTestPositivityRatioDetails(){
		return testPositivityRatioDetails;
	}

	public void setContactTracerCapacityRatio(Object contactTracerCapacityRatio){
		this.contactTracerCapacityRatio = contactTracerCapacityRatio;
	}

	public Object getContactTracerCapacityRatio(){
		return contactTracerCapacityRatio;
	}

	public void setInfectionRateCI90(Object infectionRateCI90){
		this.infectionRateCI90 = infectionRateCI90;
	}

	public Object getInfectionRateCI90(){
		return infectionRateCI90;
	}
}
