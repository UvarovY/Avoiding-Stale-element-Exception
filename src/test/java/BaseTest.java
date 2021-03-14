import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;

public abstract class BaseTest {


    protected WebDriver driver;

    @BeforeClass
    public void setUp() {

        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
