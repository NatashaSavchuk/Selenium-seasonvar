package com.epam.testing.steps;

import com.epam.testing.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class Steps
{
    private WebDriver driver;

    private final Logger logger = Logger.getLogger(Steps.class);

    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void closeDriver()
    {
        driver.close();
        logger.info("Browser stopped");
    }

    public void loginSeason(String email, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(email, password);
    }

    public boolean isLoggedIn(String email)
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(email));
    }


    public boolean resultFound(String text)
    {
        Search searchField = new Search(driver);
        searchField.openPage();
        return searchField.resultIsFound(text);
    }

    public boolean resultWithTextFound(String text)
    {
        Search searchField = new Search(driver);
        searchField.openPage();
        logger.info("Search \" " + text + " \" was performed");
        return searchField.resultIsNotFound();
    }

    public void createMark()
    {
        PausePage pausePage = new PausePage(driver);
        pausePage.openPage();
        pausePage.markOfPause();
    }

    public void deleteMark()
    {
        PausePage pausePage = new PausePage(driver);
        pausePage.openPage();
        pausePage.markOfDelete();
    }

    public boolean markFound()
    {
        PausePage pausePage = new PausePage(driver);
        pausePage.openPage();
        return pausePage.markOfSeries();
    }


    public void createComment()
    {
        Comment comment = new Comment(driver);
        comment.openPage();
        comment.addComment();
    }

    public boolean commentFound()
    {
        Comment comment = new Comment(driver);
        comment.openPage();
        return comment.commentIsFound();
    }
  /*  public boolean isSearch(String text)
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSearchButton();
        Search searchField = new Search(driver);
        searchField.openPage();
        return searchField.resultIsFound(text);
    }
    public boolean currentSearchIsEmpty()
    {
        Search search = new Search(driver);
        return search.isCurrentSearchEmpty();
    }
*/

}
