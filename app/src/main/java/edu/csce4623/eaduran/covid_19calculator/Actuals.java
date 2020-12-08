package edu.csce4623.eaduran.covid_19calculator;

public class Actuals{
	private Object contactTracers;
	private int cases;
	private int positiveTests;
	private IcuBeds icuBeds;
	private HospitalBeds hospitalBeds;
	private int newCases;
	private int negativeTests;
	private int deaths;

	public void setContactTracers(Object contactTracers){
		this.contactTracers = contactTracers;
	}

	public Object getContactTracers(){
		return contactTracers;
	}

	public void setCases(int cases){
		this.cases = cases;
	}

	public int getCases(){
		return cases;
	}

	public void setPositiveTests(int positiveTests){
		this.positiveTests = positiveTests;
	}

	public int getPositiveTests(){
		return positiveTests;
	}

	public void setIcuBeds(IcuBeds icuBeds){
		this.icuBeds = icuBeds;
	}

	public IcuBeds getIcuBeds(){
		return icuBeds;
	}

	public void setHospitalBeds(HospitalBeds hospitalBeds){
		this.hospitalBeds = hospitalBeds;
	}

	public HospitalBeds getHospitalBeds(){
		return hospitalBeds;
	}

	public void setNewCases(int newCases){
		this.newCases = newCases;
	}

	public int getNewCases(){
		return newCases;
	}

	public void setNegativeTests(int negativeTests){
		this.negativeTests = negativeTests;
	}

	public int getNegativeTests(){
		return negativeTests;
	}

	public void setDeaths(int deaths){
		this.deaths = deaths;
	}

	public int getDeaths(){
		return deaths;
	}
}
