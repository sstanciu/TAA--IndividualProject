package com.endava.bookingDemo;

import com.endava.bookingDemo.manager.DriverManager;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;



public class TestBaseClass {
    protected WebDriver driver;


    @BeforeEach
    public void setUpDriver() {
        driver = DriverManager.getWebDriver();
    }

    @AfterEach
    public void tearDownDriver() throws Exception {
        Thread.sleep( 2000 );
        driver.quit();
    }

}
