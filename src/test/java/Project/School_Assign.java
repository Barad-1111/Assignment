package Project;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class School_Assign {
	
	WebDriver driver;
	
	@BeforeSuite
	public void SetUp()throws Exception {
		//System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		driver=new ChromeDriver();
		Thread.sleep(2000);
		
		driver.get("https://facegenie-ams-school.web.app/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void Login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("testbams@gmail.com");
		driver.findElement(By.id("password")).sendKeys("facegenie");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		System.out.println("Login Successfully");
		Thread.sleep(15000);
	}	
	@Test(priority=1)
	public void Dashboard() throws Exception {
        driver.findElement(By.xpath("//div[@class='MuiFormControl-root css-1r4pjbh']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[text()='01']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-sldnni']")).click();
		driver.findElement(By.xpath("//button[@title='Previous month']")).click();
		driver.findElement(By.xpath("//*[text()='Sync Todays Attendance']")).click();
		System.out.println("Today's Attendance data has been synced");
		Thread.sleep(10000);
	}
	
	@Test(priority=2)
	public void reports() throws Exception {
		driver.findElement(By.xpath("//*[@data-testid='TrendingUpIcon']")).click();
		Thread.sleep(10000);
		System.out.println("Select Analytics and Reports");
		driver.findElement(By.xpath("//div[@class='MuiOutlinedInput-root MuiInputBase-root MuiInputBase-colorPrimary MuiInputBase-formControl  css-j5qxp9']")).click();
		driver.findElement(By.xpath("//li[text()='1']")).click();
		System.out.println("Choose bus id 1");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div/div")).click();
		driver.findElement(By.xpath("//*[text()='CLASS 2']")).click();
		System.out.println("Choose class 2");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div/div")).click();
		driver.findElement(By.xpath("//li[@data-value='C']")).click();
		System.out.println("Choose Division C");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@class='MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButtonBase-root  css-3fc02r']")).click();
		Thread.sleep(5000);
		System.out.println("Download report those who have not paid fees");
	}
		
		
		
		
		
		
	
	
	@AfterSuite
	public void Logout() throws Exception {
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Ok']")).click();
		System.out.println("Logout Successfully");
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	

}
