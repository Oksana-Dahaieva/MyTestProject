package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    WebElement signInButtonButton;

    public WebElement getEmailInput(){
        return emailInput;
    }

    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public WebElement getPasswordInput(){
        return passwordInput;
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickSignInButton(){
        signInButtonButton.click();
    }
}
