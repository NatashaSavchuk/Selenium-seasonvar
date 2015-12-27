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
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return searchField.resultIsFound(text);
    }

    public boolean resultWithTextFound(String text)
    {
        Search searchField = new Search(driver);
        searchField.openPage();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        logger.info("Search \" " + text + " \" was performed");
        return searchField.resultIsNotFound();
    }

    public void createMark()
    {
        PausePage pausePage = new PausePage(driver);
        pausePage.openPage();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pausePage.markOfPause();
    }

    public void deleteMark()
    {
        PausePage pausePage = new PausePage(driver);
        pausePage.openPage();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pausePage.markOfDelete();
    }

    public boolean markFound()
    {
        PausePage pausePage = new PausePage(driver);
        pausePage.openPage();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return pausePage.markOfSeries();
    }


    public void createComment()
    {
        Comment comment = new Comment(driver);
        comment.openPage();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        comment.addComment();
    }

    public boolean commentFound()
    {
        Comment comment = new Comment(driver);
        comment.openPage();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return comment.commentIsFound();
    }
}
