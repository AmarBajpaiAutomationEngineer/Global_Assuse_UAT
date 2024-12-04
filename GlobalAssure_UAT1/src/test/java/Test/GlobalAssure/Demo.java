package Test.GlobalAssure;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GlobalAssure.pageobject.AssistanceDataEntry;
import GlobalAssure.pageobject.LandingPage;

public class Demo {

	@Parameters
	@Test(dataProvider = "DriveData", dataProviderClass = dataProvider.class)
	public void TestDemo(String companyName, String certiNum, String policyVerify, String prod, String companyMake,
			String companyModelVariant, String custName, String custMobileNum, String custState, String custCity,
			String custVehicleNum, String policyStartDate, String policyEndDate) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String loginId = "webuser@globalassure.com";
		String passCode = "webu@Pass123";
		String targetPlace = "India Gate, New Delhi";

		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		landingPage.loginWebApp(loginId, passCode);

		AssistanceDataEntry assistanceDataEntry = new AssistanceDataEntry(driver);
		assistanceDataEntry.dataEntry(companyName, certiNum, policyVerify, prod, companyMake, companyModelVariant,
				custName, custMobileNum, custState, custCity, custVehicleNum, policyStartDate, policyEndDate);

	}

//	
//		WebElement companyNameDropDown = driver.findElement(By.xpath("//select[@id='ddlCompanyName']"));
//		Select cp_Dropdown = new Select(companyNameDropDown);
//		cp_Dropdown.selectByVisibleText("GlobalAssure");
//		
//		driver.findElement(By.xpath("//input[@id='txtCertificateNo']")).sendKeys("Demo12345");
//
//		WebElement policyVerification = driver.findElement(By.xpath("//select[@id='ddlPolicyVerification']"));
//		Select pv_Dropdown = new Select(policyVerification);
//		pv_Dropdown.selectByVisibleText("Unverified");
//
//		WebElement product = driver.findElement(By.xpath("//select[@id='ddlProduct']"));
//		Select product_Dropdown = new Select(product);
//		product_Dropdown.selectByVisibleText("Private Car");
//
//		WebElement make = driver.findElement(By.xpath("//select[@id='ddlMake']"));
//		Select make_Dropdown = new Select(make);
//		make_Dropdown.selectByVisibleText("MARUTI SUZUKI");
//
//		WebElement model = driver.findElement(By.xpath("//select[@id='ddlModel']"));
//		Select model_Dropdown = new Select(model);
//		model_Dropdown.selectByVisibleText("ALTO -");
//
//		driver.findElement(By.xpath("//input[@id='txtCustomerFirstName']")).sendKeys("TEST");
//
//		driver.findElement(By.xpath("//input[@id='txtMobileNo']")).sendKeys("9264957853");
//
//		WebElement state = driver.findElement(By.xpath("//select[@id='ddlPermanentState']"));
//		Select state_Dropdown = new Select(state);
//		state_Dropdown.selectByVisibleText("DELHI");
//
//		WebElement city = driver.findElement(By.xpath("//select[@id='ddlPermanentCity']"));
//		Select city_Dropdown = new Select(city);
//		city_Dropdown.selectByVisibleText("EAST DELHI");
//
//		driver.findElement(By.xpath("//input[@id='txtRegistrationNo']")).sendKeys("NEWDL");
//
//		driver.findElement(By.xpath("//input[@id='txtStartDate']")).sendKeys("11/07/2024");
//
//		driver.findElement(By.xpath("//input[@id='txtEndDate']")).sendKeys("11/07/2025");
//
//		driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
//
//		String ticket = driver.findElement(By.xpath("(//div[@class='modal-body'])[1]")).getText();
//
//		System.out.println(ticket);
//
//		driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();
//
//		driver.findElement(By.xpath("(//input[@id='btnSearch'])[1]")).click();
//
//		driver.findElement(By.xpath("//a[normalize-space()='View']")).click();
//
//		driver.findElement(By.xpath("//input[@id='txtPinCode']")).sendKeys("110094");
//
//		driver.findElement(By.xpath("//textarea[@id='txtSummary']")).sendKeys("Test.............");
//
//		driver.findElement(By.xpath("(//input[@id='btnSaveAssist'])[1]")).click();
//
//		String name = driver.findElement(By.cssSelector("div[class='bootstrap-dialog-message'] strong")).getText();
//		System.out.println(name);
//
//		driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();
//
//		driver.findElement(By.xpath("(//a[normalize-space()='Assistance Details'])[1]")).click();
//		driver.findElement(By.xpath("(//input[@id='txtRefNo'])[1]")).sendKeys(name);
//		driver.findElement(By.xpath("(//input[@id='btnSearch'])[1]")).click();
//
//		driver.findElement(By.xpath("//a[normalize-space()='View/Edit']")).click();
//
//		Thread.sleep(20000);
//
//		driver.navigate().refresh();
//
//		WebElement incident = driver.findElement(By.xpath("(//select[@id='IncidentTypeId'])[1]"));
//		Select incident_Dropdown = new Select(incident);
//		incident_Dropdown.selectByVisibleText("Towing");
//
//		WebElement details = driver.findElement(By.xpath("//select[@id='ddlIncidentDetails']"));
//		Select details_Dropdown = new Select(details);
//		details_Dropdown.selectByVisibleText("Flatbed");
//
//		WebElement reasons = driver.findElement(By.xpath("(//select[@id='ddlIncidentReasons'])[1]"));
//		Select reasons_Dropdown = new Select(reasons);
//		reasons_Dropdown.selectByVisibleText("Accident");
//
//		WebElement location_type = driver.findElement(By.xpath("(//select[@id='ddlLocationType'])[1]"));
//		Select location_type_Dropdown = new Select(location_type);
//		location_type_Dropdown.selectByVisibleText("Home");
//
//		driver.findElement(By.xpath("//div[@class='col-md-4']//textarea[@id='txtSummary']")).sendKeys("Testing");
//
//		driver.findElement(By.xpath("(//input[@id='SaveBedoreVendorAssingAssistDetails'])[1]")).click();
//
//		driver.findElement(By.id("autocomplete2")).sendKeys(targetPlace);
//
//		Thread.sleep(3000);
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		List<WebElement> suggestions = (List<WebElement>) js
//				.executeScript("var xpath = \"(//div[@class='pac-container pac-logo hdpi'])[1]\";" + "var results = [];"
//						+ "var query = document.evaluate(xpath, document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);"
//						+ "for (var i = 0; i < query.snapshotLength; i++) {"
//						+ "    results.push(query.snapshotItem(i));" + "}" + "return results;");
//
//		for (WebElement suggestion : suggestions) {
//			String suggestionText = suggestion.getText();
//			if (suggestionText.contains((targetPlace))) {
//				suggestion.click();
//				Thread.sleep(2000);
//				break;
//			}
//		}
//
//		driver.findElement(By.xpath("(//input[@id='btnSearchDLKM'])[1]")).click();
//		driver.findElement(By.xpath("(//input[@id='btnSubmitDLKM'])[1]")).click();
//
//		driver.findElement(By.xpath("(//input[@id='SaveBedoreVendorAssingAssistDetails'])[1]")).click();
//
//		driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();
//
//		driver.findElement(By.xpath("//div[@class='col-md-4']//textarea[@id='txtSummary']")).sendKeys("Testing");
//
//		driver.findElement(By.xpath("(//input[@id='btnVendoGoogleMap'])[1]")).click();
//
//		// driver.close();
//
//		driver.findElement(By.xpath("(//select[@id='ddlState'])[1]")).sendKeys("DELHI");
//
//		driver.findElement(By.xpath("(//input[@id='txtVendorname'])[1]")).sendKeys("local");
//		Thread.sleep(10000);
//		driver.findElement(By.id("btnSearchAssist")).click();
//
//		Thread.sleep(5000);
//
////		WebElement input = driver.findElement(By.xpath("//input[@id='VendorForAssistModelList_0__IsChecked']//input"));
////		WebElement i = driver.findElement(By.xpath("//input[@type='checkbox']//i"));
////		boolean b = input.isSelected();
////		System.out.println(b);
////		if (!b) {
////			i.click();
////		}
////		System.out.println(
////				driver.findElement(By.xpath("(//input[@id='VendorForAssistModelList_0__IsChecked'])[1]//input"))
////						.isSelected());
//
//		driver.findElement(By.xpath("//input[@id='VendorForAssistModelList_2__IsChecked']")).click();
//
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("(//a[normalize-space()='Edit'])[1]")).click();
//
//		driver.findElement(By.xpath("(//input[@id='txtVendorMobileNo'])[1]")).sendKeys("9264957853");
//
//		WebElement element = driver.findElement(By.xpath("(//input[@id='IsSendSMS'])"));
//
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", element);
//
//		driver.findElement(By.xpath("(//input[@id='txtvdnETA'])[1]")).sendKeys("90");
//		driver.findElement(By.xpath("(//input[@id='txtCompleteInformationDateTime'])[1]")).sendKeys("18-07-2024");
//
//		driver.findElement(By.xpath("(//select[@id='ddlCompleteInformationTimeHours'])[1]")).sendKeys("16");
//		driver.findElement(By.xpath("(//select[@id='ddlCompleteInformationTimeMins'])[1]")).sendKeys("16");
//		driver.findElement(By.xpath("(//select[@id='ddlCompleteInformationTimeSecs'])[1]")).sendKeys("16");
//
//		driver.findElement(By.xpath("(//input[@id='btnSubmit'])[1]")).click();

}
