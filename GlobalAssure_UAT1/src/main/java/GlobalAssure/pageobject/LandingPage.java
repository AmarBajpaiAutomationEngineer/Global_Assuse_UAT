package GlobalAssure.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='txtemail']")
	WebElement Email;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;

	@FindBy(xpath = "//input[@value='LOGIN']")
	WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),'Assistance Data Entry')]")
	WebElement DataEntry;

	public void loginWebApp(String email, String passcode) {

		Email.sendKeys(email);
		password.sendKeys(passcode);
		loginButton.click();
		DataEntry.click();
	}

	public void goTo() {

		driver.get("https://uatrsanew.globalassure.com/Account/Login");
	}

}
