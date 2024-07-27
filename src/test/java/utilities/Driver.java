package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    //Driver class i WebDriver objesini olusturacagimiz
    //ve gerekli ayarlari yapacagimiz class olacak

    // Hedef Configuration properties den hangi browser secilirse
    //bize o Browser i üretecek bir class olusturmak

    // Driver class inda bize drive robjesini dondurecek getDriver() olusturacagiz


    private Driver() {

    }

    public static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            String istenenBrowser = ConfigReader.getProperty("browser");//firefox

            switch (istenenBrowser) {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        return driver;

    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }

}
