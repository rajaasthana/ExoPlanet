package com.symantec.exoplanet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet {
	
	@JsonProperty(value = "PlanetIdentifier")
	private String planetName;
	
	@JsonProperty(value = "TypeFlag")
	private int typeFlag;
	
	@JsonProperty(value = "HostStarTempK")
	private int hostStarTempK;
	
	@JsonProperty(value = "DiscoveryYear")
	private int discoveryYear;
	
	@JsonProperty(value = "RadiusJpt")
	private double jupiterRadii;
	
			
	/**
	 * @return the typeFlag
	 */
	public int getTypeFlag() {
		return typeFlag;
	}

	/**
	 * @param typeFlag the typeFlag to set
	 */
	public void setTypeFlag(int typeFlag) {
		this.typeFlag = typeFlag;
	}

	/**
	 * @return the hostStarTempK
	 */
	public int getHostStarTempK() {
		return hostStarTempK;
	}

	/**
	 * @param hostStarTempK the hostStarTempK to set
	 */
	public void setHostStarTempK(int hostStarTempK) {
		this.hostStarTempK = hostStarTempK;
	}

	/**
	 * @return the planetName
	 */
	public String getPlanetName() {
		return planetName;
	}

	/**
	 * @param planetName the planetName to set
	 */
	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	/**
	 * @return the discoveryYear
	 */
	public int getDiscoveryYear() {
		return discoveryYear;
	}

	/**
	 * @param discoveryYear the discoveryYear to set
	 */
	public void setDiscoveryYear(int discoveryYear) {
		this.discoveryYear = discoveryYear;
	}

	/**
	 * @return the jupiterRadii
	 */
	public double getJupiterRadii() {
		return jupiterRadii;
	}

	/**
	 * @param jupiterRadii the jupiterRadii to set
	 */
	public void setJupiterRadii(double jupiterRadii) {
		this.jupiterRadii = jupiterRadii;
	}
	
	public String getPlanetSize(){
		if(getJupiterRadii() < 1){
			return "Small";
		}else if(getJupiterRadii() < 2){
			return "Medium";
		}else{
			return "Large";
		
		}
	}
	
	
	
}
