package com.calculator.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.calculator.basic.BaseFunction;

public class calculatorPage extends BaseFunction {
	public static WebDriver driver;
	private static WebElement element;
	
	public static WebElement bankLogo(WebDriver driver){
		element = driver.findElement(By.xpath("//header/div[1]/a[2]/img[1]"));
		return element;
	}
	
	public static WebElement mainQuestionLabel(WebDriver driver){
		element = driver.findElement(By.xpath("//span[contains(text(),'How much could I borrow?')]"));
		return element;
	}
	
	public static WebElement applicationTypeSingleButton(WebDriver driver){
		element = driver.findElement(By.xpath("//label[contains(.,'Single')]"));
		return element;
	}
	
	public static WebElement applicationTypeJointButton(WebDriver driver){
		element = driver.findElement(By.xpath("//label[contains(.,'Joint')]"));
		return element;
	}
	
	public static Select numberOfdependantsDropDown(WebDriver driver){
		Select element = new Select(driver.findElement(By.cssSelector("select")));
		return element;
	}
	
	public static WebElement propertyTypeHomeButton(WebDriver driver){
		element = driver.findElement(By.xpath("//label[contains(.,'Home to live in')]"));
		return element;
	}
	
	public static WebElement propertyTypeInvestmentButton(WebDriver driver){
		element = driver.findElement(By.xpath("//label[contains(.,'Residential investment')]"));
		return element;
	}
	
	public static WebElement yourIncomeTextbox(WebDriver driver){
		element = driver.findElement(By.xpath("//div[2]/div/div/div/input"));
		return element;
	}
	
	public static WebElement yourOtherIncomeTextbox(WebDriver driver){
		element = driver.findElement(By.xpath("//div[2]/div/div[2]/div/input"));
		return element;
	}
	
	public static WebElement livingExpenseTextbox(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@id='expenses']"));
		return element;
	}
	
	public static WebElement homeLoanRepaymentsTextbox(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@id='homeloans']"));
		return element;
	}
	
	public static WebElement otherLoanRepaymentsTextbox(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@id='otherloans']"));
		return element;
	}
	
	public static WebElement otherCommitmentTextbox(WebDriver driver){
		element = driver.findElement(By.xpath("//div[3]/div/div[4]/div/input"));
		return element;
	}
	
	public static WebElement totalCreditCardLimitsTextbox(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@id='credit']"));
		return element;
	}
	
	public static WebElement workOutButton(WebDriver driver){
		element = driver.findElement(By.id("btnBorrowCalculater"));
		return element;
	}
	
	public static WebElement estimateResult(WebDriver driver){
		element = driver.findElement(By.id("borrowResultTextAmount"));
		return element;
	}
	
	public static WebElement startOverButton(WebDriver driver){
		element = driver.findElement(By.className("start-over"));
		return element;
	}
}
