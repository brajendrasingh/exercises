/**
 * 
 */
package com.sample.app.springcloudcontract;

import java.io.IOException;

import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.context.WebApplicationContext;

import com.sample.app.controller.ValueController;
import com.sample.app.models.Response;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * @author BRAJENDRA SINGH
 *
 */
public abstract class ValueControllerProducerBase extends ProducerBase {

	private static final String RESPONSE_PATH = "data/json/value.json";

	@MockBean
	private ValueController valueController;

	@Autowired
    private WebApplicationContext context;
	
	@Before
	public void setUp() throws IOException {
		RestAssured.port = this.port;
		RestAssured.baseURI = "http://localhost";

		MockitoAnnotations.initMocks(this);
	
		Response r = new Response(5465432);
		RestAssuredMockMvc.webAppContextSetup(context);
		Mockito.when(valueController.getCurrentValue()).thenReturn(r);
		
	}

}
