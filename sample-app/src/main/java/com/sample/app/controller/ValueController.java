/**
 * 
 */
package com.sample.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.sample.app.models.Response;
import com.sample.app.services.ValueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class ValueController.
 *
 * @author BRAJENDRA SINGH
 */
@Api(value = "ValueIncrementDecrementAPI")
@RestController
public class ValueController {

	/** The value service. */
	@Autowired
	private ValueService valueService;

	/**
	 * Increment value.
	 *
	 * @return the response
	 */
	@ApiOperation(value = "it will increse value of counter", notes = "it will increse value of counter and will return value in JSON format")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "incr", method = RequestMethod.GET, produces = "application/json")
	public Response incrementValue() {

		return new Response(valueService.incrementValue());
	}

	@ApiOperation(value = "it will increse value of counter", notes = "it will increse value of counter and will return value in JSON format")
	@RequestMapping(value = "decr", method = RequestMethod.GET, produces = "application/json")
	public Response decrementValue() {

		return new Response(valueService.decrementValue());
	}

	@ApiOperation(value = "it will increse value of counter", notes = "it will increse value of counter and will return value in JSON format")
	@RequestMapping(value = "currentvalue", method = RequestMethod.GET, produces = "application/json")
	public Response getCurrentValue() {

		return new Response(valueService.getCurrentValue());
	}

}
