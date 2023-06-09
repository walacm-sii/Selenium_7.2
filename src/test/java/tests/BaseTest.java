package tests;

import configuration.BrowserEnvironment;
import configuration.EnvironmentProperty;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

@Slf4j
public class BaseTest {

    protected WebDriver driver;

    @BeforeAll
    static void setup() {
        EnvironmentProperty.getInstance();
    }

    @BeforeEach
    void setupDriver() {
        driver = new BrowserEnvironment().getDriver();
        log.debug("Driver initialized.");
    }

    @AfterEach
    void teardown() {
        driver.quit();
        log.debug("Driver closed.");
    }
}
