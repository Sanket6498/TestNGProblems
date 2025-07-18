import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProblemStatementTwo {

	ChromeOptions chromeOptions;
	ChromeDriver chromeDriver;

	@BeforeClass
	public void loadDriver() {
		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		chromeDriver = new ChromeDriver(chromeOptions);
	}

	@BeforeMethod
	public void beforeMethod() {
		chromeDriver.get("https://www.facebook.com/reg/");
	}

	@Test
	public void UserRegistrationValid() {
		chromeDriver.findElement(By.name("firstname")).sendKeys("Raj");
		chromeDriver.findElement(By.name("lastname")).sendKeys("More");
		chromeDriver.findElement(By.name("birthday_day")).click();
		chromeDriver.findElement(By.xpath("//*[@id=\"day\"]/option[20]")).click();
		chromeDriver.findElement(By.name("birthday_month")).click();
		chromeDriver.findElement(By.xpath("//*[@id=\"month\"]/option[1]")).click();
		chromeDriver.findElement(By.name("birthday_year")).click();
		chromeDriver.findElement(By.xpath("//*[@id=\"year\"]/option[25]")).click();
		chromeDriver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[4]/span/span[2]/label/input"))
				.click();
		chromeDriver.findElement(By.name("reg_email__")).sendKeys("raj12@gmail.com");
		chromeDriver.findElement(By.name("reg_passwd__")).sendKeys("Raj569@");
		chromeDriver.findElement(By.name("websubmit")).click();
		Assert.assertTrue(chromeDriver.getPageSource().contains("Sign up"), "This is valid page");
	}

	@Test
	public void UserRegistrationInvalid() {
		chromeDriver.findElement(By.name("firstname")).sendKeys("");
		chromeDriver.findElement(By.name("websubmit")).click();
		Assert.assertEquals(chromeDriver.getPageSource().contains("What's your name?"), "Name is required");
	}

	@AfterMethod
	public void refreshPage() {
		chromeDriver.navigate().refresh();
	}
}
