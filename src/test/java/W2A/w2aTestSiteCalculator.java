package W2A;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class w2aTestSiteCalculator {

	static {
		WebDriverManager.chromedriver().setup();
	}

	WebDriver driver = new ChromeDriver();
	WebElement element, element1, element2;
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 3L);
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@Test(priority = 2)
	public void browserUp() throws InterruptedException {

		driver.manage().window().maximize();
		driver.get("http://www.way2automation.com/");

		element = driver.findElement(By.xpath("//a[text() = 'Resources']"));
		action.moveToElement(element).perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Practice site 2')]")))
				.click();

		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		driver.findElement(By.xpath("//h2[text()='Calculator']")).click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String homeTab = itr.next();
		String calcTab = itr.next();

		driver.switchTo().window(calcTab);
		
		element = driver.findElement(By.xpath("//select[@ng-model='operator']"));
		Select select = new Select(element);

		String[] mathOperator = {"SUBTRACTION","ADDITION","MULTIPLICATION","DIVISION"};
		Random randomInt = new Random();
		int i = 0;
		char[][] ch = new char[5][5]; 
		for(String operator : mathOperator) {

			i++;
			driver.findElement(By.cssSelector("input[ng-model='first']")).sendKeys(String.valueOf(randomInt.nextInt(100)));
			select.selectByValue(operator);
			driver.findElement(By.cssSelector("input[ng-model=\"second\"]")).sendKeys(String.valueOf(randomInt.nextInt(50)));
			driver.findElement(By.cssSelector("#gobutton")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']/tbody/tr["+i+"]")));
			
		}

			Thread.sleep(3000);

		driver.close();
		driver.quit();

	}

}
