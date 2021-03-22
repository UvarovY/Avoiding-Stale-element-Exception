package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchResultsPage;
import tests.BaseTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {

    @Test(dataProvider = ("Data Provider"))
    public void openGoogleChromeTest(String searchText) throws InterruptedException {

        SearchPage searchPage = new SearchPage();
        searchPage.fillTheSearchField(searchText);
        searchPage.pressEnter();
        Thread.sleep(1000);

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.assertThatTopResultContainsCorrectText("WebDriver");
        searchResultsPage.assertThatTopResultContainsProperAttribyteText("LC20lb DKV0Md");

    }

}
