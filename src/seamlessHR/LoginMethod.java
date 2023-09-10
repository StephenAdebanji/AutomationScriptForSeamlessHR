package seamlessHR;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginMethod {
	private static String adminValue = "Admin";
	private static String adminPassword = "admin123";
	public void login() {
		WebDriver driver=new ChromeDriver();
		
		//Launch the Application's URL on browser
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		//Maximize the View
		driver.manage().window().maximize();
		//using implicit wait to avoid synchronization issue
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Key in Login Parameters
		driver.findElement(By.name("username")).sendKeys(adminValue);
		driver.findElement(By.name("password")).sendKeys(adminPassword);
		//click on the submit button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
