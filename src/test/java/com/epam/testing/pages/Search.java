package com.epam.testing.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search extends AbstractPage
{
    private final Logger logger = Logger.getLogger(Search.class);
    private final String BASE_URL = "http://seasonvar.ru/search?q=&x=42&y=6";

    @FindBy(xpath = "//input[@class='form-searchnew']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//input[@value='']")
    private WebElement fieldOfSearch;

    @FindBy(xpath = "//a[text()='Arrow']")
    private WebElement linkOfSearch;

    @FindBy(xpath = "//div[@class='doptxt']")
    private WebElement labelEmptySearch;

    public Search(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Page with series opened");
    }

    public void markSeries(String text)
    {
        fieldOfSearch.sendKeys(text);
        buttonSearch.click();
        logger.info("Search passed");
    }

    public boolean resultIsFound(String result){

        try{
            WebElement element =  driver.findElement(By.xpath("//div[contains(text()=" + result + ")]"));
        }
        catch(NoSuchElementException e){
            return false;
        }
        return true;
    }

    public boolean resultIsNotFound(){
        String text = "������� �� ������� \"�����\": 0";
        try{
            WebElement element =  driver.findElement(By.xpath("//div[@class='doptxt']"));
        }
        catch(NoSuchElementException e){
            return false;
        }
        return true;
    }
/*    public boolean isCurrentSearchEmpty()
    {
        return labelEmptySearch.isDisplayed();
    }

    public String getCurrentSearchText()
    {
        return linkOfSearch.getText();
    }
*/
}
