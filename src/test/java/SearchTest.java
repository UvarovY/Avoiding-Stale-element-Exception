import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SearchTest {

    @Test
    public void openGoogleChromeTest(){

        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver driver = new ChromeDriver();
        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());

        File file2 = new File("src/test/resources/IEDriverServer.exe");
        System.setProperty("webdriver.ie.driver", file2.getAbsolutePath());
        WebDriver driver1 = new InternetExplorerDriver();
        driver1.get("https://google.com");
        System.out.println(driver1.getTitle());

        driver.quit();
        driver1.quit();
    }
}
