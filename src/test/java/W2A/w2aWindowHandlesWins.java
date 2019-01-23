package W2A;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


/******************************************************************
  Works same for either new BrowserTab or in new BrowserWindow
******************************************************************/

public class w2aWindowHandlesWins {

	static {
		WebDriverManager.chromedriver().setup();
	}
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void changeWin() throws InterruptedException {
		
		driver.get("http://www.way2automation.com/");
		
		driver.findElement(By.xpath("//a[text()='MEMBER LOGIN']")).click();
		
		ArrayList<String> handles = new ArrayList<String> (driver.getWindowHandles());
		//Set<String> handles = driver.getWindowHandles();
		
		for(String handle : handles) {
			System.out.println("Handle = "+handle);
			System.out.println(driver.getTitle());
		}
		
		driver.switchTo().window(handles.get(0));
		Thread.sleep(3000);
		driver.switchTo().window(handles.get(1));
		Thread.sleep(3000);
		driver.switchTo().window(handles.get(0));
		Thread.sleep(3000);
		driver.switchTo().window(handles.get(1));
		Thread.sleep(3000);
		driver.switchTo().window(handles.get(0));
		Thread.sleep(3000);
		driver.switchTo().window(handles.get(1));
			
	}
	
	
}
