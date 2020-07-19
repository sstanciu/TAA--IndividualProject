package com.endava.bookingDemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;


public class CataloguePage {
    private WebDriver driver;
    private String baseUrl="https://webkul-booking-app-demo-2.myshopify.com/collections/all";
    private By productTitle = By.xpath("//span[@class='visually-hidden']");
    private By productItem = By.className("h4 grid-view-item__title product-card__title");



    public CataloguePage(WebDriver driver) {
        this.driver = driver;
    }

    public void load(){driver.get(baseUrl);}

    public ProductPage selectProduct(String expectedTitle) {

        List<WebElement> productNameList = driver.findElements(productTitle);
        for (WebElement productArea : productNameList) {
            System.out.println(productArea.getText());
            if(productArea.getText().equals(expectedTitle)){
                    productArea.submit();}



           }


        ProductPage productPage = new ProductPage(driver);
        productPage.waitForProductPage();
        return productPage;



    }
}
