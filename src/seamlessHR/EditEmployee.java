package seamlessHR;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import java.util.List;

public class EditEmployee {
	private static String adminValue = "Admin";
	private static String adminPassword = "admin123";

	@AfterTest
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

		// click on PIM
		driver.findElement(By.xpath("//ul/li[2]/a")).click();

//		Get the placeholder and send in the name to be searched
		WebElement inputElement = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		// Send name to be edited
		inputElement.sendKeys("Stephen Adebanji");

		// Click the Edit icon
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"))
				.click();

		List<WebElement> EmployeeList = driver
				.findElements(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div"));
		if (EmployeeList.size() > 0) {
			WebElement employee = EmployeeList.get(0);
			WebElement actionsElement = employee.findElement(
					By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div"));

			WebElement button = actionsElement.findElement(By.xpath(
					"//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[9]/div/button[2]"));

			button.click();

			driver.findElement(By.xpath(
					"//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div/div[1]/div/div[2]/input"))
					.sendKeys("NO");

			// Click on Save
			driver.findElement(
					By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button"))
					.click();

			Thread.sleep(5000);
			driver.quit();
		}

	}
}
