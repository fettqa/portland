package ru.forma.base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.forma.pages.PageProvider;

import static ru.forma.base.SetUpDriver.initDriver;
import static ru.forma.pages.PageProvider.PAGE;

public abstract class SeleniumBaseTest {

    public static final int DEFAULT_WIDTH = 1920;
    public static final int DEFAULT_HEIGHT = 1000;
    public static final int RESIZE_TIMEOUT = 500;

    public static final Logger log = LoggerFactory.getLogger(SeleniumBaseTest.class);
    protected PageProvider page = PAGE;

    @BeforeMethod
    public static void setupDriver() {
        setupDriver(DriverConfiguration.defaultCapabilities());
        Selenide.open("https://portland.forma.ru/");
    }

    protected static void setupDriver(MutableCapabilities configuration) {
        initDriver(configuration);
        WebDriverRunner.getWebDriver().manage().window().setPosition(new Point(0, 0));
        WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
    }

    @AfterMethod
    protected void stopDriver() {
        WebDriverRunner.getWebDriver().quit();
    }


}
