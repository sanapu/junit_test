package com.testjunit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

class MathUtilsTest {
	
	

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	
	
	MathUtils m;
	TestReporter reporter;
	TestInfo info;
	
//	@BeforeAll
//	static void beforeall() {
//		System.out.println("Before ALL");
//	}
	
	
	
	@BeforeEach
	void init(TestInfo info, TestReporter reporter) {
		System.out.println("Before Each");
		this.info = info;
		this.reporter = reporter ;
	m= new MathUtils();
	reporter.publishEntry(info.getTestMethod().toString(),"reporter: " +info.getTags());
	}
	
	
	
	// add nested class
			@Nested
			@Tag("Math")
			class AddTest{
				
				@Test
				//@Disabled -- if you want to disable the test
				@DisplayName("testpositive display name +ve")
				public void testpositive() {
					int expected = 10;
					int act = m.add(5, 5);
					assertEquals(expected,act,() -> "addition "+ act);
				}
				
				// @Test
				@RepeatedTest(3) // repeat the test
				//@Disabled -- if you want to disable the test
				@DisplayName("testnegative display name -ve")
				public void testnegative(RepetitionInfo r) {
					int expected = -10;
					if(r.getCurrentRepetition() == 3) { // repetition value
					 expected = 10;
					}
					
					assertEquals(expected,m.add(-5, -5),"addition");
				}
				
			}
	
	
	
	@AfterEach
	void clean() {
		System.out.println("Clean");
		}
	
	@Test
	@Tag("Math") // configure build such that run test which has this tags
	//@Disabled -- if you want to disable the test
	@DisplayName("testAdd display name")
	public void testAdd() {
	//	MathUtils m = new MathUtils();
		int expected = 10;
		assertEquals(expected,m.add(5, 5),"addition");
	}
	
	@Test
	public void testDivide() {
	//	MathUtils m = new MathUtils();\
		int expected = 1;
		assumeTrue(false); // based on value passed (true /false or value is 10 go through or isServerUp) this test method will be executed
	//	assertThrows(ArithmeticException.class, () ->m.divide(5, 5),"division" );
		assertEquals(expected,m.divide(5, 5),"division");
	}
	
	
	
	@Test
	//@Disabled -- if you want to disable the test
	@DisplayName("testmultiply display name")
	public void testMultiply() {
	//	MathUtils m = new MathUtils();
		int expected = 25;
		//assertEquals(expected,m.multiply(5, 5),"multiplication");
		assertAll(
		() ->assertEquals(expected,m.multiply(5, 5)),
		() -> assertEquals(0,m.multiply(0, 5)),
		() -> assertEquals(-5,m.multiply(-1, 5)));
	}
	
	
	
	
	
}
