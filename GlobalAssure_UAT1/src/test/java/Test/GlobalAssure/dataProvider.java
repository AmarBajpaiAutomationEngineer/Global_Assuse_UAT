package Test.GlobalAssure;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

	DataFormatter formatter = new DataFormatter();

//	@Test(dataProvider = "DriveData")
//	public void testCaseData(String companyName, String certiNum, String policyVerify, String prod, String companyMake,
//			String companyModelVariant, String custName, String custMobileNum, String custState, String custCity,
//			String custVehicleNum, String policyStartDate, String policyEndDate) {
//		System.out.println("companyName - " + companyName + "\n" + "certiNum - " + certiNum + "\n" + "policyVerify - "
//				+ policyVerify + "\n" + "Product - " + prod + "\n" + "companyMake - " + companyMake + "\n"
//				+ "companyModelVariant - " + companyModelVariant + "\n" + "Customer Name - " + custName + "\n"
//				+ "Customer Mobile Number - " + custMobileNum + "\n" + "custState - " + custState + "\n" + "custCity - "
//				+ custCity + "\n" + "custVehicleNum - " + custVehicleNum + "\n" + "policyStartDate - " + policyStartDate
//				+ "\n" + "policyEndDate - " + policyEndDate);
//	}

	@DataProvider(name = "DriveData")
	public Object[][] getData() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Amar\\eclipse-workspace\\GlobalAssure_UAT1\\src\\test\\resources\\TestData\\GlobalAssureTestData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int physicalNumberOfRowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		Object data[][] = new Object[physicalNumberOfRowCount - 1][columnCount];
		for (int i = 0; i < physicalNumberOfRowCount - 1; i++) {

			XSSFRow row2 = sheet.getRow(i + 1);
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row2.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}

		return data;

	}

}
