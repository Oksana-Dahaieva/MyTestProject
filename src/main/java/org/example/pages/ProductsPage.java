package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//span[contains(text(),'results for')]/parent::div//span)[last()]")
    WebElement productResult;

    @FindBy(xpath = "(//span[contains(text(),'MacBook Air')])[1]")
    WebElement firstProduct;

    @FindBy(xpath = "//span[contains(text(),'In Stock')]")
    WebElement inStock;

    @FindBy(xpath = "//input[@title='Add to Shopping Cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//h1[contains(text(),'Added to Cart')]")
    WebElement successfulMessage;

    public String resultsForProduct() {
        return productResult.getText();
    }

    public WebElement getFirstProduct(){
        return firstProduct;
    }

    public void selectFirstProduct() {
        firstProduct.click();
    }

    public WebElement getInStock(){
        return inStock;
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public WebElement getSuccessfulMessage(){
        return successfulMessage;
    }
}
