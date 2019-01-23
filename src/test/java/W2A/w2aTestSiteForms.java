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

public class w2aTestSiteForms {

	static {	
		WebDriverManager.chromedriver().setup();
	}

	WebDriver driver = new ChromeDriver();
	WebElement element;
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver,3L);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
		
	@Test(priority=2)
	public void browserUp(){
		
		driver.manage().window().maximize();
		
		driver.get("http://www.way2automation.com/");
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		element = driver.findElement(By.xpath("//a[text() = 'Resources']"));
		action.moveToElement(element).perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Practice site 2')]"))).click();
		
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div/ul/li[2]/a/figure/img")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String homeTab = itr.next();
		String FormTab = itr.next();

		driver.switchTo().window(FormTab);
		driver.findElement(By.name("name")).sendKeys("Test1");
		driver.findElement(By.name("email")).sendKeys("test1@gmail.com");
		driver.findElement(By.xpath("//a[@href=\"#/form/interests\"]")).click();

		driver.findElement(By.className("active")).click();
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("Test");
		driver.findElement(By.xpath("//a[@href=\"#/form/interests\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		//Before selected - its NOT Displayed
		if(driver.findElement(By.xpath("//input[@type='radio'][@value='xbox']")).isDisplayed()) {
			System.out.println("Radio Button XBox Displayed");
		} else {
			System.out.println("Radio Button XBox NOT Displayed");
		}
		
		if(driver.findElement(By.xpath("//input[@type='radio'][@value='xbox']")).isEnabled()) {
			System.out.println("Radio Button XBox Enabled");
		} else {
			System.out.println("Radio Button XBox NOT Enabled");
		}
		
		if(driver.findElement(By.xpath("//input[@type='radio'][@value='xbox']")).isSelected()) {
			System.out.println("Radio Button XBox Selected");
		} else {
			System.out.println("Radio Button XBox NOT Selected");
		}
		
		System.out.println("Going to Click Radio Button");
		
		driver.findElement(By.xpath("//input[@type='radio'][@value='xbox']")).click();
		
		System.out.println("Clicked Radio Button");
		
		if(driver.findElement(By.xpath("//input[@type='radio'][@value='xbox']")).isSelected()) {
			System.out.println("Radio Button XBox Selected");
		} else {
			System.out.println("Radio Button XBox NOT Selected");
		}
		
		if(driver.findElement(By.xpath("//input[@type='radio'][@value='xbox']")).isDisplayed()) {
			System.out.println("Radio Button XBox Displayed");
		} else {
			System.out.println("Radio Button XBox NOT Displayed");
		}
		
		//********************* Change Selection **********************
		driver.findElement(By.xpath("//input[@type='radio'][@value='ps']")).click();
		
		if(driver.findElement(By.xpath("//input[@type='radio'][@value='xbox']")).isSelected()) {
			System.out.println("Radio Button XBox Selected");
		} else {
			System.out.println("Radio Button XBox NOT Selected");
		}
		
		if(driver.findElement(By.xpath("//input[@type='radio'][@value='xbox']")).isSelected()) {
			System.out.println("Radio Button XBox Selected");
		} else {
			System.out.println("Radio Button XBox NOT Selected");
		}
		
		driver.findElement(By.cssSelector("a[href='#/form/payment']")).click();
		
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		
		
		
		
	}


}
