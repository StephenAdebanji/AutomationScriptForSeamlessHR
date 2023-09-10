package seamlessHR;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class AddEmployee {
	private static String adminValue = "Admin";
	private static String adminPassword = "admin123";

	@BeforeTest
	public void AddEmployeeTest() throws InterruptedException {
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

		// Click on add
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")).click();

		// Send ESS details
		driver.findElement(By.name("firstName")).sendKeys("Stephen");
		driver.findElement(By.name("middleName")).sendKeys("Temitope");
		driver.findElement(By.name("lastName")).sendKeys("Adebanji");

		// Wait for 20 Seconds and Click on Submit
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(5000);
		driver.quit();
	}
}
