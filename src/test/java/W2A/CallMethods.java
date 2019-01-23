package W2A;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CallMethods {

	static {
		
	}
	
	
	public static void setup() {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		
		driver.get("http://www.way2automation.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Resources']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("site 2"))).click();
		
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}
	
}
