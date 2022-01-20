package seleniumNewFeatures;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SuiteExecution {

	@BeforeSuite
	public void beforeSuit() {
		System.out.println("Before suite");
	}
	
	@AfterSuite
	public void afterSuit() {
		System.out.println("After suite");
	}
	
	@Test
	public void test() {
		System.out.println("base class test");
	}
}
