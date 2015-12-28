package com.epam.testing.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage
{
    private final Logger logger = Logger.getLogger(LoginPage.class);
    private final String BASE_URL = "http://seasonvar.ru/?mod=login";

    @FindBy(xpath = "//input[@value='E-mail']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@value='pass']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//div[contains(text(), 'testselen2015@yandex.ru')]")
    private WebElement linkLoggedInUser;

    public LoginPage(WebDriver driver)
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

    public void login(String email, String password)
    {
        inputLogin.sendKeys(email);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        logger.info("Login performed");
    }

    public String getLoggedInUserName()
    {
        return linkLoggedInUser.getText();
    }
}
