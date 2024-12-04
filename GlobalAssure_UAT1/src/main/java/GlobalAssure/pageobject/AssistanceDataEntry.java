package GlobalAssure.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AssistanceDataEntry {

	WebDriver driver;

	public AssistanceDataEntry(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='ddlCompanyName']")
	WebElement companyNameDropDown;

	@FindBy(xpath = "//input[@id='txtCertificateNo']")
	WebElement certificateNo;

	@FindBy(xpath = "//select[@id='ddlPolicyVerification']")
	WebElement policyVerification;

	@FindBy(xpath = "//select[@id='ddlProduct']")
	WebElement product;

	@FindBy(xpath = "//select[@id='ddlMake']")
	WebElement make;

	@FindBy(xpath = "//select[@id='ddlModel']")
	WebElement modelVariant;

	@FindBy(xpath = "//input[@id='txtCustomerFirstName']")
	WebElement customerFirstName;

	@FindBy(xpath = "//input[@id='txtMobileNo']")
	WebElement mobileNo;

	@FindBy(xpath = "//select[@id='ddlPermanentState']")
	WebElement state;

	@FindBy(xpath = "//select[@id='ddlPermanentCity']")
	WebElement city;

	@FindBy(xpath = "//input[@id='txtRegistrationNo']")
	WebElement vehicleNo;

	@FindBy(xpath = "//input[@id='txtStartDate']")
	WebElement startDate;

	@FindBy(xpath = "//input[@id='txtEndDate']")
	WebElement endDate;

	@FindBy(xpath = "//input[@id='txtEmailId']")
	WebElement customerEmailID;

	@FindBy(xpath = "//input[@id='btnSubmit']")
	WebElement submitButton;

	public void dataEntry(String companyName, String certiNum, String policyVerify, String prod, String companyMake,
			String companyModelVariant, String custName, String custMobileNum, String custState, String custCity,
			String custVehicleNum, String policyStartDate, String policyEndDate) throws InterruptedException {

		Select cp_Dropdown = new Select(companyNameDropDown);
		cp_Dropdown.selectByVisibleText(companyName);

		certificateNo.sendKeys(certiNum);

		Select pv_Dropdown = new Select(policyVerification);
		pv_Dropdown.selectByVisibleText(policyVerify);

		Select product_Dropdown = new Select(product);
		product_Dropdown.selectByVisibleText(prod);

		Select make_Dropdown = new Select(make);
		make_Dropdown.selectByVisibleText(companyMake);

		Select model_Dropdown = new Select(modelVariant);
		model_Dropdown.selectByVisibleText(companyModelVariant);

		customerFirstName.sendKeys(custName);

		mobileNo.sendKeys(custMobileNum);

		Select state_Dropdown = new Select(state);
		state_Dropdown.selectByVisibleText(custState);

		Select city_Dropdown = new Select(city);
		city_Dropdown.selectByVisibleText(custCity);

		vehicleNo.sendKeys(custVehicleNum);

		startDate.sendKeys(policyStartDate);

		endDate.click();
		endDate.clear();
		endDate.sendKeys(policyEndDate);

		Thread.sleep(2000);

		submitButton.click();

	}
}
