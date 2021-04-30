package steps;

import pages.SearchPage;

public class SearchSteps {

    SearchPage searchPage = new SearchPage();

    // создали инстанс SearchPage с которым будем работать
    public SearchResultsSteps executeSearchByKeyword(String keyword) throws InterruptedException {

        SearchPage searchPage = new SearchPage();
        searchPage.fillTheSearchField(keyword);
        searchPage.clickSearchButtonOrPressEnter();
        //searchPage.openNewTab();
       // searchPage.pasteTextToElementFormClipBoard(keyword);
        return new SearchResultsSteps();
    }
}
