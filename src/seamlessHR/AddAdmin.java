package seamlessHR;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class AddAdmin {
	private static String adminValue = "Admin";
	private static String adminPassword = "admin123";
	
	@BeforeTest	
	public void SeamlessHRTestQuestion1() throws InterruptedException {
		
        //invoke Chromedriver frpom local
        
//        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
		
		//invoke Chromedriver using selenium Manager
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        //Save the Web the URL in a variable and launch on browser
        String web = "https://opensource-demo.orangehrmlive.com";
        driver.get(web);
        
     //Maximize the browser's view
        driver.manage().window().maximize();
        
      //using implicit wait to avoid synchronization issue
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(adminValue);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(adminPassword);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
       //Click on Admin
        driver.findElement(By.xpath("//li[1]//a[1]//span[1]")).click();
        
        //Click on Add
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")).click();
    
        //Select the User role 
       WebElement dropdownContainer= driver.findElement(By.xpath("//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]"));
       dropdownContainer.click();
       dropdownContainer.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        
//        //Select the status
        WebElement statusDropDownContainer= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div"));
//        statusDropDownContainer.click();
//        Thread.sleep(5000);
//        statusDropDownContainer.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        
        //Using actions class to click the Status dropdown
        Actions action= new Actions(driver);
        action.moveToElement(statusDropDownContainer)
        .click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER)
        .build().perform();   
        
        //Enter a Password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Password_123");
        
        //Enter Employee Name 
        WebElement EmployeeInput= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
        EmployeeInput.sendKeys("Orange Test");
        Thread.sleep(3000);
        EmployeeInput.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
       
        
        
        //Enter Username
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys("StephenAdebanji");
        
        //Enter Password Confirmation
        driver.findElement (By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("Password_123");
        
        //Click on Save
        driver.findElement (By.xpath("//button[@type='submit']")).click();
        
        Thread.sleep(5000);
		driver.quit();
       
        }}
