package ru.forma.base;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetUpDriver {
    public static final Logger log = LoggerFactory.getLogger(SetUpDriver.class);

    public static WebDriver initDriver(MutableCapabilities capabilities) {
        log.debug("setting capabilities");
        capabilities.asMap().forEach((k, v) -> log.debug(String.format("%s->%s", k, v)));
        WebDriver driver = createDriver(capabilities);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                driver.quit();
            } catch (NoSuchSessionException e){
                throw new RuntimeException("Error closing the web driver when shut down hook", e);
            }
        }));
        WebDriverRunner.setWebDriver(driver);
        log.info("Web driver has been initiated " + driver.getClass().getName());
        return driver;
    }

    public static WebDriver createDriver(MutableCapabilities capabilities) {
        ChromeOptions options = new ChromeOptions().merge(capabilities).addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
