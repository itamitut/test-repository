import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class CheckDuck {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void test() {
//открываем магазин:
    driver.get("http://localhost/litecard/");
    wait.until(titleIs("Online Store | My Store"));
//Ищем первую уточку в разделе Campaigns:
    WebElement duck = driver.findElement(By.cssSelector("div#box-campaigns a.link"));
//Считываем название и цены:
    String name1 = duck.findElement(By.cssSelector("div.name")).getAttribute("innerText");
    String regularPrice1 = duck.findElement(By.cssSelector("s.regular-price")).getAttribute("innerText");
    String campaignPrice1 = duck.findElement(By.cssSelector("strong.campaign-price")).getAttribute("innerText");
    System.out.println(name1);
    System.out.println(regularPrice1);
    System.out.println(campaignPrice1);
//Проверяем, что у регулярной цены размер меньше, чем скидочной:
    if( Integer.parseInt(duck.findElement(By.cssSelector("strong.campaign-price")).getAttribute("offsetHeight"))>
     Integer.parseInt(duck.findElement(By.cssSelector("s.regular-price")).getAttribute("offsetHeight")) )
     System.out.println("Размер ОК");
//Проверяем, что у регулярной цены серый цвет:
        String color = duck.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        String R = color.substring(5,8);String G = color.substring(10,13); String B = color.substring(15,18);
        if(R.equals(G)&&R.equals(B))
            System.out.println("Цвет серый");
//Проверяем, что у регулярной цены зачеркнутый шрифт:
        if(duck.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration")
                .contains("line-through"))
            System.out.println("Шрифт зачеркнутый");
//

    //    for (int i = 1; i < list.size(); i++) {
    //        if (list.get(i).getAttribute("innerText").compareTo(list.get(i - 1).getAttribute("innerText")) < 0) {
     //           System.err.println("Ошибка в порядке стран");
     //           System.exit(-1);substring(0,12).equals
    }
    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}