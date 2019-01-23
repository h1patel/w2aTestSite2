package W2A;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class w2aNavigateToTestSite {

    static {	
    	
    //	System.setProperty("webdriver.chrome.driver","C:\\Users\\H\\Documents\\eclipse\\Workspace\\w2aTestSite2\\src\\main\\resources\\drivers\\chromedriver.exe");
    	WebDriverManager.chromedriver().setup();
    }

	WebDriver driver = new ChromeDriver();
	Actions action = new Actions(driver);
	WebElement element;
	WebElement menu;
	
	
	@Test
	public void openHomepage() throws InterruptedException {

		driver.get("http://www.way2automation.com/");
		
		//driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li[8]")).click();
		
		element = driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li[8]"));
		action.moveToElement(element).perform();

		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@href=\"protractor-angularjs-practice-website.html\"]")).click();
	
		
	
	}
	
	
	
}
