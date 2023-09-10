package seamlessHR;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteEmployee {
	private static String adminValue = "Admin";
	private static String adminPassword = "admin123";

	@Test
	public void DeleteEmployeeTest() throws InterruptedException {
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

		// click on PIM
		driver.findElement(By.xpath("//ul/li[2]/a")).click();

		//
		WebElement inputElement = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));

		inputElement.sendKeys("Stephen Adebanji");

		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"))
				.click();
		List<WebElement> EmployeeList = driver
				.findElements(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div"));
		if (EmployeeList.size() > 0) {
			WebElement employee = EmployeeList.get(0);
			List<WebElement> rows = employee.findElements(
					By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div"));
			WebElement actionsElement = rows.get(rows.size() - 1);
			List<WebElement> buttons = actionsElement.findElements(By.xpath(
					"//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[9]/div/button"));
			WebElement editButton = buttons.get(0);
			editButton.click();

			// Answer Yes Delete
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();

			Thread.sleep(5000);
			driver.quit();

		}
	}

}
