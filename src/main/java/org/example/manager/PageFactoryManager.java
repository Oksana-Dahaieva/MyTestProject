package org.example.manager;

import org.example.pages.HomePage;
import org.example.pages.SignInPage;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class PageFactoryManager {

    private WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SignInPage getSignInPage(){
        return new SignInPage(driver);
    }
}
