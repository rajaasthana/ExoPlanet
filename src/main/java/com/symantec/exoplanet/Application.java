package com.symantec.exoplanet;

import static com.symantec.exoplanet.util.Constants.JSON_FILE_PATH;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.symantec.exoplanet.exception.NoPlanetException;
import com.symantec.exoplanet.model.Planet;

public class Application {

	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		
		List<Planet> planets = ExoPlanetHelper.getInstance().getPlanetsFromFile(JSON_FILE_PATH);
		
		printOrphanPlanetCount(planets);
		printHottestPlanet(planets);
		printDiscoveryTimeline(planets);

	}

	private static void printDiscoveryTimeline(List<Planet> planets) {
		try{
			System.out.println(ExoPlanetHelper.getInstance().getDiscoveryTimeline(planets));
		} catch(NoPlanetException ex){
			System.out.println(ex.getMessage());
		}
	}

	private static void printOrphanPlanetCount(List<Planet> planets) {
		try{
			System.out.println(ExoPlanetHelper.getInstance().getOrphanPlanetCount(planets));
		} catch(NoPlanetException ex){
			System.out.println(ex.getMessage());
		}
	}

	private static void printHottestPlanet(List<Planet> planets) {
		try{
			System.out.println(ExoPlanetHelper.getInstance().getHottestPlanetName(planets));
		}catch(NoPlanetException ex){
			System.out.println(ex.getMessage());
		}
	}
}
