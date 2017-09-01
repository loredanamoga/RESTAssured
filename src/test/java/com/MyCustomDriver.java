package com;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.HashMap;


/**
 * Created by loredanamoga on 8/24/2017.
 */
public class MyCustomDriver implements DriverSource {
    @Override
    public WebDriver newDriver() {

        String downLoadDirectory = "E:/";

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downLoadDirectory);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);

      return new ChromeDriver(cap);
    }
//
//    @Override
//    public WebDriver newDriver() {
//        try {
//            DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
//            // Add
//            return new ChromeDriver(ChromeDriverService.createDefaultService(), capabilities);
//        }
//        catch (Exception e) {
//            throw new Error(e);
//        }
//    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }
}
