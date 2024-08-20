package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='layoutToolbarPadding']//a[contains(@href,'https://www.amazon.com/ap/signin')]")
    WebElement sigInButton;

    @FindBy(xpath = "//span[contains(text(),'Hello')]")
    WebElement headerMessage;

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickSignInButton(){
        sigInButton.click();
    }

    public WebElement getMessageFromHeader(){
        return headerMessage;
    }
}
