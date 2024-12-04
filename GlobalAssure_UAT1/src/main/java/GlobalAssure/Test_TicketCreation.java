package GlobalAssure;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_TicketCreation {

	WebDriver driver;
	String excelFilePath = "C:\\Users\\Amar\\eclipse-workspace\\GlobalAssure_UAT_TEST\\datafiles\\TATAAIG.xlsx"; // Excel
																													// file
																													// path
																													// updated

	@BeforeClass
	public void setup() {
		// Automatically detects the correct EdgeDriver version based on installed Edge
		// browser version
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void testGlobalAssureAutomation() throws InterruptedException, IOException {
		// Step 1: Login
		loginToApplication();

		// Step 2: Navigate to Data Entry page
		driver.findElement(By.xpath("//a[normalize-space()='Assistance Data Entry']")).click();

		// Step 3: Read and process the Excel data
		try (FileInputStream fis = new FileInputStream(excelFilePath); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate over rows starting from row 2 (index 1), assuming row 1 is the header
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					// Null checks and filling in the fields
					fillForm(row);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loginToApplication() {
		String url = "https://uatrsanew.globalassure.com/Account/Login";
		String loginId = "webuser@globalassure.com";
		String passCode = "Qwerty@123456";

		driver.get(url);
		driver.findElement(By.xpath("//input[@id='txtemail']")).sendKeys(loginId);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(passCode);
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	}

	public void fillForm(Row row) {
		// Example of filling in the form based on Excel data
		// Each cell in the row corresponds to a value from the Excel sheet

		String companyName = getCellValue(row.getCell(0));
		if (companyName != null) {
			WebElement companyNameDropDown = driver.findElement(By.xpath("//select[@id='ddlCompanyName']"));
			Select cp_Dropdown = new Select(companyNameDropDown);
			cp_Dropdown.selectByVisibleText(companyName);
		}

		String certificateNo = getCellValue(row.getCell(1));
		if (certificateNo != null) {
			driver.findElement(By.xpath("//input[@id='txtCertificateNo']")).sendKeys(certificateNo);
		}

		String policyVerification = getCellValue(row.getCell(2));
		if (policyVerification != null) {
			WebElement policyVerificationDropDown = driver
					.findElement(By.xpath("//select[@id='ddlPolicyVerification']"));
			Select pv_Dropdown = new Select(policyVerificationDropDown);
			pv_Dropdown.selectByVisibleText(policyVerification);
		}

		String product = getCellValue(row.getCell(3));
		if (product != null) {
			WebElement productDropDown = driver.findElement(By.xpath("//select[@id='ddlProduct']"));
			Select product_Dropdown = new Select(productDropDown);
			product_Dropdown.selectByVisibleText(product);
		}

		String make = getCellValue(row.getCell(4));
		if (make != null) {
			WebElement makeDropDown = driver.findElement(By.xpath("//select[@id='ddlMake']"));
			Select make_Dropdown = new Select(makeDropDown);
			make_Dropdown.selectByVisibleText(make);
		}

		String model = getCellValue(row.getCell(5));
		if (model != null) {
			WebElement modelDropDown = driver.findElement(By.xpath("//select[@id='ddlModel']"));
			Select model_Dropdown = new Select(modelDropDown);
			model_Dropdown.selectByVisibleText(model);
		}

		String firstName = getCellValue(row.getCell(6));
		if (firstName != null) {
			driver.findElement(By.xpath("//input[@id='txtCustomerFirstName']")).sendKeys(firstName);
		}

		String mobileNo = getCellValue(row.getCell(7));
		if (mobileNo != null) {
			driver.findElement(By.xpath("//input[@id='txtMobileNo']")).sendKeys(mobileNo);
		}

		String state = getCellValue(row.getCell(8));
		if (state != null) {
			WebElement stateDropDown = driver.findElement(By.xpath("//select[@id='ddlPermanentState']"));
			Select state_Dropdown = new Select(stateDropDown);
			state_Dropdown.selectByVisibleText(state);
		}

		String city = getCellValue(row.getCell(9));
		if (city != null) {
			WebElement cityDropDown = driver.findElement(By.xpath("//select[@id='ddlPermanentCity']"));
			Select city_Dropdown = new Select(cityDropDown);
			city_Dropdown.selectByVisibleText(city);
		}

		String vehicleNo = getCellValue(row.getCell(10));
		if (vehicleNo != null) {
			driver.findElement(By.xpath("//input[@id='txtRegistrationNo']")).sendKeys(vehicleNo);
		}

		String startDate = getCellDateValue(row.getCell(11));
		if (startDate != null) {
			driver.findElement(By.xpath("//input[@id='txtStartDate']")).sendKeys(startDate);
		}

		String endDate = getCellDateValue(row.getCell(12));
		if (endDate != null) {
			driver.findElement(By.xpath("//input[@id='txtEndDate']")).sendKeys(endDate);
		}

//	        String pincode = getCellValue(row.getCell(13));
//	        if (pincode != null) {
//				driver.findElement(By.xpath("//input[@id='txtPinCode']")).sendKeys(pincode);
//			}

		driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
		String text = driver.findElement(By.xpath("//div[@class='bootstrap-dialog-message']//strong")).getText();

		System.out.println(text);

//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
//	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//
		//
//	      String text1= alert.getText();
		//
		//
//	      alert.accept();

		driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();

		driver.findElement(By.xpath("(//input[@id='btnSearch'])[1]")).click();

		driver.findElement(By.xpath("//a[normalize-space()='View']")).click();

	}

//	    public void clickSubmitButton() {
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//
//	        // Wait for the modal or overlay to disappear if present
//	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal")));
	//
//	        // Wait for submit button to be clickable
//	        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='btnSubmit'])[1]")));
//	       
//	        // Check if the submit button is visible in the viewport
//	        if (!isElementInViewport(submitButton)) {
//	            // Scroll the submit button into view if it's not visible
//	            JavascriptExecutor js = (JavascriptExecutor) driver;
//	            js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
//	        }
	//
//	        // Use JavaScript to click the submit button
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//	        js.executeScript("arguments[0].click();", submitButton);
	//
//	        // Capture the ticket number
	// // waitForModal();
//	    }

	// Wait for the modal to appear and capture the ticket number
//	    public void waitForModal() {
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='bootstrap-dialog-message']//strong")));
//	        String ticket = modal.getText();
//	        System.out.println("Ticket: " + ticket);
//	    }

	// div[@class='bootstrap-dialog-message']//strong

	// Helper method to check if an element is in the viewport
//	    public boolean isElementInViewport(WebElement element) {
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//	        return (Boolean) js.executeScript(
//	            "var rect = arguments[0].getBoundingClientRect();" +
//	            "return (" +
//	            "rect.top >= 0 && rect.left >= 0 && " +
//	            "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && " +
//	            "rect.right <= (window.innerWidth || document.documentElement.clientWidth)" +
//	            ");", element);
//	    }

	public String getCellValue(Cell cell) {
		if (cell == null) {
			return null;
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue().trim();
		case NUMERIC:

			return String.valueOf((int) cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		default:
			return null;
		}
	}

	public String getCellDateValue(Cell cell) {
		if (cell == null || !DateUtil.isCellDateFormatted(cell)) {
			return null;
		}
		Date date = cell.getDateCellValue();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.format(date);
	}
}
