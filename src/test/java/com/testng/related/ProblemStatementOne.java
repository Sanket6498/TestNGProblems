package com.testng.related;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProblemStatementOne {

	ChromeOptions chromeOptions;
	ChromeDriver chromeDriver;

	@BeforeClass
	public void beforeClass() {
		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		chromeDriver = new ChromeDriver(chromeOptions);
	}

	@Test
	public void verifyLoginFunctionality() {
		chromeDriver.get("https://www.facebook.com/");
		chromeDriver.findElement(By.name("email")).sendKeys("9022724913");
		chromeDriver.findElement(By.name("pass")).sendKeys("Sanket@2953");
		chromeDriver.findElement(By.name("login")).click();
		Assert.assertTrue(chromeDriver.getCurrentUrl().contains("Home"));
	}

	@AfterClass
	public void closeBrowser() {
		chromeDriver.quit();
	}
}
