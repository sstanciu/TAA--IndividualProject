package com.endava.bookingDemo;

import com.endava.bookingDemo.pageObjects.CataloguePage;
import com.endava.bookingDemo.pageObjects.ProductPage;
import org.junit.jupiter.api.Test;



public class CataloguePageTest extends TestBaseClass {

    @Test

    public void shouldOpenProductPage(){

        //Given
        CataloguePage cataloguePage= new CataloguePage(driver);
        cataloguePage.load();


        //When
        cataloguePage.selectProduct("Beauty Salon");


       //Then
//        ProductPage productPage = new ProductPage(driver);
//        String actualTitle = productPage.getTextFromTitle();
//        assertThat(actualTitle).isEqualTo(expectedTitle);


    }

}
