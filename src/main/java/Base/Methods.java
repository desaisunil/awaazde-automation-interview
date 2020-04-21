package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {
	
	
	
	public static WebDriver driver;
	public static WebElement element;
	
	public static WebDriver init() {
		
		return driver;
	}
	
	public static void setup() {
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		
	}
	
	
	public static void Wait() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
	}
	
	public static void click(By ele) {
		
		driver.findElement(ele).click();
	
	}

	public static String gettext(By ele) {
		
		return driver.findElement(ele).getText();
	
	}

	
	
}
