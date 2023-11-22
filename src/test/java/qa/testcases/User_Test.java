package qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qa.base.BaseTest;

import qa.pages.User_Page;

public class User_Test extends BaseTest {
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

}
