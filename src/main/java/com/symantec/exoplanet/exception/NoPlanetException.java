package com.symantec.exoplanet.exception;

/**
 * Custom Checked Exception class which will be thrown whenever there are no planet to perform any operation
 * @author Raja Asthana
 * @since Jun 2017
 */
public class NoPlanetException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NoPlanetException(String msg) {
		super(msg);
	}

}
