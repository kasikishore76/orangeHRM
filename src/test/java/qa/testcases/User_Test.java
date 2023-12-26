package qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qa.base.BaseTest;

import qa.pages.User_Page;

public class User_Test extends BaseTest {
	private static final Logger logger = LogManager.getLogger(Login_Test.class);
	User_Page up;

	@BeforeClass
	public void createPageObject() {
		up = new User_Page(getDriver());
		System.out.println(getDriver());
	}

	@Test
	public void openUserPage() {
		up.openUserPage();
		assertTrue(up.assertPage());
	}

	@Test(dependsOnMethods = { "openUserPage" })
	public void addUserDetails() throws InterruptedException {

		File excelfile = new File(
				"C:\\Users\\kasik\\Documents\\GitHub\\orangeHRM\\src\\main\\resources\\files\\logins.xlsx");
//		if(excelfile.exists()}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheet("UserDetails");
		String username = sheet.getRow(0).getCell(1).getStringCellValue();
		String pwd = sheet.getRow(1).getCell(1).getStringCellValue();
		String empname = sheet.getRow(2).getCell(1).getStringCellValue();
		String status = sheet.getRow(3).getCell(1).getStringCellValue();
		String role = sheet.getRow(4).getCell(1).getStringCellValue();
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		up.openUserDetailspage();
		up.selectUserrole(role);
		up.selectStatus(status);
		up.enterEmployeeName(empname);
		up.enterUserName(username);
		up.enterPassword(pwd);
		up.enterCnfPassword(pwd);
		up.clickSave();
	}
	@Test(dependsOnMethods = { "addUserDetails" })
	public void validateUser() {
		File excelfile = new File(
				"C:\\Users\\kasik\\Documents\\GitHub\\orangeHRM\\src\\main\\resources\\files\\logins.xlsx");
//		if(excelfile.exists()}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheet("UserDetails");
		String username = sheet.getRow(0).getCell(1).getStringCellValue();
		String pwd = sheet.getRow(1).getCell(1).getStringCellValue();
		String empname = sheet.getRow(2).getCell(1).getStringCellValue();
		String status = sheet.getRow(3).getCell(1).getStringCellValue();
		String role = sheet.getRow(4).getCell(1).getStringCellValue();
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		up.searchAddedUser(username);
		up.clickOnSearch();
		up.clickOnEdbutn();

		assertEquals(up.validateEmpName(empname), true, "Employee name mismatch");
		assertEquals(up.validateStatus(status), true, "Status mismatch");
		assertEquals(up.validateUsername(username), true, "username mismatch");
		assertEquals(up.validateUserRole(role), true, "userole mismatch");
	}

}
