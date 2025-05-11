package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginSuccess() {
        loginPage.login("student", "Password123");
        driver.navigate().to("https://practicetestautomation.com/logged-in-successfully/");
        Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
