package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    BasePage() {
        this.driver = BaseTest.getDriver();
        PageFactory.initElements(driver, this);
        //ленивая инициализация.
    }
}
