import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class DuckShop {
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
        //Login admin
        driver.get("http://localhost/litecard/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
        wait.until(titleIs("My Store"));
        //Переходим в первый раздел Appearance:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=appearance&doc=template']")).click();
        wait.until(titleIs("Template | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=appearance&doc=logotype']")).click();
        wait.until(titleIs("Logotype | My Store"));
        //Переходим во второй раздел Catalog:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=catalog&doc=catalog']")).click();
        wait.until(titleIs("Catalog | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=catalog&doc=product_groups']")).click();
        wait.until(titleIs("Product Groups | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=catalog&doc=option_groups']")).click();
        wait.until(titleIs("Option Groups | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=catalog&doc=manufacturers']")).click();
        wait.until(titleIs("Manufacturers | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=catalog&doc=suppliers']")).click();
        wait.until(titleIs("Suppliers | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=catalog&doc=delivery_statuses']")).click();
        wait.until(titleIs("Delivery Statuses | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=catalog&doc=sold_out_statuses']")).click();
        wait.until(titleIs("Sold Out Statuses | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=catalog&doc=quantity_units']")).click();
        wait.until(titleIs("Quantity Units | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=catalog&doc=csv']")).click();
        wait.until(titleIs("CSV Import/Export | My Store"));
        //Переходим в третий раздел Countries:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=countries&doc=countries']")).click();
        wait.until(titleIs("Countries | My Store"));
        //Переходим в четвертый раздел Currencies:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=currencies&doc=currencies']")).click();
        wait.until(titleIs("Currencies | My Store"));
        //Переходим в пятый раздел Customers:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=customers&doc=customers']")).click();
        wait.until(titleIs("Customers | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=customers&doc=csv']")).click();
        wait.until(titleIs("CSV Import/Export | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=customers&doc=newsletter']")).click();
        wait.until(titleIs("Newsletter | My Store"));
        //Переходим в шестой раздел Geo Zones:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=geo_zones&doc=geo_zones']")).click();
        wait.until(titleIs("Geo Zones | My Store"));
        //Переходим в шестой раздел Languages:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=languages&doc=languages']")).click();
        wait.until(titleIs("Languages | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=languages&doc=storage_encoding']")).click();
        wait.until(titleIs("Storage Encoding | My Store"));
        //Переходим в седьмой раздел Job Modules:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=modules&doc=jobs']")).click();
        wait.until(titleIs("Job Modules | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=modules&doc=customer']")).click();
        wait.until(titleIs("Customer Modules | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=modules&doc=shipping']")).click();
        wait.until(titleIs("Shipping Modules | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=modules&doc=payment']")).click();
        wait.until(titleIs("Payment Modules | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=modules&doc=order_total']")).click();
        wait.until(titleIs("Order Total Modules | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=modules&doc=order_success']")).click();
        wait.until(titleIs("Order Success Modules | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=modules&doc=order_action']")).click();
        wait.until(titleIs("Order Action Modules | My Store"));
        //Переходим в восьмой раздел Orders:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=orders&doc=orders']")).click();
        wait.until(titleIs("Orders | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=orders&doc=order_statuses']")).click();
        wait.until(titleIs("Order Statuses | My Store"));
        //Переходим в девятый раздел Pages:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=pages&doc=pages']")).click();
        wait.until(titleIs("Pages | My Store"));
        //Переходим в десятый раздел Report:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=reports&doc=monthly_sales']")).click();
        wait.until(titleIs("Monthly Sales | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=reports&doc=most_sold_products']")).click();
        wait.until(titleIs("Most Sold Products | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=reports&doc=most_shopping_customers']")).click();
        wait.until(titleIs("Most Shopping Customers | My Store"));
        //Переходим в одиннадцатый раздел Settings:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=settings&doc=store_info']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=settings&doc=defaults']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=settings&doc=general']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=settings&doc=listings']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=settings&doc=images']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=settings&doc=checkout']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=settings&doc=advanced']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=settings&doc=security']")).click();
        wait.until(titleIs("Settings | My Store"));
        //Переходим в двенадцатый раздел Slides:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=slides&doc=slides']")).click();
        wait.until(titleIs("Slides | My Store"));
        //Переходим в тринадцатый раздел Tax:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=tax&doc=tax_classes']")).click();
        wait.until(titleIs("Tax Classes | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=tax&doc=tax_rates']")).click();
        wait.until(titleIs("Tax Rates | My Store"));
        //Переходим в четырнадцатый раздел Translations:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=translations&doc=search']")).click();
        wait.until(titleIs("Search Translations | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=translations&doc=scan']")).click();
        wait.until(titleIs("Scan Files For Translations | My Store"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=translations&doc=csv']")).click();
        wait.until(titleIs("CSV Import/Export | My Store"));
        //Переходим в пятнадцатый раздел Users:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=users&doc=users']")).click();
        wait.until(titleIs("Users | My Store"));
        //Переходим в последний раздел vQmods:
        driver.findElement(By.cssSelector("a[href='http://localhost/litecard/admin/?app=vqmods&doc=vqmods']")).click();
        wait.until(titleIs("vQmods | My Store"));
    }
    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
