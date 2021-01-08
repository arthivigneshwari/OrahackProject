import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadExcelFileInOACTest {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		
		String fileName = "C:\\Users\\artvigne.ORADEV\\Downloads\\OraHack\\Olympic.xlsx";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\artvigne.ORADEV\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		String baseUrl="http://144.25.88.16:8080/ui/dv";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(baseUrl);
		
		Thread.sleep(8000);
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='idUser']"));
		
		userName.sendKeys("firstuser");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='idPassword']"));
		
		password.sendKeys("welcome1");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn_login']"));
		
		loginButton.click();
		
		Thread.sleep(20000);
		
		WebElement createButton = driver.findElement(By.xpath("//span[text()='Create']"));
		
		createButton.click();
		
		Thread.sleep(5000);
		
		WebElement dataSetOption = driver.findElement(By.xpath("//div[@class='oj-button-label']/span[contains(@class,'oj-button-icon oj-start bi-va-icon-datasource_24')]"));
		
		dataSetOption.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Drop data file here or click to browse']")));
		
		WebElement uploadElement = driver.findElement(By.xpath("//form[@id='fileUploadCardff']"));
	    
	    uploadElement.click();
	    
	    Thread.sleep(5000);
	    
	    Runtime.getRuntime().exec("C:\\Users\\artvigne.ORADEV\\Desktop\\AutoIT\\fileUpload.exe");
	    System.out.println("Executed fileupload.exe - AutoIT file");
	    Thread.sleep(60000);	    
	    
	    //confirmation message
	    System.out.println("File uploaded successfully");
	    
	    //Click Add button
	    
	    WebElement addButton = driver.findElement(By.xpath("//button[contains(@class,'add_to_project_button')]/div[@class='oj-button-label']/span[text()='Add']"));
	    
	    addButton.click();
	    
	    Thread.sleep(5000);
	    
	    //Click Create Project button
	    
	    driver.findElement(By.xpath("//span[text()='Create Project']")).click();    
	    
	    Thread.sleep(5000);
	    
	    Actions actions = new Actions(driver);
	    
	    //Double Click Year Num
	    
	    actions.doubleClick(driver.findElement(By.xpath("//span[text()='Year Num']"))).perform();
	    
	    //wait.until(
		//        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Year Num']")));
	    
	    Thread.sleep(5000);	    
	    
	    //Double Click Gold Sum
	    
	    actions.doubleClick(driver.findElement(By.xpath("//span[text()='1-Gold Sum']"))).perform();
	    
        Thread.sleep(5000);
	    
	    //Click Save button
	    
	    driver.findElement(By.xpath("//button[@type='button']/div/span[contains(@class,'save')]")).click();
	    
	    //Enter a name in textbox
	    
	    driver.findElement(By.xpath("//input[@type='text' and contains(@class,'savedialog')]")).sendKeys("TestProject");
	    
	    //Click Save button in Save Project dialog
	    
	    driver.manage().window().maximize();
	    
	    driver.findElement(By.xpath("//span[text()='Save' and @class='oj-button-text']")).click();
	    
	}
	
}
