package TestSuit1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestngPrgm {
@Test(priority=1 )

public void login() throws InterruptedException
{

	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	//WebDriverManager.firefoxdriver().setup();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("http://magento.com");
	driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div/nav/ul/li[9]/a/span[1]/div")).click();
	driver.findElement(By.id("email")).sendKeys("lakshmisreenair@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("1234");
	driver.findElement(By.id("send2")).click();
	Thread.sleep(3000);
	String err=driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")).getText();
	//Assert.assertEquals(err,"Invalid login or pasword.");
	//if(err.equals("Invalid login or password."))
	//{
	//	System.out.println("Test Passed");
	//}
	driver.quit();
	
}

@Test (enabled=false)

public void register()
{
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	
	//WebDriverManager.FirefoxDriver.Setup();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("http://magento.com");
	driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div/nav/ul/li[9]/a/span[1]/div")).click();
	driver.findElement(By.id("register")).click();
	driver.findElement(By.id("firstname")).sendKeys("Lakshmi");
	driver.findElement(By.id("lastname")).sendKeys("VinayKrishnan");
	driver.findElement(By.id("email_address")).sendKeys("lakshhminair@gmail.com");
	driver.findElement(By.id("self_defined_company")).sendKeys("ABC");
	Select cp=new Select(driver.findElement(By.id("company_type")));
	cp.selectByValue("deployment");
	Select ir=new Select(driver.findElement(By.id("individual_role")));
	ir.selectByValue("technical/developer");
	//ir.selectByVisibleText("technical/developer");
	//ir.selectByIndex(1);
	Select ct=new Select(driver.findElement(By.id("country")));
	ct.selectByValue("US");
	
	driver.findElement(By.id("password")).sendKeys("ApexNorth123$");
	driver.findElement(By.id("password-confirmation")).sendKeys("ApexNorth123$");
	//Thread.sleep(3000);
	driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/form/fieldset[4]/div/div/div[1]/div/div/iframe")));
	driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]")).click();
	driver.switchTo().defaultContent();
	
	driver.findElement(By.id("agree_terms")).click();
	
	if(driver.findElement(By.id("agree_terms")).isSelected())
		System.out.println("Terms selected");
	driver.quit();
	
	
}

}
