import org.openqa.selenium.WebDriver;

public abstract class BaseTest {


    protected WebDriver driver;


    public void setUp(){


    }



    public void tearDown(){
        driver.quit();
    }
}
