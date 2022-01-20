package seleniumNewFeatures;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class WindowHandles {


	WebDriver driver;
	
	@Parameters("browser")
	@Test
	public void test(String browserName) throws InterruptedException {
		
		
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\tummj\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/chrome94/chromedriver.exe");
			driver = new ChromeDriver();
		
		}
		

		driver.get("http://seleniumpractise.blogspot.com/2017/07");

		System.out.println(driver.getTitle());
		String parent = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[contains(@href,'www.google.com')]")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String window: allWindows) {
			if(!parent.equals(window)) {
				driver.switchTo().window(window);
				Thread.sleep(2000);
				driver.findElement(By.name("q")).sendKeys("Selenium webdriver");
				Thread.sleep(2000);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
