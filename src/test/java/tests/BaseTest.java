package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import steps.SearchSteps;
import utils.Browser;
import utils.DriverFactory;
import utils.PropertyReader;

public abstract class BaseTest {

    private static WebDriver driver;
    protected SearchSteps steps;

    public static WebDriver getDriver() {
        return driver;
    }


    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        driver.get(PropertyReader.getUrl());
        steps = new SearchSteps();
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
        return new Object[][]{{"selenium java"}, {"selenium javascript"}};
    }
}
