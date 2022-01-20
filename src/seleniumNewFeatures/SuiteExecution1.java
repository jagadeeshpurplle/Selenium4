package seleniumNewFeatures;

import org.testng.annotations.Test;

public class SuiteExecution1 extends SuiteExecution{

	@Test(priority = -1)
	public void test1() {
		System.out.println("test 1");
	}	
	@Test(priority = 0)
	public void test2() {
		System.out.println("test 1");
	}	
	@Test(priority = -98)
	public void test3() {
		System.out.println("test 1");
	}	
	@Test
	public void test4() {
		System.out.println("test 1");
	}	
	@Test
	public void test5() {
		System.out.println("test 1");
	}
}
