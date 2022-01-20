package seleniumNewFeatures;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestNGRunner {

	public static void main(String[] args) {
		
		TestNG runner = new TestNG();
		
		List<String> testNGFiles = new ArrayList<>();
		
		testNGFiles.add("C:\\Users\\tummj\\eclipse-workspace\\Selenium4\\testng.xml");
		
		runner.setTestSuites(testNGFiles);
		
		runner.run();
		
	}
}
