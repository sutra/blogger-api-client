/**
 * Created on 2006-9-29 下午10:37:15
 */
package com.redv.bloggerapi.client;

/**
 * @author Shutra
 * 
 */
public class Fault extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4239267613091786838L;

	private int code;

	/**
	 * 
	 */
	public Fault() {
	}

	/**
	 * @param message
	 */
	public Fault(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public Fault(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public Fault(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

}