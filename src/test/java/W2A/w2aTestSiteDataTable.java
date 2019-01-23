package W2A;

import java.util.Iterator;
import java.util.Set;

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

public class w2aTestSiteDataTable {

	static {
		WebDriverManager.chromedriver().setup();
	}

	WebDriver driver = new ChromeDriver();
	WebElement element, element1, element2;
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 3L);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	@Test
	public void webTables() throws InterruptedException {

		driver.manage().window().maximize();
		driver.get("http://www.way2automation.com/");

		element = driver.findElement(By.xpath("//a[text() = 'Resources']"));
		action.moveToElement(element).perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("site 2"))).click();

		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		driver.findElement(By.xpath("//h2[text()='WebTables']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String homeTab = itr.next();
		String webTab = itr.next();
		
		driver.switchTo().window(webTab);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type=\"add\"]"))).click();

		driver.findElement(By.cssSelector("input[name='FirstName']")).sendKeys("Bob");
		driver.findElement(By.cssSelector("input[name='LastName']")).sendKeys("Cat");
		driver.findElement(By.cssSelector("input[name='UserName']")).sendKeys("Bob.Cat");
		driver.findElement(By.cssSelector("input[name='Password']")).sendKeys("testing");
		
		driver.findElement(By.cssSelector("input[class='ng-pristine ng-valid'][value='15']")).click();
		
		element = driver.findElement(By.cssSelector("select[name='RoleId']"));
		Select select = new Select(element);
		select.selectByIndex(2);
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("a@b.com");
		driver.findElement(By.cssSelector("input[name='Mobilephone']")).sendKeys("9999999999");
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[ng-click='save(user)']"))).click();
		
		Thread.sleep(3000);
		
		
		
	}	
	
}
