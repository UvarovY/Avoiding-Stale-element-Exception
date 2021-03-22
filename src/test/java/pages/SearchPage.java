package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {

    public SearchPage() {
        super();
    }

    private By searchField = By.xpath("//input[@class='gLFyf gsfi']");

    public void fillTheSearchField(String textToSearch){
        WebElement searchFieldElement = driver.findElement(searchField);
        assertThat(searchFieldElement.isDisplayed()).as("Google search field is not displayed").isTrue();
        searchFieldElement.click();
        searchFieldElement.clear();
        searchFieldElement.sendKeys(textToSearch);
    }

    public void pressEnter(){
        WebElement searchFieldElement = driver.findElement(searchField);
        searchFieldElement.sendKeys(Keys.RETURN);
    }




}
