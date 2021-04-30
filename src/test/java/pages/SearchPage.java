package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchField;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    public SearchPage() {
        super();
    }

    public void fillTheSearchField(String textToSearch) {
        Actions actions = new Actions(driver);

        assertThat(searchField.isDisplayed()).as("Google search field is not displayed").isTrue();
       // searchField.click();
        actions.moveToElement(searchField).click().build().perform();
        searchField.clear();
        searchField.sendKeys(textToSearch);
    }

    public void pressEnter() {
        searchField.sendKeys(Keys.RETURN);
    }

    public void clickSearchButtonOrPressEnter() throws InterruptedException {
        if (isElementFound(By.name("btnK"), 3)) {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();
        } else {
            pressEnter();
        }
    }
/*
    public void openNewTab(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get("https://google.com");
          //  driver.switchTo().window(tabs.get(0));
        }
*/
      public void pasteTextToElementFormClipBoard(String keyword){
        //copy text to memory buffer
          Toolkit toolkit = Toolkit.getDefaultToolkit();
          Clipboard clipboard = toolkit.getSystemClipboard();
          StringSelection stringSelection = new StringSelection(keyword);
          clipboard.setContents(stringSelection, null);
          //past to the field
          searchField.sendKeys(Keys.CONTROL, "v");
          searchField.sendKeys(Keys.ENTER);
      }

    }

