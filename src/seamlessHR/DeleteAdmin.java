package seamlessHR;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DeleteAdmin {
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

		// Click on Admin
		driver.findElement(By.xpath("//li[1]//a[1]//span[1]")).click();
//		
		WebElement inputElement = driver.findElement(By.xpath(
				"//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
		// Send name to be edited
		inputElement.sendKeys("StephenAdebanjiStephenTee");

		// Click the Search 
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"))
				.click();
		
		//Selecting The whole list of Admins
		List<WebElement> AdminList = driver
				.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div"));
		if (AdminList.size() > 0) {
			WebElement employee = AdminList.get(0);
			WebElement actionsElement = employee.findElement(
					By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]"));
//			System.out.println(rows.size());
			
			//Clicking the Edit Button
//			WebElement actionsElement = rows.get(rows.size() - 1);
			WebElement button= actionsElement.findElement(By.xpath(
					"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[1]"));
//			WebElement editButton = button.get(1);
			button.click();

			// Click on Delete
			driver.findElement(
					By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]"))
					.click();
			
			Thread.sleep(5000);
			driver.quit();
		}

	}
}
