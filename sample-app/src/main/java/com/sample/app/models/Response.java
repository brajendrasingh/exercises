/**
 * 
 */
package com.sample.app.models;

/**
 * @author BRAJENDRA SINGH
 *
 */

public class Response {

	private int value;

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
