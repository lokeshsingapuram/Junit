package com.tcs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.boot.test.context.SpringBootTest;

import com.tcs.source.Calculator;

@SpringBootTest
class ApplicationTests {
	
	private static Calculator calc=null;
	//Instead of @ignore is not working so we use @disabled
	//Instead of @Beforeclass we use @BeforeAll
	//Instead of @Afterclass we use @AfterAll 
	//@Timeout
	//Expected Attribute we use instead of Assertion.assertThrows

	@BeforeAll
	public static void init() {
		calc=new Calculator();
		
	}
	
	@Test
	@Disabled	
	void testadd_01() {
		Integer actual = calc.add(100, 200);
		Integer expected=300;
		assertEquals(expected, actual);
		
	
	}
	
	@Test
	void testadd_02() {
		Integer actual = calc.add(200, 200);
		Integer expected=400;
		assertEquals(expected, actual);
		
	
	}
	@Test
	void testadd_03() {
		Integer actual = calc.add(100, 200);
		Integer expected=300;
		assertEquals(expected, actual);
		
	
	}
	@Test
	void testadd_04() {
		Integer actual = calc.multiplication(10, 20);
		Integer expected=200;
		assertEquals(expected, actual);
		
	
	}
	@Test
	void testdiv_01() {
		/*
		 * Integer actual=calc.div(5, 0); Integer expected=0; assertEquals(expected,
		 * actual);
		 */
		Assertions.assertThrows(ArithmeticException.class,()->calc.div(5,0));
	}
	@Test
	@Timeout(value=1000,unit=TimeUnit.MILLISECONDS)
	void testsub_02() {
		
		  Integer actual=calc.sub(20, 4); 
		  Integer expected=16;
		  assertEquals(expected,actual);
		 
		
		
	}
	@AfterAll
	public static void destroy() {
		calc=null;
		
	}
	

}
