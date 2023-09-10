package seamlessHR;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EditAdmin {
	private static String adminValue = "Admin";
	private static String adminPassword = "admin123";

	@Test
	public void EditEmployeeTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		// Launch the Application's URL on browser
		driver.get("https://opensource-demo.orangehrmlive.com");

		// Maximize the View
		driver.manage().window().maximize();
		// using implicit wait to avoid synchronization issue
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Key in Login Parameters
		driver.findElement(By.name("username")).sendKeys(adminValue);
		driver.findElement(By.name("password")).sendKeys(adminPassword);
		// click on the submit button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Click on Admin
		driver.findElement(By.xpath("//li[1]//a[1]//span[1]")).click();
//		
		WebElement inputElement = driver.findElement(By.xpath(
				"//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
		// Send name to be edited
		inputElement.sendKeys("StephenAdebanji");

		// Click the Search
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"))
				.click();

		// Selecting The whole list of Admins
		List<WebElement> AdminList = driver
				.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div"));
		if (AdminList.size() > 0) {
			WebElement employee = AdminList.get(0);
			WebElement actionsElement = employee.findElement(
					By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]"));

			WebElement button = actionsElement.findElement(By.xpath(
					"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[2]"));
			button.click();

			// Change the Username
			driver.findElement(
					By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"))
					.sendKeys("StephenTee");

			// Click on Save
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();

			Thread.sleep(5000);
			driver.quit();
		}

	}
}
