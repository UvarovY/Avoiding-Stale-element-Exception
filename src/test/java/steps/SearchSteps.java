package steps;

import pages.SearchPage;
import pages.SearchResultsPage;

public class SearchSteps {

     SearchPage searchPage = new SearchPage();

    // создали инстансе SearchPage с которым будем работать


    public SearchResultsSteps executeSearchByKeyword(String keyword) throws InterruptedException {

        SearchPage searchPage = new SearchPage();
        searchPage.fillTheSearchField(keyword);
        searchPage.pressEnter();
        Thread.sleep(1000);

        return new SearchResultsSteps();
    }
}
