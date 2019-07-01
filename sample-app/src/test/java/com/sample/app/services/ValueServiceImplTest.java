/**
 * 
 */
package com.sample.app.services;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author BRAJENDRA SINGH
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValueServiceImplTest {

	@Autowired
	private ValueServiceImpl valueService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		valueService.value = 5;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.sample.app.services.ValueServiceImpl#increaseValue()}.
	 */
	@Test
	public void testIncrementValue()throws Exception{
		assertEquals(valueService.increaseValue(), 6);
	}

	/**
	 * Test method for
	 * {@link com.sample.app.services.ValueServiceImpl#decreaseValue()}.
	 */
	@Test
	public void testDecrementValue() throws Exception{
		assertEquals(valueService.decreaseValue(), 4);
	}

	/**
	 * Test method for
	 * {@link com.sample.app.services.ValueServiceImpl#getCurrentValue()}.
	 */
	@Test
	public void testGetCurrentValue() {
		assertEquals(valueService.getCurrentValue(), 5);
	}

}
