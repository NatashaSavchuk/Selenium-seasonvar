package com.epam.testing;


import com.epam.testing.steps.Steps;
import com.epam.testing.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeasonAutomationTest
{
    private Steps steps;
    private final String EMAIL = "testselen2015@yandex.ru";
    private final String PASSWORD = "testsel123";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login to Seasonvar")
    public void oneCanLoginSeason()
    {
        steps.loginSeason(EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(EMAIL));
    }

    @Test
    public void oneCanSearch()
    {
        steps.loginSeason(EMAIL, PASSWORD);
        Assert.assertTrue(steps.resultWithTextFound("Arrow"));
        /*Assert.assertTrue(steps.currentSearchIsEmpty());*/
    }

    @Test
    public void oneCanMarkOfSeries()
    {
        steps.loginSeason(EMAIL, PASSWORD);
        steps.createMark();
      //  Assert.assertTrue(steps.markFound());
    }

    @Test
    public void oneCanDeleteMark()
    {
        steps.loginSeason(EMAIL, PASSWORD);
        steps.deleteMark();
        Assert.assertTrue(steps.markFound());
    }

    @Test
    public void oneCanAddComment()
    {
        steps.loginSeason(EMAIL, PASSWORD);
        steps.createComment();
        Assert.assertTrue(steps.commentFound());
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
