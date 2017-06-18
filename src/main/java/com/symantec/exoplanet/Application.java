package com.symantec.exoplanet;

import java.util.List;

import com.symantec.exoplanet.exception.NoPlanetException;
import com.symantec.exoplanet.model.Planet;
import com.symantec.exoplanet.util.Constants;

/**
 * Represents the Main class for Exo-Planet Application.
 * @author Raja Asthana
 * @since Jun 2017
 */
public class Application {

	/**
	 * Main method - Start of the execution
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Planet> planets = ExoPlanetHelper.getInstance().getPlanetsFromFile(Constants.JSON_FILE_PATH);
		
		printOrphanPlanetCount(planets);
		printHottestPlanet(planets);
		printDiscoveryTimeline(planets);

	}

	/**
	 * Gets the list of orphan planet from the array of planets and prints the count to the default outputstream.
	 * Note: When the "TypeFlag" is 3, the planet is considered as Orphan planet (without any star)
	 * @param planets
	 */
	private static void printOrphanPlanetCount(List<Planet> planets) {
		try{
			
			System.out.println("Orphan Planet Count: " + ExoPlanetHelper.getInstance().getOrphanPlanetCount(planets) + Constants.NEW_LINE);
		} catch(NoPlanetException ex){
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * Gets the Hottest planet from the array of planets and prints the name to the default outputstream.
	 * Note: Hottest planet is the planet with highest temperature (field: "HostStarTempK")
	 * @param planets
	 */
	private static void printHottestPlanet(List<Planet> planets) {
		try{
			System.out.println("Hottest Planet in the Universe: " + ExoPlanetHelper.getInstance().getHottestPlanetName(planets) + Constants.NEW_LINE);
		}catch(NoPlanetException ex){
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * Prints the number of planets discovered year-wise grouped by count
	 * Planet is considered 
	 * 	"small" - If the Jupiter radii < 1,
	 * 	“medium” - If the Jupiter radii < 2
	 *  "large" - Otherwise
	 * @param planets
	 */
	private static void printDiscoveryTimeline(List<Planet> planets) {
		try{
			System.out.println("Discovery Timeline");
			System.out.println(ExoPlanetHelper.getInstance().getDiscoveryTimeline(planets));
		} catch(NoPlanetException ex){
			System.out.println(ex.getMessage());
		}
	}
}

