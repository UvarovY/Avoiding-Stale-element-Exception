package steps;

import pages.SearchResultsPage;

public class SearchResultsSteps {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    public SearchResultsSteps verifyThatTopResultContainsCorrectText(String expectedValue) {

        searchResultsPage.assertThatTopResultContainsCorrectText(expectedValue);
        return this;
    }

    public SearchResultsSteps verifyThatTopResultContainsProperAttribute(String expectedValue) {
        searchResultsPage.assertThatTopResultContainsProperAttribyteText(expectedValue);
        return this;
    }

    public SearchResultsSteps verifyThatTopResultContainsCorrectTextWithJavaScript(String expectedValue){
        searchResultsPage.assertThatTopResultContainsCorrectTextWithJavaScript(expectedValue);
        return this;
    }
}
