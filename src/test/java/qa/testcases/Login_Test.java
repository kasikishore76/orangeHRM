package qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pages.Login_page;

public class Login_Test extends BaseTest {
	Login_page lp;

	@BeforeClass
	public void createPageObject() {
		lp = new Login_page(getDriver());
		System.out.println(getDriver());
	}

	@Test
	public void login_Test() {
		lp.login("Admin", "admin123");
		assertEquals(getDriver().getTitle(), "OrangeHRM", "Title missmatch");

	}

//	@DataProvider(parallel = true)
	public String[][] loginDetails() throws IOException {
		File excelfile = new File("C://Users//kasik//workspace//oranagehrm.testng//src//main//resources//files//logins.xlsx");
//		if(excelfile.exists()}
		FileInputStream fis = new FileInputStream(excelfile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("logins");
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		String[][] data = new String[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				Row row = sheet.getRow(i);
				data[i][j] = row.getCell(j).toString();

			}

		}
		wb.close();
		fis.close();

		return data;
	}

}
