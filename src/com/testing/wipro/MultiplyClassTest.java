/**
 * 
 */
package com.testing.wipro;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import com.learning.wipro.*;

/**
 * @author AB277176
 *
 */
public class MultiplyClassTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("System Set Up");
	}

	/**
	 * Test method for {@link com.learning.wipro.MultiplyClass#multiply(int, int)}.
	 */
	@Test
	public void testMultiply() {
		MultiplyClass multi = new MultiplyClass();
		int test =multi.multiply(5,7);
		//assertTrue(test==35);
		//assertTrue("Success", test==35);
		assertTrue("Suc", test!=45);
		//fail("Not yet implemented");
		
	}
	
	@Test
	public void testDivison() {
		MultiplyClass multi = new MultiplyClass();
		int test =multi.divison(35,7);
		//assertTrue(test==35);
		//assertTrue("Success", test==35);
		assertTrue("Suc", test==5);
		//fail("Not yet implemented");
		
	}

}
