package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.concurrent.TimeUnit;

public class BrowserEnvironment {
    private final String BROWSER_PROPERTY_KEY = "browser name";
    private final String WAIT_VALUE_KEY = "wait";

    private final String URL_KEY = "web url";
    public BrowserEnvironment() {
        EnvironmentProperty.getInstance();
    }

    public WebDriver getDriver() {
        WebDriver driver;
        switch (System.getProperty(BROWSER_PROPERTY_KEY)) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                break;
            default:
                InternetExplorerOptions optionsDefault = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(optionsDefault);
        }
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty(WAIT_VALUE_KEY)), TimeUnit.SECONDS);
        driver.get(System.getProperty(URL_KEY));
        return driver;
    }
}
