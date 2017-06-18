package com.symantec.exoplanet;

import static com.symantec.exoplanet.util.Constants.LARGE;
import static com.symantec.exoplanet.util.Constants.MEDIUM;
import static com.symantec.exoplanet.util.Constants.NEW_LINE;
import static com.symantec.exoplanet.util.Constants.SMALL;
import static com.symantec.exoplanet.util.Constants.TAB;
import static com.symantec.exoplanet.util.Constants.YEAR;
import static com.symantec.exoplanet.util.Constants.YEAR_NA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.symantec.exoplanet.exception.NoPlanetException;
import com.symantec.exoplanet.model.Planet;
import com.symantec.exoplanet.util.Constants;
import com.symantec.exoplanet.util.Util;

/**
 * Singleton helper class to perform business logic
 * @author Raja Asthana
 * @since Jun 2017
 */
public class ExoPlanetHelper {
	
	private static ExoPlanetHelper helper = null;
	private static ObjectMapper mapper = null;
	
	/**
	 * Private Constructor
	 */
	private ExoPlanetHelper() {
		mapper = new ObjectMapper();
	}
	
	/**
	 * Method to instantiate Helper class - Singleton
	 * @return ExoPlanetHelper
	 */
	public static synchronized ExoPlanetHelper getInstance(){
		if(null == helper){
			helper = new ExoPlanetHelper();
		}
		return helper;
	}

	/**
	 * Loads the JSON file from the given path and parses the same and returns List of Planets
	 * @param filePath
	 * @return List<Planet>
	 */
	public List<Planet> getPlanetsFromFile(String filePath){
		List<Planet> planets = null;
		try {
			File file = Util.loadFile(filePath);
			if(null == file){
				throw new FileNotFoundException("Unable to find file from the given path");
			}
			planets = mapper.readValue(Util.loadFile(filePath), new TypeReference<List<Planet>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return planets;
	}
	
	/**
	 * Gets the list of orphan planet from the array of planets.
	 * Throws NoPlanetException when there are no planet to search from.
	 * @param planets
	 * @return count
	 * @throws NoPlanetException
	 */
	public int getOrphanPlanetCount(List<Planet> planets) throws NoPlanetException{
		if(Util.isNullOrEmpty(planets)){
			throw new NoPlanetException("No Planets available in the universe!!");
		}
		return (int) planets
				.stream()
				.filter(p -> p.getTypeFlag() == Constants.ORPHAN_PLANET_CODE)
				.count();
	}
	
	/**
	 * Gets the Hottest planet from the array of planets.
	 * Throws NoPlanetException when there are no planet to search from.
	 * @param planets
	 * @return planetName
	 * @throws NoPlanetException
	 */
	public String getHottestPlanetName(List<Planet> planets) throws NoPlanetException {
		if(Util.isNullOrEmpty(planets)){
			throw new NoPlanetException("No Planets available in the universe!!");
		}
		return planets.stream().max((p1, p2) -> Integer.compare(p1.getHostStarTempK(), p2.getHostStarTempK())).get()
				.getPlanetName();
	}
	
	/**
	 * Gets the number of planets discovered year-wise grouped by count
	 * Planet is considered 
	 * 	"small" - If the Jupiter radii < 1,
	 * 	“medium” - If the Jupiter radii < 2
	 *  "large" - Otherwise
	 * @param planets
	 * @return Timeline String
	 * @throws NoPlanetException
	 */
	public String getDiscoveryTimeline(List<Planet> planets) throws NoPlanetException {
		if(Util.isNullOrEmpty(planets)){
			throw new NoPlanetException("No Planets available in the universe!!");
		}
		Map<Integer, Map<String, Long>> timelineMap = planets.stream().collect(Collectors.groupingBy(
				Planet::getDiscoveryYear, Collectors.groupingBy(Planet::getPlanetSize, Collectors.counting())));
		
		return constructTimelineText(timelineMap);
	}

	/**
	 * Helper method to construct timeline string from the timeline map
	 * @param timelineMap
	 * @return timeline string
	 */
	private String constructTimelineText(Map<Integer, Map<String, Long>> timelineMap) {
		final StringBuilder out = new StringBuilder();
		out.append(YEAR).append(TAB).append(SMALL).append(TAB).append(MEDIUM).append(TAB).append(LARGE).append(NEW_LINE);
		timelineMap.forEach((key, value) -> {
			out.append(Util.getValue(key, YEAR_NA)).append(TAB);
			value.forEach((innerKey, innerValue) -> {
				out.append(innerValue).append(TAB);
			});
			
			out.append(NEW_LINE);
		});
		return out.toString();
	}
}
