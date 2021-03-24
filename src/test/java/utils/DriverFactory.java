package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public class DriverFactory {

    private static final String DRIVER_PATH = "src/test/resources/";
    private static WebDriver driver;
    private static boolean dr;

    public static WebDriver getDriver(Browser browser) {

        File file;

        switch (browser) {
            case CHROME:
                file = new File(DRIVER_PATH + "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;

            case IE:
                file = new File(DRIVER_PATH + "IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                driver = new InternetExplorerDriver();
                break;

            case FIREXOF:
                file = new File(DRIVER_PATH + "geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
                driver = new FirefoxDriver();

            default:
                file = new File(DRIVER_PATH + "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }

    public static WebDriver getDrSettings(DriverSettings dr) {
        switch (dr){
            case TRUE :
                driver.manage().window().maximize();
                break;
            case FALSE :
                driver.manage().window().fullscreen();
        }
        return driver;
    }
}
