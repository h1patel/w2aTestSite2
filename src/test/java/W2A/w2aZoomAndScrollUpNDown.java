package W2A;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class w2aZoomAndScrollUpNDown {

	static {
		WebDriverManager.chromedriver().setup();

	}

	WebDriver driver = new ChromeDriver();
	WebElement element;
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 3L);
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@Test(priority = 2)
	public void browserUp() throws InterruptedException {

		driver.manage().window().maximize();

		driver.get("http://www.way2automation.com/");

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		element = driver.findElement(By.xpath("//a[text() = 'Resources']"));
		action.moveToElement(element).perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Practice site 2')]")))
				.click();

		// driver.manage().window().setPosition(targetPosition);

		jse.executeScript("window.scrollBy(0,300)");

		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,100)");
		
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-200)");
		
		// Scroll by pixels
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-100)");

		// Scroll till element is visible
		Thread.sleep(1000);
		element = driver.findElement(By.xpath("//h2[text() = 'WebTables']"));
		jse.executeScript("arguments[0].scrollIntoView();", element);
		
		// Scroll to bottom / top
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		Thread.sleep(1000);
		jse.executeScript("document.body.style.zoom = 1.5");
		
		Thread.sleep(1000);
		jse.executeScript("document.body.style.zoom = 0.5");
		
	}

}
