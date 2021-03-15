import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

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

    @BeforeMethod
    public void driverSettings(){
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void goBack(){
        driver.navigate().back();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "Data Provider")
    public Object [][] dataProviderMethod(){
        return new Object[][]{{"selenium java"}, {"selenium javascript"}};
    }
}
