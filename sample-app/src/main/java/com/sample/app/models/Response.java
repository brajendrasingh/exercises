/**
 * 
 */
package com.sample.app.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Response.
 *
 * @author BRAJENDRA SINGH
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1438380083933845292L;
	
	/** The value. */
	private int value;

	public Response() {
	}

	public Response(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Response [value=" + value + "]";
	}
}
