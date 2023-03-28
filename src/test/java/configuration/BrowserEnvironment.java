package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.concurrent.TimeUnit;

public class BrowserEnvironment {
    private EnvironmentProperty environmentProperty;
    public BrowserEnvironment() {
        environmentProperty = EnvironmentProperty.getInstance();
    }

    public WebDriver getDriver() {
        WebDriver driver;
        switch (environmentProperty.getBrowser()) {
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
        driver.manage().timeouts().implicitlyWait(environmentProperty.getEnvironment().waitValue(), TimeUnit.SECONDS);
        driver.get(environmentProperty.getEnvironment().webUrl());
        return driver;
    }
}
