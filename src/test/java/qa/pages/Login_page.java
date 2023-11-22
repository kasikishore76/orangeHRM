package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement usernameInput;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passworkdInput;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginBtn;

	public Login_page(WebDriver driver) {
		System.out.println(driver);
		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);
	}
	
	public void login(String usrname,String pwd) {
		
		usernameInput.sendKeys(usrname);
		passworkdInput.sendKeys(pwd);
		loginBtn.click();
	}

}
