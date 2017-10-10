import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class AddNewProduct {
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

//Переходим в раздел Catalog:
        driver.findElement(By.xpath("//span[contains(text(),'Catalog')]")).click();
        wait.until(titleIs("Catalog | My Store"));
        driver.findElement(By.xpath("//a[contains(text(),' Add New Category')]")).click();
        wait.until(titleIs("Add New Category | My Store"));
        WebElement enable = driver.findElement(By.xpath("//label[contains(text(),' Enabled')]"));
        if(enable.getAttribute("checked")== null )
            enable.click();
        driver.findElement(By.name("name[en]")).sendKeys("Nasty Duck");
        driver.findElement(By.cssSelector("input[name=code]")).sendKeys("pp007");
  //      driver.findElements(By.cssSelector("input[type='checkbox']")).get(1).click();
//*[@id="tab-general"]/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td[1]/input
 //       driver.findElements(By.cssSelector("input[name='product_groups[]']")).get(1).click();
        driver.findElement(By.cssSelector("input[name=quantity]"));
 //       driver.findElement(By.cssSelector("input[name=quantity]")).sendKeys("10");

    }
    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}