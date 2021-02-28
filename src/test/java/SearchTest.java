import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SearchTest {

    @Test
    public void openGoogleChromeTest(){

        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chromedriver",file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("google.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
