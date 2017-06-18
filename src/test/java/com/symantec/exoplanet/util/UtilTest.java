package com.symantec.exoplanet.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.symantec.exoplanet.model.Planet;

public class UtilTest {
	
	@Test
	public void testLoadFileWithNoFileName(){
		assertNull(Util.loadFile(null));
	}
	
	@Test
	public void testLoadFileWithValidFile(){
		assertNotNull(Util.loadFile("test.json"));
	}
	
	@Test
	public void testLoadFileWithInvalidFile(){
		assertNull(Util.loadFile("invalidFile.json"));
	}
	
	@Test
	public void testNullOrEmptySuccessWithNullObject(){
		assertTrue(Util.isNullOrEmpty(null));
	}
	
	@Test
	public void testNullOrEmptySuccessWithEmptyObject(){
		assertTrue(Util.isNullOrEmpty(new ArrayList<Planet>()));
	}
	
	@Test
	public void testNullOrEmptyFailureWithValidObject(){
		List<Planet> planets = new ArrayList<Planet>(){
			private static final long serialVersionUID = 1L;

			{
				add(new Planet());
			}
		};
		assertTrue(!Util.isNullOrEmpty(planets));
	}
	
	@Test
	public void testGetValueWithNullDefaultValue(){
		assertNull(Util.getValue(0, null));
	}
	
	@Test
	public void testGetValueWithDefaultDefaultValue(){
		assertEquals("N/A", Util.getValue(0, "N/A"));
	}
	
	@Test
	public void testGetValueWithValidValue(){
		assertEquals("5", Util.getValue(5, "N/A"));
	}
	
}
