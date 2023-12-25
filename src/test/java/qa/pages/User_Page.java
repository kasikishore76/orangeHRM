package qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

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
		Thread.sleep(10000);
		for (WebElement ele : empNames) {
			System.out.println(ele.getText());
			if (ele.getText().contains(empname)) {
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
				
				break;
			}
		}
	}
	public void enterUserName(String usrname) {
		usernameText.sendKeys(usrname);

	}
	public void enterPassword(String pwd) {
		pwdText.sendKeys(pwd);

	}
	public void enterCnfPassword(String cnfpwd) {
		confPwdText.sendKeys(cnfpwd);

	}
	public void clickSave() {
		saveBtn.click();
	}

}
