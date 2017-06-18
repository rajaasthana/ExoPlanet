package com.symantec.exoplanet.util;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * Utility class for Exo-Planet application
 * @author Raja Asthana
 * @since Jun 2017
 */
public class Util {

	/**
	 * Utility method to load file from the given path.
	 * Returns null if the fileName is null or path is invalid
	 * @param fileName
	 * @return File
	 */
	public static File loadFile(String fileName) {
		File file = null;
		if(null != fileName && !"".equals(fileName.trim())){
			URL fileUrl = Util.class.getClassLoader().getResource(fileName);
			if(null != fileUrl) {
				file = new File(fileUrl.getFile());
			}
		}
		return file; 
	}
	
	/**
	 * Utility method to check whether the given object is null or empty
	 * @param object
	 * @return true - if the object is null or empty; false - otherwise
	 */
	public static <E> boolean isNullOrEmpty(List<E> object){
		if(null == object || object.isEmpty()){
			return true;
		}
		return false;
	}
	
	/**
	 * Utility method to choose value or defaultValue
	 * @param value
	 * @param defaultValue
	 * @return value of not 0; defaultValue - otherwise
	 */
	public static String getValue(int value, String defaultValue){
		if(0 == value) {
			return defaultValue;
		}
		return String.valueOf(value);
	}
}
