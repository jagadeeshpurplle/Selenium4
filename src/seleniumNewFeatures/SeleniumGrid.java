package seleniumNewFeatures;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {

	
	// to start HUB: java -jar .\selenium-server-standalone-3.9.1.jar -role hub
	//to start node:  java "-Dwebdriver.chrome.driver=C:/chrome94/chromedriver.exe" -jar selenium-server-standalone-3.9.1.jar 
	//-role node -hub http://10.224.201.66:4444/grid/register/
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.WIN10);
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.merge(capabilities);
		
		String hubUrl = "http://10.224.201.66:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(hubUrl), chromeOptions);
	
		driver.get("https://www.google.com");
		
		System.out.println("Title: "+driver.getTitle());
		
		driver.quit();
	}
}
