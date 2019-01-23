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
import org.testng.annotations.Test;

public class w2aWindowHandlesTabs {

	static {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
	}

	WebDriver driver = new ChromeDriver();
	Actions action = new Actions(driver);
	WebElement element;
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@Test
	public void winHanldes() throws InterruptedException {

		driver.manage().window().maximize();
		driver.get("http://www.way2automation.com/");

		driver.findElement(By.xpath("//a[text()='Resources']")).click();
//		element = driver.findElement(By.xpath("//a[text()='Resources']"));
//		action.moveToElement(element).perform();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("site 2")).click();

		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		driver.findElement(By.linkText("Registration")).click();

		driver.findElement(By.linkText("Multi Form")).click();

		driver.findElement(By.xpath("//h2[text()='Calculator']")).click();

		driver.findElement(By.xpath("//h2[text()='Checkboxes']")).click();

		driver.findElement(By.xpath("//h2[text()='Banking']")).click();

		driver.findElement(By.xpath("//h2[text()='WebTables']")).click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();

		String mainTab = itr.next();
		String WebTablesTab = itr.next();
		String BankingTab = itr.next();
		String CheckBoxesTab = itr.next();
		String CalculatorTab = itr.next();
		String MultiFormTab = itr.next();
		String RegisterationTab = itr.next();
		
		Thread.sleep(4000);
		driver.switchTo().window(mainTab);
		Thread.sleep(4000);
		driver.switchTo().window(RegisterationTab);
		Thread.sleep(4000);
		driver.switchTo().window(MultiFormTab);
		Thread.sleep(4000);
		driver.switchTo().window(CalculatorTab);
		Thread.sleep(4000);
		driver.switchTo().window(CheckBoxesTab);
		Thread.sleep(4000);
		driver.switchTo().window(BankingTab);
		Thread.sleep(4000);
		driver.switchTo().window(WebTablesTab);
		Thread.sleep(4000);
		driver.switchTo().window(mainTab);
		Thread.sleep(4000);
		
		driver.close();
		driver.quit();

	}

}
