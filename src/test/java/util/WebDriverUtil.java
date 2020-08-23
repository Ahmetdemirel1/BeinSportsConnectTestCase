package util;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class WebDriverUtil {

    private static WebDriverUtil instance;

    private WebDriver webdriver;
    private Logger log = Logger.getLogger(WebDriverUtil.class);


    private WebDriverUtil() { }


    private DesiredCapabilities capabilities;
    private ChromeOptions options;

    private void chromeOptions(){
        options = new ChromeOptions();
        capabilities = DesiredCapabilities.chrome();
        options.addArguments("test-type");
        options.addArguments("disable-popup-blocking");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-translate");
        options.addArguments("--start-maximized");
        options.addArguments("disable-automatic-password-saving");
        options.addArguments("allow-silent-push");
        options.addArguments("disable-infobars");
        options.addArguments("--kiosk");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.getCurrent());

    }

    public static WebDriverUtil getInstance(){
        if(instance == null)
            instance = new WebDriverUtil();
        return instance;
    }

    public void startTheTest(){
        chromeOptions();
        System.setProperty("webdriver.chrome.verboseLogging", "false");
        selectPath(capabilities.getPlatform());
        System.setProperty("webdriver.chrome.silentOutput", "true");
        webdriver = new ChromeDriver(options);
        webDriverManageSettings();

    }

    private void webDriverManageSettings(){
        webdriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();

    }

    protected void selectPath( Platform platform ) {
        String browser;
        if ("CHROME".equalsIgnoreCase(capabilities.getBrowserName())) {
            browser = "webdriver.chrome.driver";
            switch (platform) {
                case MAC:
                    System.setProperty(browser, "driver/chromedrivermac");
                    break;
                case WIN10:
                case WIN8:
                case WIN8_1:
                case WINDOWS:
                    System.setProperty(browser, "driver/chromedriverwin.exe");
                    break;
                case LINUX:
                    System.setProperty(browser, "driver/chromedriverlinux64.exe");
                    break;
                default:
                    log.info("PLATFORM DOES NOT EXISTS");
                    break;
            }
        }

    }

    public WebDriver getWebDriver(){
        if(webdriver == null){
            String errorMessage = "Driver null durumda!";
            log.error(errorMessage);
            Assert.fail(errorMessage);
        }
        return webdriver;
    }

}
