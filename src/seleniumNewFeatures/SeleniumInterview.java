package seleniumNewFeatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumInterview {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/chrome93/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
	//	DevTools devTools = driver.getDevTools();
	//	
	//	devTools.createSession();
	//	Map<String, Object> data = new HashMap<String, Object>();
	//	data.put("width", 600);
	//	data.put("height", 1000);
	//	data.put("deviceScaleFactor", 50);
	//	data.put("mobile", true);
	//	
	//	driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", data);

		
		
		
		driver.get("https://rahulshettyacademy.com/angularAppDemo/");
		
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		org.openqa.selenium.support.ui.Select s = new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("")));
		s.selectByIndex(0);
		Thread.sleep(3000);
		
		Set<String> windows = driver.getWindowHandles();
		
		Actions action = new Actions(driver);
		action.doubleClick();
		
		driver.findElement(By.linkText("Library")).click();
	}
}