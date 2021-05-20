package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @FindBy(xpath = "//*[@class='HPVvwb']")
    private WebElement searchByVoiceButton;

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchField;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    public SearchPage() {
        super();
    }

    public void fillTheSearchField(String textToSearch) {
        assertThat(searchField.isDisplayed()).as("Google search field is not displayed").isTrue();
        searchField.click();
        searchField.clear();
        searchField.sendKeys(textToSearch);
    }

    // fill search field with Actions builder and JavaScript.
    public void fillTheSearchFieldWithActionsBuilder(String textToSearch) {
        assertThat(searchField.isDisplayed()).as("Google search field is not displayed").isTrue();
        Actions actions = new Actions(driver);
        actions.moveToElement(searchField).click().build().perform();
        searchField.clear();
        executor.executeScript("arguments[0].value = '" + textToSearch + "'", searchField);
        actions.sendKeys(Keys.ENTER).click().build().perform();
    }

    public void pasteToSearchField(String text) {
        pasteTextToElementFromClipBoard(searchField, text);
    }


    public void pressEnter() {
        searchField.sendKeys(Keys.RETURN);
    }

    public void clickSearchButtonOrPressEnter() throws InterruptedException {
        if (isElementFound(By.name("btnK"), 3)) {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            //searchButton.click();
            clickWithJavaScript(searchButton);
        } else {
            pressEnter();
        }
    }


    public void moveToVoiceSearchButton() {
        builder.moveToElement(searchByVoiceButton).build().perform();
    }

    public void assertThatVoiceButtonToolTipContainsText(String text) {
        assertThat(pageBody.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size())
                .as("Expected tooltip [" + text + "] was not found").isNotZero();
    }


}

