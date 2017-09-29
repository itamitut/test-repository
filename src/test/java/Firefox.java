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

public class Firefox {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void start(){
        FirefoxOptions options = new FirefoxOptions()
                .setBinary("c:/Program Files/Mozilla Firefox/firefox.exe")
        //        .addArguments("-console")
                .addPreference("browser.cache.disk.enable", false)
                .addCapabilities(new DesiredCapabilities(ImmutableMap.of("pageLoadStrategy", "eager")));
        WebDriver driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test() {
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver", Keys.ENTER);
        wait.until(titleIs("webdriver - Поиск в Google"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}