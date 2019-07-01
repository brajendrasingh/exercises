/**
 * 
 */
package com.sample.app.services;


/**
 * The Interface ValueService.
 *
 * @author BRAJENDRA SINGH
 */
public interface ValueService {

	/**
	 * Increment value.
	 *
	 * @return the int
	 */
	public int increaseValue()throws Exception;

	/**
	 * Decrement value.
	 *
	 * @return the int
	 */
	public int decreaseValue()throws Exception;

	/**
	 * Gets the current value.
	 *
	 * @return the current value
	 */
	public int getCurrentValue();

}
