package edu.csce4623.eaduran.covid_19calculator.API;

public class CovidInfo {
	private RiskLevels riskLevels;
	private Actuals actuals;
	private String country;
	private String level;
	private String county;
	private String fips;
	private Object jsonMemberLong;
	private int population;
	private String lastUpdatedDate;
	private String locationId;
	private String state;
	private Metrics metrics;
	private Object lat;

	//debug
	private int userId;

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}
	// end debug
	public void setRiskLevels(RiskLevels riskLevels){
		this.riskLevels = riskLevels;
	}

	public RiskLevels getRiskLevels(){
		return riskLevels;
	}

	public void setActuals(Actuals actuals){
		this.actuals = actuals;
	}

	public Actuals getActuals(){
		return actuals;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return level;
	}

	public void setCounty(String county){
		this.county = county;
	}

	public String getCounty(){
		return county;
	}

	public void setFips(String fips){
		this.fips = fips;
	}

	public String getFips(){
		return fips;
	}

	public void setJsonMemberLong(Object jsonMemberLong){
		this.jsonMemberLong = jsonMemberLong;
	}

	public Object getJsonMemberLong(){
		return jsonMemberLong;
	}

	public void setPopulation(int population){
		this.population = population;
	}

	public int getPopulation(){
		return population;
	}

	public void setLastUpdatedDate(String lastUpdatedDate){
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedDate(){
		return lastUpdatedDate;
	}

	public void setLocationId(String locationId){
		this.locationId = locationId;
	}

	public String getLocationId(){
		return locationId;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setMetrics(Metrics metrics){
		this.metrics = metrics;
	}

	public Metrics getMetrics(){
		return metrics;
	}

	public void setLat(Object lat){
		this.lat = lat;
	}

	public Object getLat(){
		return lat;
	}
}
