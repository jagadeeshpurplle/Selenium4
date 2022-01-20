package seleniumNewFeatures;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;


public class First {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:/chrome93/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
//		DevTools devTools = driver.getDevTools();
//		
//		devTools.createSession();
//		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("width", 600);
//		data.put("height", 1000);
//		data.put("deviceScaleFactor", 50);
//		data.put("mobile", true);
//		
//		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", data);
		
		driver.get("https://rahulshettyacademy.com/angularAppDemo/");
		
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
	
	}
}
