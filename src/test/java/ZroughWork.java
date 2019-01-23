import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZroughWork {

	static {
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe")
		WebDriverManager.chromedriver().setup();
		
	}
	
	WebDriver driver = new ChromeDriver();
	WebElement element;
	
	@Test
	public void test() throws InterruptedException {
		
	//	System.out.println(System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
		
		driver.get("http://www.way2automation.com/angularjs-protractor/registeration/#/login");
		
		Thread.sleep(2000);
		
		element = driver.findElement(By.xpath("//input[@id='username']"));
		element.sendKeys("username");
		
	}
	
}
