package W2A;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class w2aImplecitWait {

	static {

		WebDriverManager.chromedriver().setup();

	}

	WebDriver driver = new ChromeDriver();

	@Test
	public void TestWait() throws InterruptedException {

		driver.get("http://www.way2automation.com/");

		
		driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li[8]")).click();

		driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li[8]/ul/li[3]")).click();

		// closes current browser window
		driver.close();
		
		// kills the WebDriver instance
		driver.quit();

	}

}
