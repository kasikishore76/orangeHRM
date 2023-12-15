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

	
	public void addUserDetails() {
		addUserBtn.click();
		userRoledd.click();
		
		System.out.println(userRoles.size());
		for (WebElement ele : userRoles) {
			System.out.println(ele.getText());
			if (ele.getText().contains("ESS")) {
				ele.click();
			}
		}

	}

}
