package TestNGDay1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
	}
	@Test
	public void TitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
	}
	
	@Test
	public void MailTest() {
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='gb_X']"));
		for (WebElement e : elements) {
			System.out.println(e);
		}
		boolean b = driver.findElement(By.xpath("//a[text()='Gmail' and @class='gb_X']")).isDisplayed();
		Assert.assertFalse(b);
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	

}
