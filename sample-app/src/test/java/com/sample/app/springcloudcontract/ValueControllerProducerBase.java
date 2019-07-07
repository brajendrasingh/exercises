/**
 * 
 */
package com.sample.app.springcloudcontract;

import java.io.IOException;

import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sample.app.models.Response;
import com.sample.app.services.ValueService;
import io.restassured.RestAssured;


/**
 * @author BRAJENDRA SINGH
 *
 */
public abstract class ValueControllerProducerBase extends ProducerBase {

	private static final String RESPONSE_PATH = "data/json/value.json";

	@MockBean
	private ValueService valueService;

	@Before
	public void setUp() throws IOException {
		RestAssured.port = this.port;
		RestAssured.baseURI = "http://localhost";

		MockitoAnnotations.initMocks(this);
		Object ob = "{\"value\":1212}";
		Mockito.when(valueService.getCurrentValue()).thenReturn((Integer) ob);
	}

}
