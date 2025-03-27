package RedBus;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckSeats {
WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://redbus.com");
	}


//  public void TitleCheck() {
//	  String title=driver.getTitle();
//	  System.out.println(title);
//	  Assert.assertEquals(title,"Book bus tickets online with redBus!");
//  }
  @Test
  public void Booking() throws InterruptedException, IOException {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("src")).sendKeys("delhi");
	  driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[1]/div/ul/li[3]")).click();
	  driver.findElement(By.id("dest")).sendKeys("chandigarh");
	  driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[2]/div/ul/li[1]")).click();
	  driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[6]/td[3]")).click();
	
	  driver.findElement(By.id("search_btn")).click();
	  Thread.sleep(2000);
//	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/i")).click();
//	  Thread.sleep(2000);
//	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[2]/div[2]/span")).click();
//	  Thread.sleep(2000);
//	  js.executeScript("window.scrollBy(0,300)");
//	  driver.findElement(By.xpath("//*[@id=\"17189774\"]/div/div[2]/div[1]")).click();
//	  Thread.sleep(2000);
	  js.executeScript("window.scrollBy(0,200)");
	  Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
	    String timestamp = formatter.format(d); 
	    System.out.println(timestamp);
	  File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(srcfile, new File("C:/Users/shiva/Desktop/image.jpg"));
	  boolean seatCheck=driver.findElement(By.xpath("//*[@id=\"17189774\"]/div[1]/div[2]/div[1]")).isDisplayed();
	  System.out.println(seatCheck);
	  Assert.assertTrue(seatCheck);
	
  }
	  
  @AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
