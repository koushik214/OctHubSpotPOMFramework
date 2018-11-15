package com.qa.POIAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreeCrmLoginDataDriven {

	public static void main(String[] args) {

		Xls_Reader reader = new Xls_Reader("D:\\javaautomation\\FrameworkPOM\\src\\main\\java\\com\\qa\\POIAPI\\FreeCrmTestData.xlsx");
		
//		String username = reader.getCellData("login", "username", 2);
//		System.out.println(username);
		
//		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get("https://www.freecrm.com/index.html");
		
		//reader.addColumn("login", "status");
		
		System.out.println(reader.getRowCount("login"));
		System.out.println(reader.getColumnCount("login"));
		
		//reader.addSheet("register");
		System.out.println(reader.isSheetExist("login"));
		
//		for(int rowNum=2; rowNum<=reader.getRowCount("login"); rowNum++){
//			String username = reader.getCellData("login", "username", rowNum);
//			String password = reader.getCellData("login", "password", rowNum);
//			System.out.println(username + " " + password);
//			
//			driver.findElement(By.name("username")).clear();
//			driver.findElement(By.name("username")).sendKeys(username);
//			
//			driver.findElement(By.name("password")).clear();
//			driver.findElement(By.name("password")).sendKeys(password);
//			
//			reader.setCellData("login", "status", rowNum, "PASS");
//			
//
//		}
		
		
		
	}

}
