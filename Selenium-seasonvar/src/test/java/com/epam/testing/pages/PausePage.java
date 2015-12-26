package com.epam.testing.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class PausePage extends AbstractPage
{
    private final Logger logger = Logger.getLogger(LoginPage.class);
    private final String BASE_URL = "http://seasonvar.ru/serial-12504-Strela-4-season.html";

    @FindBy(xpath = "//span[@class='pauseSeria']")
    private WebElement buttonOfMark;

    @FindBy(xpath = "//img[@class='pauseDel ']")
    private WebElement buttonOfDelete;

    @FindBy(xpath = "//div[@id='statpause12504']")
    private WebElement seriesMark;

    public PausePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

    public void markOfPause()
    {
        buttonOfMark.click();
        logger.info("Series marked");
    }

    public void markOfDelete()
    {
        buttonOfDelete.click();
        logger.info("Mark deleted");
    }

    public boolean markOfSeries()
    {
        try{
            WebElement element = driver.findElement(By.xpath("//div[@id='statpause12504']"));
        }
        catch (NoSuchElementException e){
            return false;
        }
        return true;
    }
}
