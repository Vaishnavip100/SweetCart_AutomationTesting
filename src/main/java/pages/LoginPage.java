package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By loginLink=By.linkText("Login");
    private By emailField=By.id("exampleInputEmail");
    private By passwordField=By.id("exampleInputPassword");
    private By loginBtn=By.xpath("//button[text()='Login']");
    private By errorMsg=By.xpath("//div[contains(text(),'Use one of the demo')]");
    private By loginHeader=By.xpath("//h1[contains(text(),'Login')]");

    public void clickLoginLink() {
        click(loginLink);
    }

    public void login(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        click(loginBtn);
    }

    public String getErrorMessage() {
        return getText(errorMsg);
    }
    
    public boolean isLoginPageDisplayed() {
        return isDisplayed(loginHeader);
    }
}