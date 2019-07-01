/**
 * 
 */
package com.sample.app.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author BRAJENDRA SINGH
 *
 */
public interface ValueService {

	public int incrementValue();

	public int decrementValue();

	public int getCurrentValue();

}
