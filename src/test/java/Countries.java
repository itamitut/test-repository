import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

    public class Countries {
        private WebDriver driver;
        private WebDriverWait wait;
@Before
        public void start(){
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
        }
@Test
    public void test() {
//Логинимся в admin:
    driver.get("http://localhost/litecard/admin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).sendKeys(Keys.ENTER);

//Переходим в третий раздел Countries:
    driver.findElement(By.xpath("//span[contains(text(),'Countries')]")).click();
    wait.until(titleIs("Countries | My Store"));
    WebElement form = driver.findElement(By.cssSelector("form[name='countries_form']"));
//Создаем список элементов, содержащих названия стран в качестве аттрибута
    ArrayList<WebElement> list = (ArrayList) form.findElements(By.cssSelector("a:not([title='Edit'])"));
//Проверяем, что они идут в алфавитном порядке методом compareTo текущей страны и предыдущей:
    for (int i = 1; i < list.size(); i++) {
        if (list.get(i).getAttribute("innerText").compareTo(list.get(i - 1).getAttribute("innerText")) < 0) {
            System.err.println("Ошибка в порядке стран");
            System.exit(-1);
        }
    }
//Проверяем зоны у стран
    for (int i = 0; i < list.size(); i++) {
        form = driver.findElement(By.cssSelector("form[name='countries_form']"));
        list = (ArrayList) form.findElements(By.cssSelector("a:not([title='Edit'])"));
        list.get(i).click();
        wait.until(titleIs("Edit Country | My Store"));
        ArrayList<WebElement> zones = (ArrayList) driver
                .findElements(By.cssSelector("table#table-zones tr td:nth-child(3) input"));
//Если зоны имеются, проверяем, что они идут в алфавитном порядке методом compareTo:
        if (zones.size() > 1) {
            zones.remove(zones.size() - 1);
            for (int m = 1; m < zones.size(); m++) {
                if (zones.get(m).getAttribute("value").compareTo(zones.get(m - 1).getAttribute("value")) < 0)
                {
                    System.err.println("Ошибка в порядке зон");
                    System.exit(-1);
                }
            }
        }
//Возвращаемся на страницу Countries:
        driver.navigate().back();
        wait.until(titleIs("Countries | My Store"));
    }
}
        @After
        public void stop(){
            driver.quit();
            driver = null;
        }
    }