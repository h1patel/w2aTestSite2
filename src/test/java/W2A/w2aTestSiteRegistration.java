package W2A;

import java.util.Iterator;
import java.util.Set;
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

public class w2aTestSiteRegistration {

	static {
		
		WebDriverManager.chromedriver().setup();
			
	}

	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,4L);
	Actions action = new Actions(driver);
	WebElement element;
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	
	@Test
	public void tryRegistration() throws InterruptedException {
		
		driver.manage().window().maximize();
		
		driver.get("http://www.way2automation.com/");

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Resources']")));
		action.moveToElement(element).perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("site 2"))).click();
		
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		driver.findElement(By.linkText("Registration")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		
		String homeTab = itr.next();
		String registrationTab = itr.next();
		
		Thread.sleep(3000);
		driver.switchTo().window(homeTab);
		Thread.sleep(3000);
		driver.switchTo().window(registrationTab);
		
		/*Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
		}
		*/

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		element = driver.findElement(By.xpath("//input[@id='username']"));
		element.sendKeys("angular");
		
		driver.findElement(By.cssSelector("#password")).sendKeys("password");
		
		driver.findElement(By.name("formly_1_input_username_0")).sendKeys("Test1");
		
		element = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		System.out.println(element.isDisplayed());
		System.out.println(element.isEnabled());
		element.click();
		
		Thread.sleep(1000);
		
		try {
			
			if(driver.findElement(By.xpath("//p[text()=\"You're logged in!!\"]")).isDisplayed()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href=\"#/login\"]"))).click();
			}
		} catch (Exception e) {
			System.out.println("Login Fail");
		}
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		
	}

}
