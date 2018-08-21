package ObjectRepository;

import org.openqa.selenium.By;

public class NavigatorLoginPageOR {

	private static final By LOGIN_EMAIL_TXT = By.name("Email");
	private static final By LOGIN_PWD_TXT = By.name("Password");
	private static final By LOGIN_BTN = By.xpath("//button[contains(text(),'Login')]");
	
	public static By getLoginEmailTxt() {
		return LOGIN_EMAIL_TXT;
	}
	public static By getLoginPwdTxt() {
		return LOGIN_PWD_TXT;
	}
	public static By getLoginBtn() {
		return LOGIN_BTN;
	}
	
}
