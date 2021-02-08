package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Home {
	
	public static final String URL="https://www.saucedemo.com/";
	public static final String USERNAME_XPATH="//*[@id=\"user-name\"]";
	public static final String PASS_XPATH="//*[@id=\"password\"]";
	public static final String BTN_XPATH="//*[@id=\"login-button\"]";
	public static final String INVENTORYURL="https://www.saucedemo.com/inventory.html";


	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\drajver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		WebElement sortiranje=driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select"));
		
		/*String url = "https://www.saucedemo.com/";
		driver.get(url);
		
		WebElement korisnicko= driver.findElement(By.xpath(USERNAME_XPATH));
		korisnicko.click();
		korisnicko.sendKeys("standard_user");
		
		
		WebElement loz= driver.findElement(By.xpath(PASS_XPATH));
		loz.click();
		loz.sendKeys("secret_sauce");
		
		WebElement dugme= driver.findElement(By.xpath(BTN_XPATH));
		dugme.click();*/

	}
	
	public static void inputUsername(WebDriver driver, String username) {
		
		driver.findElement(By.xpath(USERNAME_XPATH)).sendKeys(username);
		
	}

	public static void inputPassword(WebDriver driver, String password) {
	
		driver.findElement(By.xpath(PASS_XPATH)).sendKeys(password);
}
	
	public static void login(WebDriver driver){
		
		driver.findElement(By.xpath(BTN_XPATH)).click();
	}

	
}
