package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_Page {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement adminOption;

	@FindBy(xpath = "//li/span[text()='User Management ']")
	private WebElement usermgmtOption;

	@FindBy(xpath = "//li/span[text()='User Management ']/following-sibling::ul//a[text()='Users']")
	private WebElement userOption;
	
	@FindBy(xpath = "//h5[normalize-space()='System Users']")
	private WebElement header;

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
		if(header.isDisplayed())
			return true;
		else 
			return false;
		
	}

}
