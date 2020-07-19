package com.endava.bookingDemo.pageObjects;

import com.github.javafaker.Faker;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.nio.ByteBuffered;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private static final String baseUrl = "https://webkul-booking-app-demo-2.myshopify.com/products/beauty-salon";

    private By productTitle = By.cssSelector(".product-single__title");
    private By datePicker = By.cssSelector("input.form-control");
    private By datePickerDays = By.cssSelector(".dp-days");
    private By monthPiker = By.className("dp-cal-month");
    private By yearPiker = By.className("dp-cal-year");
    private By nextMonthButton = By.className("dp-next");
    private By timeSlotDropdown = By.cssSelector("select.form-control.timestamp");
    private By bookNowButton = By.id("wk_bc_AddToCart");
    private By cartTitle = By.cssSelector("h1.cart-header__title");
    private By checkOutButton = By.name("checkout");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void load() {
        driver.get(baseUrl);
    }


    public void waitForProductPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(baseUrl));

    }

    public String getText() {
        return driver.findElement(productTitle).getText();

    }

    public void selectDateTable() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(datePicker)).click();
    }

    public void selectMonth(String setDateStr) throws ParseException {


        String currentMonth = driver.findElement(monthPiker).getText();
        String currentYear = driver.findElement(yearPiker).getText();

        Date setChoseDate = new SimpleDateFormat("yyyy/MM/dd").parse(setDateStr);
        Date currentDate = new SimpleDateFormat("MMMM/yyyy").parse(currentMonth+"/"+currentYear);

        int monthDifference = Months.monthsBetween(new DateTime(currentDate).withDayOfMonth(1), new DateTime(setChoseDate).withDayOfMonth(1)).getMonths();

        if(monthDifference>0){
            for(int i=0;i<monthDifference; i++){
                driver.findElement(nextMonthButton).click();
            }
        }else{
            System.out.println("Invalid date!");

        }


    }

    public void selectDateFromMonth(String dayInput){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(datePickerDays));

        // LocalDate date = LocalDate.now();
        // DayOfWeek dayOfTheWeek =date.getDayOfWeek();
        // String [] weekDays = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};

        // Calendar cal = Calendar.getInstance();
        // int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        //
        // System.out.println(dayOfMonth);


        WebElement pickDate = driver.findElement(datePickerDays);
        List<WebElement> days = pickDate.findElements(By.tagName("button"));
        for (WebElement day : days) {
            if (day.getText().equals(dayInput)) {
                day.click();
                break;
            }
        }
    }

    public void selectTimeSlot() {
        Faker faker = new Faker();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(timeSlotDropdown)).click();

        Select timeSlot = new Select(driver.findElement(By.cssSelector("select.form-control.timestamp")));
        timeSlot.selectByIndex(faker.number().numberBetween(1,11));
    }

    public void clickBookNow() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(bookNowButton)).click();
    }

     public String cartDetails() {
       return driver.findElement(cartTitle).getText();
    }

    public void clickCheckOut() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton)).click();
    }

    public  String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
