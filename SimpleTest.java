import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
//java -Dwebdriver.chrome.driver=D:\Git\Maven-id\chromedriver.exe -jar D:\Git\Maven-id\selenium-server-standalone-3.141.59.jar
public class SimpleTest {
    public RemoteWebDriver driver;
    private static final String SELENIUM_URL = "http://localhost:4444/wd/hub";

    @BeforeTest
    public void start() throws Exception {
        this.driver = new RemoteWebDriver(
                new URL(SELENIUM_URL),
                new ChromeOptions()
        );
    }

    @Test
    public void openGooglePageTest() {
        this.driver.get("https://google.com/");

        try{Thread.sleep(10000);}catch(Exception e){}
    }

    @AfterClass
    public void closeBrowser() {
        this.driver.close();
        this.driver.quit();
    }
}
