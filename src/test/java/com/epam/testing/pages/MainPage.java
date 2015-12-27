package com.epam.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.apache.log4j.Logger;

public class MainPage extends AbstractPage
{
    private final Logger logger = Logger.getLogger(LoginPage.class);
    private final String BASE_URL = "http://seasonvar.ru/";

    @FindBy(xpath = "//input[@value='Найти!']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//input[@value='']")
    private WebElement fieldOfSearch;

    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnSearchButton()
    {
        buttonSearch.click();
        fieldOfSearch.click();
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }
}
