package TestNGDay1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tester {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shiva\\eclipse-workspace\\TestNGDemo\\driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		
	}
//	@Test
//	public void googleHome() {
//		String title=driver.getTitle();
//		System.out.println(title);
//		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("apple iphone 13");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]")).click(); 
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1200)");
////		Actions builder = new Actions(driver);        
////		builder.sendKeys(Keys.ENTER);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.name("//*[@id=\"rso\"]/div[4]/div/div/div[1]/a/h3")).click();
//	}
	@Test
	public void amazon() {
		List<String> list1 = new ArrayList<String>();
		for (int i=1;i<=6;i++) {
			String ele = String.valueOf(i);
			String str1 = driver.findElement(By.xpath("//div[@id=\"nav-xshop\"]/a["+ele+"]")).getText();
			list1.add(str1);
		
	}
		System.out.print(list1);
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
