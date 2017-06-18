package com.symantec.exoplanet.util;

import java.io.File;
import java.net.URL;
import java.util.List;

public class Util {

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
	
	public static <E> boolean isNullOrEmpty(List<E> object){
		if(null == object || object.isEmpty()){
			return true;
		}
		return false;
	}
	
	public static String getValue(int value, String defaultValue){
		if(0 == value) {
			return defaultValue;
		}
		return String.valueOf(value);
	}
}
