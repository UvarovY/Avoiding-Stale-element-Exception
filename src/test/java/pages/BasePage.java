package pages;

import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public abstract class BasePage {

    protected WebDriver driver;

    BasePage(){
        this.driver = BaseTest.getDriver();
    }
}
