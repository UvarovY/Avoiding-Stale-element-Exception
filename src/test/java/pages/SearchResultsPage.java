package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//*[@class='LC20lb DKV0Md']")
    private WebElement resultRow;

    public SearchResultsPage(){
        super();
    }

    public void assertThatTopResultContainsCorrectText(String text){
        assertThat(resultRow.isDisplayed()).as("Element hasn't been displayed").isTrue();
        assertThat(resultRow.getText()).as("Search result is wrong").containsIgnoringCase(text);

    }

    public void assertThatTopResultContainsProperAttribyteText(String text) {
        assertThat(resultRow.getAttribute("class")).as("Wrong attribyte text").contains(text);
    }
}
