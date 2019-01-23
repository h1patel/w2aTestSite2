

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenGoogle {

	static {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\H\\Documents\\eclipse\\Workspace\\w2aTestSite2\\src\\main\\resources\\drivers\\chromedriver.exe");
	}
	
	WebDriver driver = new ChromeDriver();

	@Test
	public void Test() throws InterruptedException {
		driver.get("http://www.gmail.com");

		Thread.sleep(5000);
		
		driver.close();
		driver.quit();
	
	}
	
}
