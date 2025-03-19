package driver;

import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.ConfigFileReader;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver webDriver;
    private static DriverType driverType = ConfigFileReader.getBrowserType();
    private static EnvironmentType environmentType = ConfigFileReader.getEnvironmentType();

    private static WebDriver createLocalDriver (){
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--incognito");
                //chromeOptions.addArguments("--headless");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                WebDriverManager.chromedriver().forceDownload().setup();
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                webDriver = new FirefoxDriver(firefoxOptions);
                break;
        }
        //webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        return webDriver;
    }
    public static WebDriver getWebDriver(){
        if (webDriver == null){
            webDriver = createLocalDriver();
        }
        return webDriver;
    }

}
