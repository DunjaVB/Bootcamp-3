package objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Inventory {
	public static final String INVENTORYURL="https://www.saucedemo.com/inventory.html";
	public static final String SORT_XPATH="//*[@id=\"inventory_filter_container\"]/select";
	
	private static WebDriver driver;
	
	public static void sortiraj(WebDriver driver) {
		
		
		WebElement sortiranje=driver.findElement(By.xpath(SORT_XPATH));
		sortiranje.click();
		//sortiranje.sendKeys("P");
		
		Select s= new Select(sortiranje);
		
		s.selectByVisibleText("Price (low to high)");
	}
	
	
	public static void sortiranje(WebDriver driver) {
		
		//driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select"));
		
		List<WebElement>cene = driver.findElements(By.className("inventory_item_price"));//hvatamo po klasi
		
		//Select se = new Select<WebElement>cene;

		  ArrayList originalList = new ArrayList();

		  for (WebElement e : ((Select) cene).getOptions()) {
		   originalList.add(e.getText());
		  }
		
	}

}
