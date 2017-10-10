import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Cart {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void test() {
        for(int i=1;i<4;i++ ) {
            driver.get("http://localhost/litecard/");
            wait.until(titleIs("Online Store | My Store"));
            driver.findElement(By.cssSelector("div.content li.product")).click();
//Проверяем, есть ли доп опции выбора:
            try {
                Select sel = new Select(this.driver.findElement(By.cssSelector("select")));
                sel.selectByVisibleText("Small");
            } catch (Exception e) {
                System.out.println("У этой уточки нет выбора размера");
            }

            String previousQty = driver.findElement(By.cssSelector("span.quantity")).getText();
            driver.findElement(By.cssSelector(("button[name=add_cart_product]"))).click();
//Ждем, когда количество товара в корзине изменится:
        while(driver.findElement(By.cssSelector("span.quantity")).getText().equals(previousQty)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
        }
    }
// Переходим в корзину и удаляем товар:
        driver.findElement(By.cssSelector("div#cart a.link")).click();
//Ловим кнопки Remove, проверяя в каждом цикле, что товар в корзине еще не закончился:
        while((driver.findElements(By.cssSelector("td.item")).size())!=0) {
            try {
                int itemQty = driver.findElements(By.cssSelector("td.item")).size();
                driver.findElement(By.cssSelector("button[name=remove_cart_item]")).click();
//Проверяем, что строка с товаром исчезла, тем, что число строк изменилось:
                while(driver.findElements(By.cssSelector("td.item")).size() == itemQty){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) { }
                }

            } catch (Exception e) { }
        }
    }
    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}