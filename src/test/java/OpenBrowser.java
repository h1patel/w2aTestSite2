

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class OpenBrowser {

	Object path;
	WebDriver driver;

	@Test(priority = 1)
	public void localPath() {

		path = System.getProperty("user.dir");
		System.out.println(path);
		// return path;
	}

	@Test(priority = 2)
	public void setPath() {

		System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test(priority = 3)
	public void getBorwser() {

		// System.out.println("Get Browser");
		driver.get("http://www.google.com");

	}

	@Test(priority = 4)
	public void closeBorwser() throws InterruptedException {

		Thread.sleep(10000);

		// System.out.println("Get Browser");
		driver.close();
		driver.quit();
	}

}
