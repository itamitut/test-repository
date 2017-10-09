import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

public class Registration {
    private WebDriver driver;
    protected WebDriverWait wait;
    final Random random = new Random();
    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void test() {
        driver.get("http://localhost/litecard");
        driver.findElement(By.xpath("//a[contains(text(),'New customers click here')]")).click();
//Регистрируем нового клиента, создав случайный email:
        String email = String.valueOf(random.nextInt(1000))+ "@mail.com";
        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Serg");
        driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys("Stepanov");
        driver.findElement(By.cssSelector("input[name=address1]")).sendKeys("345-7 Hills");
        driver.findElement(By.cssSelector("input[name=postcode]")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[name=city]")).sendKeys("Odessa");
        driver.findElement(By.cssSelector("span.select2-selection__rendered")).click();
        driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys("United States", Keys.ENTER);
        Select sel = new Select(driver.findElement(By.cssSelector("select[name=zone_code]")));
        sel.selectByVisibleText("Colorado");
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys("+1567964789");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("1234");
        driver.findElement(By.cssSelector("input[name=confirmed_password]")).sendKeys("1234");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
//Делаем logout и вход:
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("1234");
        driver.findElement(By.cssSelector("button[name=login]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

    }
    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
