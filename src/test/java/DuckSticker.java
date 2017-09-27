import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class DuckSticker {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }
    @Test
    public void test() {
        driver.get("http://localhost/litecard");
        wait.until(titleIs("Online Store | My Store"));
//Создаем список "оберток" уточек:
        ArrayList<WebElement> cards = (ArrayList<WebElement>) driver.findElements(By.cssSelector("div.image-wrapper"));
//В каждой обертке проверяем, чтобы у уточки была ровно один стикер:
        for(WebElement card : cards ) {
            if ( (card.findElements(By.cssSelector("div.sticker.new")).size() +
                    card.findElements(By.cssSelector("div.sticker.sale")).size()) != 1) {
                System.err.println("Уточка неправильно одета!");
                System.exit(-1);
            }
        }

}
    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}


