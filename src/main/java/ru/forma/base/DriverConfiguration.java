package ru.forma.base;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class DriverConfiguration {


    public static MutableCapabilities defaultCapabilities(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "chrome");
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability("browserVersion","118.0");
        caps.setCapability("binary","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        return caps;
    }

}
