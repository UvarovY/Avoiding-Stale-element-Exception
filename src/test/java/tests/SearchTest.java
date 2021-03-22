package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {

    @Test(dataProvider = ("Data Provider"))
    public void openGoogleChromeTest(String searchText) throws InterruptedException {

        WebDriver driver = BaseTest.getDriver();

        WebElement searchField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        assertThat(searchField.isDisplayed()).as("Google search field is not displayed").isTrue();
        //   assertThat(searchField.getAttribute("title")).as("Wrong title is displayed").isEqualTo("Пошук");

        searchField.click();
        searchField.clear();

        searchField.sendKeys(searchText);
        searchField.sendKeys(Keys.RETURN);

        Thread.sleep(1000);
        WebElement searchesResult = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println("Количество результатов поиска: " + searchesResult
                .getText());
        System.out.println("Поиск длился : " + driver.findElement(By.xpath("//*[@id='result-stats']/nobr"))
                .getText());

        // WebElement serachREsult2 = driver.findElement(By.xpath("//*[@class='LC20lb DKV0Md']"));

        List<WebElement> serachREsult2 = driver.findElements(By.xpath("//*[@class='LC20lb DKV0Md']"));
        Thread.sleep(2000);

        for (WebElement i : serachREsult2) {
            assertThat(i.getText()).as("Search result is wrong").containsIgnoringCase("selenium");
            assertThat(i.getAttribute("class")).as("Wrong attribyte text").isEqualTo("LC20lb DKV0Md");
        }


       /* assertThat(serachREsult2.isDisplayed()).as("Element hasn't been displayed").isTrue();
       // assertThat(serachREsult2.getText()).as("Search result is wrong").isEqualTo("WebDriver :: Documentation for Selenium");
        assertThat(serachREsult2.getAttribute("class")).as("Wrong attribyte text").contains("LC20lb DKV0Md");*/

    }

}
