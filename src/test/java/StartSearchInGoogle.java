

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class StartSearchInGoogle {

	static {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\H\\Documents\\eclipse\\Workspace\\w2aTestSite2\\src\\main\\resources\\drivers\\chromedriver.exe");
	}
	
	WebDriver driver = new ChromeDriver();
	WebElement element;
	
	

	@Test
	public void Test() throws InterruptedException {
		
		driver.get("http://www.google.com");

//		Select select = new Select(driver.findElement(By.xpath("//input[@title='Search']")));

		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium");

//		select.selectByVisibleText("selenium tutorial");
//		select.selectByValue("selenium tutorial");
//		select.selectByIndex(3);

		driver.findElement(By.xpath("//ul[@class=\"erkvQe\"]/li[3]")).click();
//		driver.findElement(By.xpath("//li[contains(text(),'selenium tutorial')]"));
//		driver.findElement(By.partialLinkText("tutorial"));
	

/*		try {

//			select.selectByVisibleText("selenium tutorial");
//			select.selectByValue("selenium tutorial");
//			select.selectByIndex(3);
//			driver.findElement(By.xpath("//li[text() = selenium tutorial]")).click();
			driver.findElement(By.xpath("//li[contains(text(),'selenium tutorial)]"));

		}
		catch(Exception e) {
			System.out.println("Cant execute select statement");
		}
*/		
	/*	Thread.sleep(5000);
		driver.close();
		driver.quit();
	*/
	}
	
}
