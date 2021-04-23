package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    WebDriverWait wait;

    BasePage() {
        this.driver = BaseTest.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //ленивая инициализация.
    }

    boolean  isElementFound(By by, int timeout) throws InterruptedException{
        List<WebElement> elements = driver.findElements(by);
        for (int i =0; (i<timeout)&&(elements.size()==0); i++){
            Thread.sleep(1000);
            elements = driver.findElements(by);
        }
        return elements.size() > 0;
    }

}
