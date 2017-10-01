import com.google.common.collect.ImmutableMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Fox {
    private  WebDriver driver;
    private  WebDriverWait wait;

    @Before
    public void start() {
        FirefoxOptions options = (new FirefoxOptions())
                .setBinary("c:/Program Files/Mozilla Firefox/firefox.exe")
                .addPreference("browser.cache.disk.enable", false)
                .addCapabilities(new DesiredCapabilities(ImmutableMap.of("pageLoadStrategy", "eager")));
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver", Keys.ENTER);
        wait.until(titleIs("webdriver - Поиск в Google"));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
