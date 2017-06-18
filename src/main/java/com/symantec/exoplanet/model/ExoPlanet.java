package com.symantec.exoplanet.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExoPlanet {
	private List<Planet> planets;

	/**
	 * @return the planets
	 */
	public List<Planet> getPlanets() {
		return planets;
	}

	/**
	 * @param planets the planets to set
	 */
	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
}
