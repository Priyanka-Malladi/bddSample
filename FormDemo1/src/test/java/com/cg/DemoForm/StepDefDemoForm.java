package com.cg.DemoForm;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefDemoForm {
	static PageFactDemoForm pageFact=null; 
	static WebDriver driver=null;
	
	@Before
	public static void createDriver() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\primalla\\Desktop\\jar-files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\primalla\\Desktop\\demoform.html");
		pageFact = new PageFactDemoForm(driver);
	}
	
	@When("^user gives valid data$")
	public void user_gives_valid_data() throws Throwable {
		pageFact.setName("John Michael"); 
		Thread.sleep(1000);
		pageFact.setMobile("9949891234");
		Thread.sleep(1000);
		pageFact.setGender1();
		Thread.sleep(1000);
		pageFact.setEmail("johnmichael23@gmail.com");
		Thread.sleep(1000);
		pageFact.setAddress("NewYork City");
		Thread.sleep(1000);
		pageFact.setButton();
		Thread.sleep(1000);
	}

	@Then("^Display success message$")
	public void display_success_message() throws Throwable {
	    driver.switchTo().alert().accept();
	    System.out.println("SUCCESSFUL..!!");
	}

	@When("^name is empty$")
	public void name_is_empty() throws Throwable {
	 pageFact.setName("");
	 Thread.sleep(1000);
	}

	@When("^click submit$")
	public void click_submit() throws Throwable {
	  pageFact.setButton();
	}

	@Then("^prompt error message$")
	public void prompt_error_message() throws Throwable {
		Thread.sleep(1000);
	   driver.switchTo().alert().accept();
	   System.out.println("enter valid details..!!");
	}

	@When("^gender not selected$")
	public void gender_not_selected() throws Throwable {
	    pageFact.setName("johnmichael");
	    Thread.sleep(1000);
	    pageFact.setMobile("9988774455");
	    Thread.sleep(1000);
	    pageFact.setAddress("NYC");
	    Thread.sleep(1000);
	    pageFact.setEmail("johndasdf@gmail.com");
	    Thread.sleep(1000);
	    pageFact.setButton();
	    Thread.sleep(1000);
	    
	}

	@When("^address is empty$")
	public void address_is_empty() throws Throwable {
		  pageFact.setName("johnmichael");
		    Thread.sleep(1000);
		    pageFact.setMobile("9988774455");
		    Thread.sleep(1000);
		    pageFact.setEmail("johndasdf@gmail.com");
		    Thread.sleep(1000);
		    pageFact.setGender1();
			Thread.sleep(1000);
			pageFact.setButton();
	}

	@When("^mobile number is invalid$")
	public void mobile_number_is_invalid(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		pageFact.setName("johnmichael");
	    Thread.sleep(1000);
	    pageFact.setEmail("johndasdf@gmail.com");
	    Thread.sleep(1000);
	    pageFact.setGender1();
		Thread.sleep(1000);
		pageFact.setAddress("NewYork City");
		Thread.sleep(1000);
		List<String> mobNumbers = arg1.asList(String.class);
	    String data=null;
	   for (String mobile : mobNumbers) {
		data=mobile;
		if(data.matches("^[7-9]{1}[0-9]{9}$")) {
			System.out.println("Matched..!!");		
			}
		else {
			System.out.println("Not Matched..!!");
		}
		pageFact.getMobile().clear();
		pageFact.setMobile(data);
		Thread.sleep(1000);
		pageFact.setButton();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
	   }
}
	@Then("^prompt error message for mobile$")
	public void prompt_error_message_for_mobile() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	

	@When("^user enters invalid email id$")
	public void user_enters_invalid_email_id(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		pageFact.setName("johnmichael");
	    Thread.sleep(1000);
	    pageFact.setMobile("9988774455");
	    Thread.sleep(1000);
	    pageFact.setGender1();
		Thread.sleep(1000);
		pageFact.setAddress("NewYork City");
		Thread.sleep(1000);
		List<String> emailList = arg1.asList(String.class);
		String data = null;
		for (String email : emailList) {
			data = email;
			pageFact.getEmail().clear();
			pageFact.setEmail(data);
			Thread.sleep(1000);	
			pageFact.setButton();
			Thread.sleep(1000);
			driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
		}
	}
	
	@Then("^prompt error message for email$")
	public void prompt_error_message_for_email() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}
	
	@After
	public static void closeAll() {
		driver.close();
		
	}
}
