package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Home;



public class Testiranje {

public static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\drajver\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	
	public void testLogin() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		File f = new File("data.xlsx"); 
		try {
			InputStream inp = new FileInputStream(f); 
			XSSFWorkbook wb = new XSSFWorkbook(inp); 
			Sheet sheet = wb.getSheetAt(0); 
		
			
			SoftAssert sa= new SoftAssert();
			
			for(int i=0;i<2;i++) {
				Row row = sheet.getRow(i);
				
				Cell c1= row.getCell(0);
				Cell c2= row.getCell(1);
			
				
				String username = c1.toString();
				String pass = c2.toString();
				
				
				driver.navigate().to(Home.URL);
				Home.inputUsername(driver, username);
				Home.inputPassword(driver, pass);
				Home.login(driver);
				
			
			}
			sa.assertAll();
			
			wb.close();
			
	}catch (IOException e) {
		System.out.println("Nije pronadjen fajl!");
		e.printStackTrace();
}
		
		
	}
	
	@Test
	
	public void testSortiraj() {
		driver.navigate().to(Home.INVENTORYURL);
		SoftAssert sa= new SoftAssert();
		
		String actual=driver.getCurrentUrl();
		String expected="https://www.saucedemo.com/inventory.html";
		
		Assert.assertEquals(actual, expected);
		
		sa.assertAll();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.close();

}
	
	@Test
	
	public void testSortiranja() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(Home.INVENTORYURL);

		WebElement element = driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select"));
		Select se = new Select(element);
		List<String> originalList = new ArrayList();
		for (WebElement e : se.getOptions()) {
			originalList.add(e.getText());
		}
		
		List<String> tempList= originalList;
		Collections.sort(tempList);
		Assert.assertEquals(tempList, originalList);
		
	}


}
