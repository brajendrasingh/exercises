/**
 * 
 */
package com.sample.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.sample.app.models.Response;
import com.sample.app.services.ValueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ValueController.
 *
 * @author BRAJENDRA SINGH
 */
@Api(value = "ValueIncrementDecrementAPI")
@RestController
public class ValueController {

	/** The Constant logger. */
	private final static Logger logger = LoggerFactory.getLogger(ValueController.class);

	/** The value service. */
	@Autowired
	private ValueService valueService;

	/**
	 * Increment value.
	 *
	 * @return the response
	 */
	@ApiOperation(value = "it will increase value of counter", notes = "it will increase value of counter and will return value in JSON format")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved counter"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resources"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "incr", method = RequestMethod.GET, produces = "application/json")
	public Response increaseValue() {
		logger.info("method increaseValue execution starts....");
		Response res = null;

		try {
			res = new Response(valueService.increaseValue());
			logger.info("service response " + res.toString());
		} catch (Exception e) {
			res = new Response();
			logger.error("StackTrace ", e);
		}
		logger.info("method increaseValue terminates...");
		return res;
	}

	@ApiOperation(value = "it will ddecrease value of counter", notes = "it will decrease value of counter and will return value in JSON format")
	@GetMapping(value = "decr", produces = "application/json")
	public Response decreaseValue() {

		logger.info("method decreaseValue execution starts....");
		Response res = null;

		try {
			res = new Response(valueService.decreaseValue());
			logger.info("service response " + res.toString());
		} catch (Exception e) {
			res = new Response();
			logger.error("StackTrace ", e);
		}
		logger.info("method decreaseValue terminates...");
		return res;
	}

	@ApiOperation(value = "it will return current value of counter")
	@RequestMapping(value = "currentvalue", method = RequestMethod.GET, produces = "application/json")
	public Response getCurrentValue() {
		logger.info("method getCurrentValue execution starts....");
		Response res = null;
		res = new Response(valueService.getCurrentValue());
		logger.info("service response " + res.toString());
		logger.info("method getCurrentValue terminates...");
		return res;
	}

}
