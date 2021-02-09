package com.calculator.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseFunction {
public static WebDriver driver;
	
	public static String getProperty(String Key,String filePath) throws IOException{
		Properties p = new Properties();
		InputStream ips = new FileInputStream(filePath);
		return p.getProperty(Key);
	}

    public static void initialize() throws IOException {
    	String chDriver = getProperty("driver.path.chrome",".\\resource\\env.properties");
    	String chrome = getProperty("chrome.path",".\\resource\\env.properties");
    	System.setProperty("webdriver.chrome.driver", chDriver);
    	System.setProperty("webdriver.chrome.bin", chrome);
    }
	
	public static void openBrowser(String url){
		driver.get(url);
		driver.manage().window().maximize();
		//driver.switchTo().
	}
	
	public static void closeBrowser()
	{
		driver.close();	
	}
	
	public static void click(WebDriver driver,By by){
		driver.findElement(by).click();
	}
	
	public static void sendKey(By by,String value)
	{
		driver.findElement(by).sendKeys(value);
	}
	
	public static void elementClick(By by) 
    {
		driver.findElement(by).click();
    }
	
	 /*
     ***  Firstly locate to dropbox
     ***  Then locate to selection value
     ***  Select a value in a dropdown list
     */
	public void selectElement(By by,String text)
	{
		Select select = new Select(driver.findElement(by));
		select.selectByVisibleText(text);
	}
	
	 // Get element url
    public String getLinkUrl(By by)
    {
    	return driver.findElement(by).getAttribute("href");
    }
    
    //Check if element exists
    public boolean isElementExist(By by)
    {
    	try
    	{
    		Boolean bool = driver.findElement(by).isDisplayed();
    		return bool;
    	}
    	catch(NoSuchElementException e)
    	{
    		return false;
    	}
    }
    
    // obtain element text
    public String getWebText(By by) 
    {
    	try {
    		return driver.findElement(by).getText();
    		}
    	catch (NoSuchElementException e){
    		return "Text does not exist!";
    		}
    }
    
    //Find element by text then click the element
    public void clickElementContainingText(By by,String text)
    {
    	List<WebElement> elementList = driver.findElements(by);

    	for(WebElement e:elementList)
    	{
    		if(e.getText().contains(text))
            {
    			e.click();
           break;
            }
    	}
     }
    
    /*
     *** FInd element by text then obtain the element url
     */
     public String getLinkUrlContainingText(By by, String text)
     {
    	 List<WebElement> subscribeButton = driver.findElements(by);
    	 String url = null;

    	 for (WebElement e:subscribeButton) {
    		 if (e.getText().contains(text)) 
             {
    			 url = e.getAttribute("href");
    			 break;
             }
    	 }
    	 return url;
     }
     
    /*
     *** Some element belongs to iframe so we need to locate frame then search for this element.
     *
     *** This method is for text-type element
     */
     public void frameElementClick(By by,String text)
     {
    	 WebElement element = driver.switchTo().frame(text).findElement(by);
    	 element.click();
     }

    /*
     *** Some element belongs to iframe so we need to locate frame then search for this element.
     *** This method is for text-input element
     */
     public void frameElementSendKey(By by,String text)
     {
    	 WebElement element = driver.switchTo().frame(text).findElement(by);
    	 element.sendKeys(text);
     }  
     
     public WebElement element(By by) {
         WebElement ele=driver.findElement(by);
         return ele;
     }
     
     public ChromeDriver getDriver (){
         return (ChromeDriver) driver;
     }
     
     public static String GetCellData(By by,Integer row,Integer coloumn){
    	 
    	 WebElement table = driver.findElement(by); 
    	   
         //get all objects from the table  
          List<WebElement> rows = table.findElements(By.tagName("tr"));  
          WebElement theRow = rows.get(row);  
          //Get column object then get the text.  
          
          String text = getCell(theRow, coloumn).getText();  
          return text;  
     }
     
     private static WebElement getCell(WebElement Row,int coloumn){  
         List<WebElement> cells;  
         WebElement target = null;  
         //handle "<th>" and "<td>" separately  
         if(Row.findElements(By.tagName("th")).size()>0){  
            cells = Row.findElements(By.tagName("th"));  
            target = cells.get(coloumn);  
         }  
         if(Row.findElements(By.tagName("td")).size()>0){  
            cells = Row.findElements(By.tagName("td"));  
            target = cells.get(coloumn);  
         }  
        return target;  
           
    } 
}
