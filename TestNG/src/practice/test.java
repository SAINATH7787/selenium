package com.testng.practice;

import org.testng.annotations.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Methods {

	@BeforeSuite
	public void BS() {
		System.out.println("BS");
	}

	@BeforeTest
	public void BT() {
		System.out.println("BT");
	}

	@BeforeClass
	public void BC() {
		System.out.println("BeforeClass");
	}

	@BeforeMethod
	public void BM() {
		System.out.println("BM");

	}

	@Test(priority = 1, groups = "sai", invocationCount = 10) // expectedExceptions =
																// ArithmeticException.class,,invocationCount = 10)
	@Parameters({ "name" })
	public void invoke(String name) {
		System.out.println(name);
//		
//		int c = 0 ;
//		
//		Assert.assertEquals(c, 1 , "Not Equals to 0 ");
	}

	@Test(priority = 2 )
	@Parameters({"num"})
	public void ST(int num) {
		System.out.println("second test");
		int a=10;
		
		System.out.println(a+num);
		
	}

	@AfterMethod
	public void AM() {
		System.out.println("AM");

	}

	@AfterClass
	public void AC() {
		System.out.println("AC");
	}

	@AfterTest
	public void AT() {
		System.out.println("AT");
	}

	@AfterSuite

	public void AS() {
		System.out.println("AS");
	}

}
