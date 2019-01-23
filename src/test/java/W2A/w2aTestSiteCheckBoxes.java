package W2A;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class w2aTestSiteCheckBoxes {

	static {
		WebDriverManager.chromedriver().setup();
	}
	
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	WebElement element;
	
	@Test
	public void checkBoxes() throws InterruptedException {
		
		driver.get("http://www.way2automation.com/");
		
		driver.findElement(By.xpath("//a[text()='Resources']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("site 2"))).click();
		
		jse.executeScript("window.scrollBy(0,document.body.ScrollHeight)");
		
		driver.findElement(By.xpath("//h2[contains(text(),'Checkboxes')]")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String homeTab = itr.next();
		String chkboxTab = itr.next();
		
		driver.switchTo().window(chkboxTab);		
		
		Thread.sleep(2000);
		//wait.until(ExpectedCondition)
		driver.findElement(By.xpath("//input[@type='checkbox'][@ng-model='data.root']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='checkbox'][@ng-model='data.root']")).click();
		
		System.out.println(driver.findElement(By.xpath("//h4[text()=' Hammer']/input[@type='checkbox'][@ng-model='prod.included']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//h4[text()=' Hammer']/input[@type='checkbox'][@ng-model='prod.included']")).isEnabled());

		driver.findElement(By.xpath("//h4[text()=' Hammer']/input[@type='checkbox'][@ng-model='prod.included']")).click();

		System.out.println(driver.findElement(By.xpath("//h4[text()=' Hammer']/input[@type='checkbox'][@ng-model='prod.included']")).isSelected());
		
		
	}
}
