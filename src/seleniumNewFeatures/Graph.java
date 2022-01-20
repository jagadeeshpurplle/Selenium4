package seleniumNewFeatures;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Graph {
	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/tummj/Downloads/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://emicalculator.net/");
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath("//*[local-name()='svg']//*[@class='highcharts-series-group']//*[name()='rect']"));
		
		
		Actions action = new Actions(driver);
		
//		for(WebElement element : elements) {
//			action.moveToElement(element).perform();
//			Thread.sleep(500);
//		}

		List<WebElement> elements2 = driver.findElements(By.xpath("//*[local-name()='svg' and @class='highcharts-root ']//*[name()='g' and @class='highcharts-series-group']//*[name()='path']"));
		
		System.out.println(elements2.size());
		for(WebElement elemnt: elements2) {
			action.moveToElement(elemnt).perform();
			Thread.sleep(500);
		}
		
		
		WebElement slider = driver.findElement(By.xpath("//form[@id='emicalculatorform']//*[@id='loantermslider']//span"));
		action.moveToElement(slider).perform();
		
		for(int i=0;i<10;i++) {
			action.dragAndDropBy(slider, 50, 0).perform();
			Thread.sleep(500);
		}
		
		driver.close();
	}
	
}
