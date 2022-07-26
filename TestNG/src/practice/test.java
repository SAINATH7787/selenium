package practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test {

	@BeforeMethod
	public void BM() {
		System.out.println("BM");
		
	}
	@Test(priority = 1,groups = "sai",invocationCount = 10)//expectedExceptions = ArithmeticException.class,,invocationCount = 10)
	@Parameters({"num"})
	public void invoke(String num) {
		System.out.println(num);
//		
//		int c = 0 ;
//		
//		Assert.assertEquals(c, 1 , "Not Equals to 0 ");
	}
	
	@Test(priority = 2,groups = "san",dependsOnMethods = "invoke")
	public void ST() {
		System.out.println("second test");
	}

	@AfterMethod
	public void AM() {
		System.out.println("AM");
	}
	
}
