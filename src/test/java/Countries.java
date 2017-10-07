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

//Задание 9, Часть 1
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
        form = driver.findElement(By.cssSelector("form[name='countries_form']"));
        list = (ArrayList) form.findElements(By.cssSelector("a:not([title='Edit'])"));

//Для стран, у которых кол-во зон отлично от 0, проверяем порядок зон:
    for (int i = 0; i < list.size(); i++) {
        form = driver.findElement(By.cssSelector("form[name='countries_form']"));
        ArrayList<WebElement> numberZones = (ArrayList) form
                .findElements(By.cssSelector("tr.row td:nth-child(6)"));
        if (!numberZones.get(i).getText().equals("0")) {
        list = (ArrayList) form.findElements(By.cssSelector("a:not([title='Edit'])"));
        list.get(i).click();
        wait.until(titleIs("Edit Country | My Store"));
        ArrayList<WebElement> zones = (ArrayList) driver
             .findElements(By.cssSelector("table#table-zones tr td:nth-child(3) input"));
            zones.remove(zones.size()-1);
        //проверяем, что они идут в алфавитном порядке методом compareTo:
            for (int m = 1; m < zones.size(); m++) {
                if (zones.get(m).getAttribute("value").compareTo(zones.get(m - 1)
                        .getAttribute("value")) < 0)
                {
                    System.err.println("Ошибка в порядке зон");
                    System.exit(-1);
                }
            }
//Возвращаемся на страницу Countries:
            driver.navigate().back();
            wait.until(titleIs("Countries | My Store"));
        }
    }

//Задание 9, Часть 2
//Проверяем раздел зоны у стран:

    driver.findElement(By.xpath("//span[contains(text(),'Geo Zones')]")).click();
    wait.until(titleIs("Geo Zones | My Store"));
//Создаем список стран, имеющих зоны:
    ArrayList<WebElement> countriesWithZones = (ArrayList) driver.findElements(By.cssSelector("td#content tr.row a:not([title='Edit']"));
    for (int i=0; i<countriesWithZones.size(); i++) {
        countriesWithZones = (ArrayList) driver.findElements(By.cssSelector("td#content tr.row a:not([title='Edit']"));
        countriesWithZones.get(i).click();
        ArrayList<WebElement> zones = (ArrayList) driver.findElements(By.cssSelector("table#table-zones tr td:nth-child(3) select option[selected='selected']"));
//Проверяем, что зоны идут в алфавитном порядке методом compareTo текущей страны и предыдущей:
        for (int n = 1; n < zones.size(); n++) {
            if (zones.get(n).getAttribute("innerText").compareTo(zones.get(n - 1).getAttribute("innerText")) < 0) {
                System.err.println("Ошибка в порядке зон");
                System.exit(-1);
            }
        }
        driver.navigate().back();
    }
}
        @After
        public void stop(){
            driver.quit();
            driver = null;
        }
    }