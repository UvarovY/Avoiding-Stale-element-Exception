package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchField;


    public SearchPage() {
        super();
    }

    public void fillTheSearchField(String textToSearch) {

        assertThat(searchField.isDisplayed()).as("Google search field is not displayed").isTrue();
        searchField.click();
        searchField.clear();
        searchField.sendKeys(textToSearch);
    }



    public void pressEnter() {
        searchField.sendKeys(Keys.RETURN);
    }


}
