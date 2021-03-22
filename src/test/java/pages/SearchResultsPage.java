package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    private By resultRow = By.xpath("//*[@class='LC20lb DKV0Md']");

    public SearchResultsPage(){
        super();
    }

    public void assertThatTopResultContainsCorrectText(String text){
        WebElement resultRowElement = driver.findElement(resultRow);
        assertThat(resultRowElement.isDisplayed()).as("Element hasn't been displayed").isTrue();
        assertThat(resultRowElement.getText()).as("Search result is wrong").containsIgnoringCase(text);

    }

    public void assertThatTopResultContainsProperAttribyteText(String text) {
        WebElement resultRowElement = driver.findElement(resultRow);
        assertThat(resultRowElement.getAttribute("class")).as("Wrong attribyte text").contains(text);
    }
}
