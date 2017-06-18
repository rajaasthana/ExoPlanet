package com.symantec.exoplanet;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

import com.symantec.exoplanet.ExoPlanetHelper;
import com.symantec.exoplanet.exception.NoPlanetException;
import com.symantec.exoplanet.model.Planet;

/**
 * Test Class for Exo-Planet helper
 * @author Raja Asthana
 * @since Jun 2017
 */
public class ExoPlanetHelperTest {

	@Test
	public void testGetInstance(){
		ExoPlanetHelper helperObj = ExoPlanetHelper.getInstance();
		assertNotNull(helperObj);
	}
	
	@Test
	public void testSingleton(){
		ExoPlanetHelper helperObj1 = ExoPlanetHelper.getInstance();
		ExoPlanetHelper helperObj2 = ExoPlanetHelper.getInstance();
		assertTrue(helperObj1 == helperObj2);
	}
	
	@Test
	public void testGetPlanetsFromInvalidFilePath(){
		ExoPlanetHelper helperObj = ExoPlanetHelper.getInstance();
		List<Planet> planets = helperObj.getPlanetsFromFile("invalidFile.json");
		assertTrue(null == planets);
	}
	
	@Test
	public void testGetPlanetsFromValidFilePath(){
		ExoPlanetHelper helperObj = ExoPlanetHelper.getInstance();
		List<Planet> planets = helperObj.getPlanetsFromFile("test.json");
		assertEquals(3, planets.size());
	}
	
	@Test
	public void testGetOrphanPlanetCount() throws NoPlanetException{
		ExoPlanetHelper helperObj = ExoPlanetHelper.getInstance();
		List<Planet> planets = helperObj.getPlanetsFromFile("test.json");
		assertEquals(1,helperObj.getOrphanPlanetCount(planets));
	}
	
	@Test
	public void testGetOrphanPlanetCountWithNoPlanet() {
		ExoPlanetHelper helperObj = ExoPlanetHelper.getInstance();
		try {
			helperObj.getOrphanPlanetCount(null);
			fail();
		} catch (NoPlanetException e) {
			
		}
	}
	
	@Test
	public void testGetHottestPlanetName() throws NoPlanetException{
		ExoPlanetHelper helperObj = ExoPlanetHelper.getInstance();
		List<Planet> planets = helperObj.getPlanetsFromFile("test.json");
		assertEquals("KOI-1843.03", helperObj.getHottestPlanetName(planets));
	}
	
	@Test
	public void testGetHottestPlanetWithNoPlanet() {
		ExoPlanetHelper helperObj = ExoPlanetHelper.getInstance();
		try {
			helperObj.getHottestPlanetName(null);
			fail();
		} catch (NoPlanetException e) {
			
		}
	}
	
	@Test
	public void testGetDisoveryTimeline() throws NoPlanetException{
		ExoPlanetHelper helperObj = ExoPlanetHelper.getInstance();
		List<Planet> planets = helperObj.getPlanetsFromFile("test.json");
		assertNotNull(helperObj.getDiscoveryTimeline(planets));
	}
	
	@Test
	public void testGetDiscoveryTimelineWithNoPlanet() {
		ExoPlanetHelper helperObj = ExoPlanetHelper.getInstance();
		try {
			helperObj.getHottestPlanetName(null);
			fail();
		} catch (NoPlanetException e) {
			
		}
	}
}
