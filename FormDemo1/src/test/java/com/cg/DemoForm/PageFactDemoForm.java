package com.cg.DemoForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class PageFactDemoForm {
	WebDriver driver;
	
	public PageFactDemoForm() {
		
	}
	public PageFactDemoForm(WebDriver wb) {
		this.driver = wb;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="txtFN")
	@CacheLookup
	WebElement name;
	
	@FindBy(name="Phone")
	@CacheLookup
	WebElement mobile;
	
	@FindBy(name="Email")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"male\"]")
	@CacheLookup
	WebElement gender1;
	
	@FindBy(xpath="//*[@id=\"female\"]")
	@CacheLookup
	WebElement gender2;
	
	@FindBy(id="address")
	@CacheLookup
	WebElement address;
	
	@FindBy(id="btn")
	WebElement button;
	
	public WebElement getName() {
		return name;
	}
	public void setName(String fname) {
		name.sendKeys(fname);
	}
	public WebElement getMobile() {
		return mobile;
	}
	public void setMobile(String mobileNum) {
		mobile.sendKeys(mobileNum);
	}
	public WebElement getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void setGender1() {
		this.gender1.click();
	}
	
	public void setGender2() {
		this.gender2.click();
	}
	public WebElement getAddress() {
		return address;
	}
	public void setAddress(String address1) {
		this.address.sendKeys(address1);
	}
	public WebElement getButton() {
		return button;
	}
	public void setButton() {
		button.click();
	}
	
	
}
