package com.testjunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	
	
	MathUtils m;
	
	
	@BeforeAll
	static void beforeall() {
		System.out.println("Before ALL");
	}
	
	
	
	@BeforeEach
	void init() {
		System.out.println("Before Each");
	m= new MathUtils();
	}
	
	@AfterEach
	void clean() {
		System.out.println("Clean");
		}
	
	@Test
	public void testAdd() {
	//	MathUtils m = new MathUtils();
		int expected = 10;
		assertEquals(expected,m.add(5, 5),"addition");
	}
	
	@Test
	public void testDivide() {
	//	MathUtils m = new MathUtils();\
		int expected = 1;
	//	assertThrows(ArithmeticException.class, () ->m.divide(5, 5),"division" );
		assertEquals(expected,m.divide(5, 5),"division");
	}
	
}
