package tests;

import org.testng.annotations.Test;

public class SearchTestWithJavaScript extends BaseTest {

    @Test(dataProvider = ("Data Provider"))
    public void OpenGoogleChromeTestWithJavaScript(String searchText) throws InterruptedException {

        steps.SearchResultsStepsWithJavaScript(searchText)
                .verifyThatTopResultContainsCorrectText("Selenium Webdriver")
                .verifyThatTopResultContainsProperAttribute("LC20lb DKV0Md");
    }
}