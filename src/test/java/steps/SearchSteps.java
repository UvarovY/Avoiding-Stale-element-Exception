package steps;

import pages.SearchPage;

public class SearchSteps {

    SearchPage searchPage = new SearchPage();

    // создали инстанс SearchPage с которым будем работать
    public SearchResultsSteps executeSearchByKeyword(String keyword) throws InterruptedException {

        SearchPage searchPage = new SearchPage();
        searchPage.pasteToSearchField(keyword);
        searchPage.clickSearchButtonOrPressEnter();
        return new SearchResultsSteps();
    }

    public SearchResultsSteps SearchResultsStepsWithJavaScript(String keyword) throws InterruptedException {
        SearchPage searchPage = new SearchPage();
        searchPage.openNewTab();
        searchPage.fillTheSearchFieldWithActionsBuilder(keyword);
        return new SearchResultsSteps();
    }

    public SearchSteps OpenTooltip(){
        searchPage.moveToVoiceSearchButton();
        return this;
    }

    public SearchSteps verifyThatTooltipContainsProperText(String text){
        searchPage.assertThatVoiceButtonToolTipContainsText(text);
        return this;
    }
}
