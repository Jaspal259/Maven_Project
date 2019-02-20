package KDD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class resusableFuction {
	
	WebDriver driver;
	
	public String[][] fetchDataFromExcel() 
	{
		try
		{
		Workbook wb = null;
		String[][] data = null;
		
		String path = "C:\\Users\\welcome\\Desktop\\Test workspace\\Keyword_Driven\\src\\test.xls";
		File excel = new File(path);
		FileInputStream file = new FileInputStream(excel);
		
		System.out.println(path);
		String extn = path.substring(path.indexOf(".")+1);
		
		System.out.println(extn);
		
	//	if(extn.equals("xlsx"))
		//{
			//wb = new XSSFWorkbook(file);
		//} else
		//{
			wb = new HSSFWorkbook(file);
		
	//}
		Sheet sheet = wb.getSheet("Sheet1");
		int rownum = sheet.getLastRowNum();
		int column = sheet.getRow(0).getLastCellNum();
		
		data = new String[rownum][column];
		
		
		for(int i = 0 ; i < rownum; i++)
		{
			Row row = sheet.getRow(i);
			for(int j=0 ; j < column ; j++)
			{
				Cell cell = row.getCell(j);
				String value = cell.toString();
				data[i][j] = value;
			}
		}
		}catch (Exception e)
		{
			e.printStackTrace();
		} finally{
			try{
				
			}catch (IOException e)
			{
				e.printStackTrace();
			}
		
		
		}
		return data;

	}
	
	public static String fetchprop(String text)
	{
		Properties prop = new Properties();
		FileInputStream input;
		try{
			input = new FileInputStream("C:\\Users\\welcome\\Desktop\\Test workspace\\Keyword_Driven\\src\\object.properties");
			prop.load(input);
			
		}catch (Exception e)
		{
			
		}
		return prop.getProperty(text);
	}
	
	public void launchAppl()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\welcome\\Desktop\\Cucu\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(fetchprop("URL"));
	}
	
	public void filltext(String LocatorBy,String LocatorValue,String text)
	{
		switch (LocatorBy) {
		case "xpath":
			driver.findElement(By.name(LocatorValue)).sendKeys(text);
			break;
		case "name":
			driver.findElement(By.name(LocatorValue)).sendKeys(text);
			break;
					
		default:
			break;
		}
		

	}
	public void click(String LocatorBy, String LocatorValue)
	{
		switch (LocatorBy) {
		case "xpath":
			driver.findElement(By.name(LocatorValue)).click();
			break;
		case "name":
			driver.findElement(By.name(LocatorValue)).click();
			break;
					
		default:
			break;
	}
	}
	
	public void driverClose()
	{
		driver.close();
	}
	

}
