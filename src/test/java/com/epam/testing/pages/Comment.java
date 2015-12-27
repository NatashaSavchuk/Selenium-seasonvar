package com.epam.testing.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class Comment extends AbstractPage
{
    private final Logger logger = Logger.getLogger(LoginPage.class);
    private final String BASE_URL = "http://svc.seasonvar.ru/2188444526b19e750280237b5f8d28aa/thread/serial-12504-Strela-4-season.html";

    @FindBy(xpath = "//textarea[@id='svc_new']")
    private WebElement fieldOfComment;

    @FindBy(xpath = "//input[@id='svc_send']")
    private WebElement buttonOfComment;

    public Comment(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Comment page opened");
    }

    public void addComment()
    {
        fieldOfComment.sendKeys("Последний сезон намного лучше предыдущих. Жду окончания хиатуса");
        buttonOfComment.click();
        logger.info("Comment added");
    }


    public boolean commentIsFound()
    {
        try{
            WebElement element = driver.findElement(By.xpath("//div[@id='com_693399']"));
        }
        catch (NoSuchElementException e){
            return false;
        }
        return true;
    }
}
