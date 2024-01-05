package qa.pages;

import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import qa.utils.JavaScriptUtils;

public class User_Page {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement adminOption;

	@FindBy(xpath = "//li/span[text()='User Management ']")
	private WebElement usermgmtOption;

	@FindBy(xpath = "//li/span[text()='User Management ']/following-sibling::ul//a[text()='Users']")
	private WebElement userOption;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addUserBtn;

	@FindBy(xpath = "//h5[normalize-space()='System Users']")
	private WebElement header;

	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]")
	private WebElement userRoledd;

	@FindBys(@FindBy(xpath = "//label[normalize-space()='User Role']/../following-sibling::div//div[@role='option']"))
	List<WebElement> userRoles;

	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
	private WebElement statusdd;

	@FindBys(@FindBy(xpath = "//label[normalize-space()='Status']/../following-sibling::div//div[@role='option']"))
	List<WebElement> statuses;

	@FindBy(xpath = "//label[normalize-space()='Username']/../following-sibling::div/input")
	WebElement usernameText;

	@FindBy(xpath = "//label[normalize-space()='Password']/../following-sibling::div/input")
	WebElement pwdText;

	@FindBy(xpath = "//label[normalize-space()='Confirm Password']/../following-sibling::div/input")
	WebElement confPwdText;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement empNameText;

	@FindBys(@FindBy(xpath = "//input[@placeholder='Type for hints...']/ ../following-sibling::div/div/span"))
	List<WebElement> empNames;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//label[normalize-space()='Username']/ ../following-sibling::div/input")
	WebElement usernameSearchText;

	@FindBy(xpath = "(//div[@class='oxd-table-card']//div[@role='row']//button)[2]")
	WebElement editBtn;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement searchBtn;

	public User_Page(WebDriver driver) {
		System.out.println(driver);
		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);
	}

	public void openUserPage() {
		adminOption.click();
		usermgmtOption.click();
		userOption.click();
	}

	public boolean assertPage() {
		if (header.isDisplayed())
			return true;
		else
			return false;

	}

	public void openUserDetailspage() {
		addUserBtn.click();

	}

	public void selectUserrole(String role) {
		userRoledd.click();

		for (WebElement ele : userRoles) {
			System.out.println(ele.getText());
			if (ele.getText().contains(role)) {
				ele.click();
				break;
			}
		}
	}

	public void selectStatus(String status) {
		statusdd.click();
		for (WebElement ele : statuses) {
			System.out.println(ele.getText());
			if (ele.getText().contains(status)) {
				ele.click();
				break;
			}
		}
	}

	public void enterEmployeeName(String empname) throws InterruptedException {
		empNameText.sendKeys(empname);
		Thread.sleep(3000);
		int maxAttempts = 10;
		int attempts = 0;

		do {
			empNameText.sendKeys(Keys.ARROW_DOWN);

			if (empNameText.getAttribute("value").equals(empname)) {
				empNameText.sendKeys(Keys.ENTER);
				break;
			}

			attempts++;

			if (attempts >= maxAttempts) {
				System.out.println("Maximum attempts reached. Exiting loop.");
				break;
			}

			// Add a short delay if needed for synchronization with the page
			// Thread.sleep(500);

		} while (!empNameText.getAttribute("value").equals(empname));

	}

	public void enterUserName(String usrname) {
		try {
//			usernameText.clear();
//			usernameText.sendKeys(usrname);
			
			 JavascriptExecutor jse = (JavascriptExecutor)driver;
			 jse.executeScript("arguments[0].value='"+usrname+"';", usernameText);
		

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void enterPassword(String pwd) {
		try {
			pwdText.sendKeys(pwd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void enterCnfPassword(String cnfpwd) {
		try {
			confPwdText.sendKeys(cnfpwd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void clickSave() {
		try {
			JavaScriptUtils.clickElementByJS(driver, saveBtn);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void searchAddedUser(String username) {
		try {
			usernameSearchText.sendKeys(username);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void clickOnSearch() {
		try {
			searchBtn.click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void clickOnEdbutn() {
		try {
			editBtn.click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean validateEmpName(String empname) {
		try {
			return empNameText.getText().equals(empname);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean validateStatus(String status) {
		try {
			return statusdd.getText().equals(status);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean validateUsername(String username) {
		try {
			return usernameText.getText().equals(username);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean validateUserRole(String role) {
		try {
			return userRoledd.getText().equals(role);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
