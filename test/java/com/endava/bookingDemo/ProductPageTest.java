package com.endava.bookingDemo;

import com.endava.bookingDemo.pageObjects.ProductPage;
import org.junit.jupiter.api.Test;

import java.text.ParseException;


import static org.assertj.core.api.Assertions.assertThat;

public class ProductPageTest extends TestBaseClass {

    @Test
    public void shouldBookProduct() throws InterruptedException, ParseException {


        //Given
        ProductPage productPage = new ProductPage(driver);
        productPage.load();

        //When
        productPage.selectDateTable();
        productPage.selectMonth("2020/12/21");
        Thread.sleep(5000);

        productPage.selectDateFromMonth("21");
        Thread.sleep(5000);

        productPage.selectTimeSlot();
        Thread.sleep(3000);

        productPage.clickBookNow();
        Thread.sleep(8000);

        //Then
        String chartUrl = productPage.getCurrentUrl();
        assertThat(chartUrl).contains("cart");

        String actualTitle = productPage.cartDetails();
        String expectedTitle = "Your cart";
        assertThat(actualTitle).isEqualTo(expectedTitle);

        productPage.clickCheckOut();
        Thread.sleep(3000);


    }


    @Test

    public void invalidDateError() throws ParseException {

        //Given
        ProductPage productPage = new ProductPage(driver);
        productPage.load();

        //When
        productPage.selectDateTable();
        productPage.selectMonth("2020/06/21");

        //Than
        String newUrl = productPage.getCurrentUrl();
        assertThat(newUrl).contains("products/beauty-salon");




    }
}

