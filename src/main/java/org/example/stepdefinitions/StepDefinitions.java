package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.configuration.Config;
import org.example.manager.PageFactoryManager;
import org.example.pages.HomePage;
import org.example.pages.ProductsPage;
import org.example.pages.SignInPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    private static final long DEFAULT_TIMEOUT = 60;

    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private ProductsPage productsPage;
    private PageFactoryManager pageFactoryManager;

    @Before
    public void setUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        homePage = pageFactoryManager.getHomePage();
        signInPage = pageFactoryManager.getSignInPage();
        productsPage = pageFactoryManager.getProductsPage();
    }

    @Given("User opens home page")
    public void userOpensHomePagePage() {
        homePage.openHomePage(Config.getProperty("ui.base.url"));
    }

    @And("User move to sign in page")
    public void userMoveToSignInPage() {
        homePage.clickSignInButton();
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getEmailInput());
    }

    @And("User enter email")
    public void userEnterEmail() {
        signInPage.enterEmail(Config.getProperty("ui.base.email"));
        signInPage.clickContinueButton();
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getPasswordInput());
    }

    @And("User enter password")
    public void userEnterPassword() {
        signInPage.enterPassword(Config.getProperty("ui.base.password"));
        signInPage.clickSignInButton();
        homePage.waitTextToBePresentInElement(DEFAULT_TIMEOUT, homePage.getMessageFromHeader(), "Hello, Oksana");
    }

    @Then("User should see a welcome message")
    public void userCanSeeHeaderMessage() {
        assertEquals(homePage.getMessageFromHeader().getText(), "Hello, Oksana");
    }

    @When("User search product {string}")
    public void userSearchProduct(String product) {
        homePage.searchProduct(product);
    }

    @And("User click search button")
    public void userClickSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User should verify correct result {string}")
    public void userShouldVerifyCorrectResult(String product) {
        assertTrue(productsPage.resultsForProduct().contains(product));
    }

    @And("User select first product from results")
    public void userSelectsFirstProduct() {
        assertTrue(productsPage.waitTextToBePresentInElement(DEFAULT_TIMEOUT,
                productsPage.getFirstProduct(), "MacBook Air"));
        productsPage.selectFirstProduct();
    }

    @And("User should verify that product is in stock")
    public void userVerifiesProductInStock() {
        productsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,
                productsPage.getInStock());
        assertTrue(productsPage.waitTextToBePresentInElement(DEFAULT_TIMEOUT,
                productsPage.getInStock(), "In Stock"));
    }

    @And("User adds product to cart")
    public void userAddsToCart() {
        productsPage.clickAddToCartButton();
    }

    @And("User should see a successful message")
    public void userVerifySuccessfulMessage() {
        assertTrue(productsPage.waitTextToBePresentInElement(DEFAULT_TIMEOUT,
                productsPage.getSuccessfulMessage(), "Added to Cart"));
    }


    @After
    public void tearDown() {
        driver.close();
    }

}
