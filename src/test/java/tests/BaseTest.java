package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Browser;
import utils.DriverFactory;
import utils.DriverSettings;

public abstract class BaseTest {


    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver(Browser.CHROME);
        driver.get("https://google.com");
    }

    @BeforeMethod
    public void drSettings() {
      driver = DriverFactory.getDrSettings(DriverSettings.FALSE);
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "Data Provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"selenium java"}, {"seleniumgit "}};
    }
}
