/**
 * 
 */
package com.sample.app.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sample.app.services.ValueServiceImpl;

/**
 * @author BRAJENDRA SINGH
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ValueController.class)
public class ValueControllerTest {

	@Autowired
	private MockMvc mvc;

	/** The sync client wrapper. */
	@MockBean
	private ValueServiceImpl valueService;

	private HttpHeaders headers;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Test method for
	 * {@link com.sample.app.controller.ValueController#increaseValue()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIncrementValue() throws Exception {

		Mockito.when(valueService.increaseValue()).thenReturn(5);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/incr").headers(headers)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

		String expectedResult = "{\"value\":5}";

		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
		verify(valueService, times(1)).increaseValue();
	}

	/**
	 * Test increment value with exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testIncrementValueWithException() throws Exception {

		Mockito.when(valueService.increaseValue()).thenThrow(new Exception());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/incr").headers(headers)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

		String expectedResult = "{\"value\":0}";

		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
		verify(valueService, times(1)).increaseValue();
	}

	/**
	 * Test method for
	 * {@link com.sample.app.controller.ValueController#decreaseValue()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDecrementValue() throws Exception {

		Mockito.when(valueService.decreaseValue()).thenReturn(5);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/decr").headers(headers)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

		String expectedResult = "{\"value\":5}";

		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
		verify(valueService, times(1)).decreaseValue();

	}

	/**
	 * Test decrement value with exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testDecrementValueWithException() throws Exception {

		Mockito.when(valueService.decreaseValue()).thenThrow(new Exception());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/decr").headers(headers)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

		String expectedResult = "{\"value\":0}";

		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
		verify(valueService, times(1)).decreaseValue();

	}

	/**
	 * Test method for
	 * {@link com.sample.app.controller.ValueController#getCurrentValue()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetCurrentValue() throws Exception {

		Mockito.when(valueService.getCurrentValue()).thenReturn(5);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/currentvalue").headers(headers)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

		String expectedResult = "{\"value\":5}";

		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
		verify(valueService, times(1)).getCurrentValue();

	}

}
