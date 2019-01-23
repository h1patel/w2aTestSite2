

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectFromSearchOptionsInGoogle {

	static {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\H\\Documents\\eclipse\\Workspace\\w2aTestSite2\\src\\main\\resources\\drivers\\chromedriver.exe");
	}
	
	WebDriver driver = new ChromeDriver();
	WebElement element;
	

	@Test
	public void Test() throws InterruptedException {
		
		driver.get("http://www.google.com");

		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium");
				
	/*	Thread.sleep(5000);
		driver.close();
		driver.quit();
	*/
	}
	
}
