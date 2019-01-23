package W2A;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class w2aTestSiteBanking {

	static {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
	}
	
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	WebElement element;
	Actions action = new Actions(driver);
	
	@Test
	public void bankingPage() throws InterruptedException {
		
		driver.get("http://www.way2automation.com/");
		
		driver.findElement(By.xpath("//a[text()='Resources']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("site 2"))).click();
		
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		driver.findElement(By.xpath("//h2[text()='Banking']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String homeTab = itr.next();
		String bankTab = itr.next();
		
		driver.switchTo().window(bankTab);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Customer Login']"))).click();
		
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userSelect")));
		Select select = new Select(element);
		
		select.selectByIndex(3);
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Login']"))).click();
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Home']"))).click();
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Bank Manager Login']"))).click();
		
		Thread.sleep(3000);
		
//		action.keyDown(Keys.ALT).sendKeys(Keys.F4).keyUp(null).perform();
		
	
		driver.close();
//		driver.quit();
//		
	}
	
}
