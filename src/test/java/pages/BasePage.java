package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    WebDriverWait wait;
    Actions builder;
    JavascriptExecutor executor;

    BasePage() {
        this.driver = BaseTest.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //ленивая инициализация.
        builder = new Actions(driver);
        executor = (JavascriptExecutor) driver;

    }

    boolean  isElementFound(By by, int timeout) throws InterruptedException{
        List<WebElement> elements = driver.findElements(by);
        for (int i =0; (i<timeout)&&(elements.size()==0); i++){
            Thread.sleep(1000);
            elements = driver.findElements(by);
        }
        return elements.size() > 0;
    }

   protected void pasteTextToElementFromClipBoard(WebElement element, String keyword){
        //copy text to memory buffer
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection stringSelection = new StringSelection(keyword);
        clipboard.setContents(stringSelection, null);
        //past to the field
        element.sendKeys(Keys.CONTROL, "v");
    }

    public void openNewTab(){
        executor.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://google.com");
        //переключаемся на таб, с популяцией т
        // driver.switchTo().window(tabs.get(0));
    }

}
