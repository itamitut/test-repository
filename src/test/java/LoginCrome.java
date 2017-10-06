import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class LoginCrome {
    private WebDriver driver;
    private WebDriverWait wait;

@Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
 /*   @Before
    public void start(){
     //      ChromeOptions options = new ChromeOptions();
            WebDriver driver = new ChromeDriver();
           wait = new WebDriverWait(driver, 10);
    //      options.addArguments("start-fullscreen");
    //      DesiredCapabilities caps = new DesiredCapabilities();
    //      caps.setCapability("unexpectedAlertBehaviour", "dismiss");
    //      driver = new InternetExplorerDriver();
    //      System.out.println(((HasCapabilities)driver).getCapabilities());

    }    */

@Test
    public void test() {

        driver.get("http://localhost/litecard/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
    //    wait.until(titleIs("webdriver - Поиск в Google"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
    //
        }
    }
@After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
