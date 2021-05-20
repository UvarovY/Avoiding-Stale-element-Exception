package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(dataProvider = ("Data Provider"))
    public void openGoogleChromeTest(String searchText) throws InterruptedException {

        steps.executeSearchByKeyword(searchText)
                .verifyThatTopResultContainsCorrectText("Selenium Webdriver")
                .verifyThatTopResultContainsProperAttribute("LC20lb DKV0Md");
    }

    @Test
    public void verifySearchByVoiceTooltipOnGoogle(){
        steps.OpenTooltip()
                .verifyThatTooltipContainsProperText("Пошук голосом");
    }

}
