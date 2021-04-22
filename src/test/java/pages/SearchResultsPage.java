package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//*[@class='LC20lb DKV0Md']")
    private WebElement resultRow;

    @FindBy(xpath = "//*[@class='LC20lb DKV0Md']")
    private List<WebElement> resultRows;

    public SearchResultsPage(){
        super();
    }

    public void assertThatTopResultContainsCorrectText(String text){
        assertThat(resultRow.isDisplayed()).as("Element hasn't been displayed").isTrue();
        assertThat(resultRows.stream().map(e->e.getText()).collect(Collectors.toList()).toString())
                .as("Search result is wrong").contains(text);

    }

    public void assertThatTopResultContainsProperAttribyteText(String text) {
        assertThat(resultRow.getAttribute("class")).as("Wrong attribyte text").contains(text);
    }
}
