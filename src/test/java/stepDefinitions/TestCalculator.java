package stepDefinitions;

import static org.testng.AssertJUnit.assertTrue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.calculator.basic.ConfigFileReader;
import com.calculator.objects.calculatorPage;

import com.calculator.basic.Log;
import org.apache.log4j.xml.DOMConfigurator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class TestCalculator {
	WebDriver webdriver = new ChromeDriver();
	ConfigFileReader configFileReader;
	SoftAssert softAssert = new SoftAssert();
	
	@Given("^calculate page loads properly$")
	public void calculate_page_loads_properly() throws Throwable {
	    // Obtain information from configuration file.
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("calculate page loads properly");
		configFileReader = new ConfigFileReader();
		String AppUrl = configFileReader.getAppUrl();
		long iWait = configFileReader.getImplicitlyWait();
		
		// Open browser then check the browser title.
		webdriver.get(AppUrl);
		webdriver.manage().window().maximize();// maximum the window
		webdriver.manage().timeouts().implicitlyWait(iWait, TimeUnit.SECONDS);
		
		Log.info("AppUrl is "+ AppUrl);
		Log.info("ImplicitlyWait is set to " + iWait);
		
		String expectPageTitle = "Home loan borrowing power calculator";
		String actualPageTitle = webdriver.getTitle();
		
		softAssert.assertTrue(actualPageTitle.contains(expectPageTitle));
		
	    //throw new PendingException();
	}

	@When("^Select Single and select (\\d+) and select Home to live in$")
	public void select_Single_and_select_and_select_Home_to_live_in(String arg1) throws Throwable {
	    // Select application type and select home to live in
		Log.startTestCase("Select Single and select Home to live in");
		if (arg1 =="Single") {
			calculatorPage.applicationTypeSingleButton(webdriver).click();
		}
		calculatorPage.numberOfdependantsDropDown(webdriver).selectByVisibleText(arg1);
		calculatorPage.propertyTypeHomeButton(webdriver).click();
		
		Log.info("Select application type - Done. The application type is Single");
		Log.info("Select numberOfdependants - Done. The numberOfdependants is "+ arg1);
		Log.info("Select home to live in - Done.");
	    //throw new PendingException();
	}

	@When("^input (\\d+) and input (\\d+)$")
	public void input_and_input(int arg1, int arg2) throws Throwable {
	    // Input yourIncome and yourOtherIncome
		Log.startTestCase("input yourIncome and yourOtherIncome");
		calculatorPage.yourIncomeTextbox(webdriver).sendKeys(String.valueOf(arg1));
		calculatorPage.yourOtherIncomeTextbox(webdriver).sendKeys(String.valueOf(arg2));
		
		Log.info("Input yourIncome and yourOtherIncome - Done.");
		Log.info("YourIncome is set to $"+ arg1);
		Log.info("YourOtherIncome is set to $"+ arg2);
		//throw new PendingException();
	}

	@When("^input (\\d+) and input (\\d+) and input (\\d+)$")
	public void input_and_input_and_input(int arg1, int arg2, int arg3) throws Throwable {
	    // Input livingExpense,homeLoanRepayments and otherLoanRepayments
		Log.startTestCase("input livingExpense and input homeLoanRepayments and input otherLoanRepayments");
		calculatorPage.livingExpenseTextbox(webdriver).sendKeys(String.valueOf(arg1));
		calculatorPage.homeLoanRepaymentsTextbox(webdriver).sendKeys(String.valueOf(arg2));
		calculatorPage.otherLoanRepaymentsTextbox(webdriver).sendKeys(String.valueOf(arg3));
		
		Log.info("Input livingExpense,homeLoanRepayments and otherLoanRepayments - Done.");
		Log.info("livingExpense is set to $" + arg1);
		Log.info("homeLoanRepayments is set to $" + arg2);
		Log.info("otherLoanRepayments is set to $" + arg3);
		
	    //throw new PendingException();
	}
	
	@When("^input OtherCommitments(\\d+)$")
	public void input_OtherCommitments(int arg1) throws Throwable {
	    // Input OtherCommitments
		Log.startTestCase("input_OtherCommitments");
		calculatorPage.otherCommitmentTextbox(webdriver).sendKeys(String.valueOf(arg1));
		
		Log.info("Input OtherCommitments - Done.");
		Log.info("OtherCommitments is set to $" + arg1);
	    //throw new PendingException();
	}

	@When("^input TotalCreditCardLimits(\\d+)$")
	public void input_TotalCreditCardLimits(int arg1) throws Throwable {
	    // Input TotalCreditCardLimits
		Log.startTestCase("input_TotalCreditCardLimits");
		calculatorPage.totalCreditCardLimitsTextbox(webdriver).sendKeys(String.valueOf(arg1));
		
		Log.info("Input TotalCreditCardLimits - Done.");
		Log.info("TotalCreditCardLimits is set to $" + arg1);
	    //throw new PendingException();
	}
	
	@When("^press WorkOut button$")
	public void press_WorkOut_button() throws Throwable {
	    // click WorkOut button to calculate the borrow power
		Log.startTestCase("press_WorkOut_button");
		calculatorPage.workOutButton(webdriver).click();
		Log.info("Click WorkOut button.");
		Thread.sleep(5000);
	    //throw new PendingException();
	}
	
	@Then("^(\\d+) should display$")
	public void should_display(int arg1) throws Throwable {
	    // The borrow power should display
		Log.startTestCase("BorrowResult should_display");
		String expectBorrowResult= "$" + Long.toString(arg1); 
		String actualBorrowResult= calculatorPage.estimateResult(webdriver).getText();
			   actualBorrowResult = actualBorrowResult.replace(",", "");
		softAssert.assertEquals(expectBorrowResult, actualBorrowResult);
		
		Log.info("expectBorrowResult is "+ expectBorrowResult);
		Log.info("actualBorrowResult is "+ actualBorrowResult);
		Log.info("Compare expectBorrowResult and actualBorrowResult - Done.");
		
	    //throw new PendingException();
	}
	

	@Then("^StartOver button avaliable$")
	public void startover_button_avaliable() throws Throwable {
	    // Check StartOver button's availability
		Log.startTestCase("startover_button_avaliable");
		Boolean startoverButtonDisplay = calculatorPage.startOverButton(webdriver).isDisplayed();
		assertTrue(startoverButtonDisplay==true);
		
		Log.info("Check StartOver button's availability. - Done");
		Log.info("Startover Button's availability is "+ startoverButtonDisplay);
		//System.out.println("Startover Button displayed is :"+ startoverButtonDisplay);
	    //throw new PendingException();
	}

	@Then("^WorkOut button invisible$")
	public void workout_button_invisible() throws Throwable {
	    // Check WorkOut button's availability
		Log.startTestCase("workout_button_invisible");
		Boolean workoutButtonDisplay = calculatorPage.workOutButton(webdriver).isDisplayed();
		assertTrue(workoutButtonDisplay==false);
		
		Log.info("Check WorkOut button's availability. - Done");
		Log.info("WorkOut Button's availability is "+ workoutButtonDisplay);
		//System.out.println("Workout Button displayed is :"+ workoutButtonDisplay);
	    //throw new PendingException();
	}

	@When("^I click StartOver button$")
	public void i_click_StartOver_button() throws Throwable {
	    // Click StartOver button to clear all fields
		Log.startTestCase("i_click_StartOver_button");
		calculatorPage.startOverButton(webdriver).click();
		Log.info("Click StartOver button to clear all fields. - Done");
		Thread.sleep(5000);
	    //throw new PendingException();
	}

	@Then("^all fields cleared$")
	public void all_fields_cleared() throws Throwable {
	    // Check if all fields are cleared
		Log.startTestCase("all_fields_cleared");
		String defaultValue="";
		String currentValue;
		String currentSelection;
		
		Boolean SingleSelected = calculatorPage.applicationTypeSingleButton(webdriver).isSelected();
		softAssert.assertTrue(SingleSelected==false);
		Log.info("ApplicationTypeSingleButton's selection is "+ SingleSelected);
		
		WebElement o = calculatorPage.numberOfdependantsDropDown(webdriver).getFirstSelectedOption();
		currentSelection = o.getText();
		softAssert.assertEquals(currentSelection, "0");
		Log.info("NumberOfdependantsDropDown's selection is "+ currentSelection);
		
		Boolean HomeToLiveSelected = calculatorPage.propertyTypeHomeButton(webdriver).isSelected();
		softAssert.assertTrue(HomeToLiveSelected==false);
		Log.info("PropertyTypeHomeButton's selection is "+ HomeToLiveSelected);
		
		currentValue = calculatorPage.yourIncomeTextbox(webdriver).getText();
		softAssert.assertEquals(defaultValue, currentValue);
		Log.info("YourIncome's current value is "+ currentValue);
		
		currentValue = calculatorPage.yourOtherIncomeTextbox(webdriver).getText();
		softAssert.assertEquals(defaultValue, currentValue);
		Log.info("YourOtherIncome's current value is "+ currentValue);
		
		currentValue = calculatorPage.livingExpenseTextbox(webdriver).getText();
		softAssert.assertEquals(defaultValue, currentValue);
		Log.info("livingExpense's current value is "+ currentValue);
		
		currentValue = calculatorPage.homeLoanRepaymentsTextbox(webdriver).getText();
		softAssert.assertEquals(defaultValue, currentValue);
		Log.info("homeLoanRepayments' current value is "+ currentValue);
		
		currentValue = calculatorPage.otherLoanRepaymentsTextbox(webdriver).getText();
		softAssert.assertEquals(defaultValue, currentValue);
		Log.info("otherLoanRepayments' current value is "+ currentValue);
		
		currentValue = calculatorPage.otherCommitmentTextbox(webdriver).getText();
		softAssert.assertEquals(defaultValue, currentValue);
		Log.info("otherCommitment's current value is "+ currentValue);
		
		currentValue = calculatorPage.totalCreditCardLimitsTextbox(webdriver).getText();
		softAssert.assertEquals(defaultValue, currentValue);
		Log.info("totalCreditCardLimits' current value is "+ currentValue);
		
	    //throw new PendingException();
	}

	@Then("^Workout button is avaliable$")
	public void workout_button_is_avaliable() throws Throwable {
	    // Check if WorkOut button is available after clicked StartOver button
		Log.startTestCase("workout_button_is_avaliable");
		Boolean workoutButtonDisplay = calculatorPage.workOutButton(webdriver).isDisplayed();
		softAssert.assertTrue(workoutButtonDisplay==true);
		System.out.println("Workout Button displayed is :"+ workoutButtonDisplay);
		Log.info("Check if WorkOut button is available after clicked StartOver button.- Done");
		Log.info("The WorkOut button's availability is "+ workoutButtonDisplay);
	    //throw new PendingException();
	}

	@Then("^StartOver button invisible$")
	public void startover_button_invisible() throws Throwable {
	    // Check if StartOver button is NOT available after clicked StartOver button
		Log.startTestCase("startover_button_invisible");
		Boolean startoverButtonDisplay = calculatorPage.startOverButton(webdriver).isDisplayed();
		softAssert.assertTrue(startoverButtonDisplay==false);
		System.out.println("Startover Button displayed is :"+ startoverButtonDisplay);
		
		Log.info("Check if StartOver button is available after clicked StartOver button.- Done");
		Log.info("The StartOver button's availability is "+ startoverButtonDisplay);		
		softAssert.assertAll();
		webdriver.close();
	    //throw new PendingException();
	}	
	
	
}
