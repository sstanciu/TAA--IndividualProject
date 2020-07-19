package com.endava.bookingDemo.pageObjects;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private static final String baseUrl = "https://webkul-booking-app-demo-2.myshopify.com/cart";
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void load(){driver.get(baseUrl);}



//    public void waitForCartPage() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlToBe(baseUrl));
//
//    }
//
//    public String cartDetails() {
//        return driver.findElement(cartTitle).getText();
//    }
//
//    public void clickCheckOut() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton)).click();
//    }

}
