import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class CheckDuck {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start(){
          driver = new ChromeDriver();
//        driver = new InternetExplorerDriver();
//        driver = new FirefoxDriver();
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
    String regularPrice1 = duck.findElement(By.cssSelector(".regular-price")).getAttribute("innerText");
    String campaignPrice1 = duck.findElement(By.cssSelector(".campaign-price")).getAttribute("innerText");

//Проверяем, что у регулярной цены размер меньше, чем скидочной:
    if(!( Integer.parseInt(duck.findElement(By.cssSelector(".campaign-price"))
                .getAttribute("offsetHeight"))>
     Integer.parseInt(duck.findElement(By.cssSelector(".regular-price"))
             .getAttribute("offsetHeight"))) ) {
        System.out.println("Размеры неправильные!");
        System.exit(-1);
    }
//Проверяем, что у регулярной цены серый цвет:
        String color1 = duck.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        System.out.println(color1);
    //Разбираем полученнуюстроку на цвета RGB и сравниваем их:
        String[] colors1 =  color1.substring(5,color1.length()- 1 ).split(", ");
        String R1 = colors1[0]; String G1 = colors1[1]; String B1 = colors1[2];
        if(!(R1.equals(G1)&&R1.equals(B1))){
            System.out.println("Цвет не серый");
            System.exit(-1); }
//Проверяем, что у регулярной цены зачеркнутый шрифт:
        if(!(duck.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration")
                .contains("line-through"))) {
            System.err.println("Шрифт не зачеркнутый");
            System.exit(-1);}
//Проверяем, что у скидочной цены красный цвет:
        String color2 = duck.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        String[] colors2 =  color2.substring(5,color2.length()- 1 ).split(", ");
        String G2 = colors2[1]; String B2 = colors2[2];
        if(!(G2.equals("0")&&B2.equals("0"))) {
            System.err.println("Цвет не красный");
            System.exit(-1); }
//Проверяем, что у скидочной цены жирный шрифт:
        if(!(duck.findElement(By.cssSelector(".campaign-price"))
                .getCssValue("font-weight").equals("bold"))) {
            System.err.println("Шрифт не жирный!");
            System.exit(-1); }
//Переходим на страницу товара:
        duck.click();
        String regularPrice2 = driver.findElement(By.cssSelector(".regular-price"))
                .getAttribute("innerText");
        String campaignPrice2 = driver.findElement(By.cssSelector(".campaign-price"))
                .getAttribute("innerText");
        //Сравниваем имена:
        String name2 = driver.findElement(By.cssSelector("h1.title")).getAttribute("innerText");
        if(!(name2.equals(name1))){
            System.err.println("Имена различаются!");
            System.exit(-1);}
//Проверяем цены попарно:
        if(!(regularPrice2.equals(regularPrice1))&&(campaignPrice2.equals(campaignPrice1))){
            System.err.println("Цены различаются!");
            System.exit(-1);}
//Проверяем, что у регулярной цены размер меньше, чем скидочной:
        if(!( Integer.parseInt(driver.findElement(By.cssSelector(".campaign-price"))
                .getAttribute("offsetHeight"))>
                Integer.parseInt(driver.findElement(By.cssSelector(".regular-price"))
                        .getAttribute("offsetHeight"))) ) {
            System.out.println("Размеры неправильные!");
            System.exit(-1);}
//Проверяем, что у регулярной цены серый цвет:
        String color3 = driver.findElement(By.cssSelector(".regular-price")).getCssValue("color");
//Разбираем полученнуюстроку на цвета RGB и сравниваем их:
        String[] colors3 =  color3.substring(5,color1.length()- 1 ).split(", ");
        String R3 = colors3[0]; String G3 = colors3[1]; String B3 = colors3[2];
        if(!(R3.equals(G3)&&R3.equals(B3))){
            System.out.println("Цвет не серый");
            System.exit(-1); }
//Проверяем, что у регулярной цены зачеркнутый шрифт:
        if(!(driver.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration").contains("line-through"))) {
            System.err.println("Шрифт не зачеркнутый");
            System.exit(-1);}
//Проверяем, что у скидочной цены красный цвет:
        String color4 = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        String[] colors4 =  color4.substring(5,color2.length()- 1 ).split(", ");
        String G4 = colors4[1]; String B4 = colors4[2];
        if(!(G4.equals("0")&&B4.equals("0"))) {
            System.err.println("Цвет не красный");
            System.exit(-1); }
//Проверяем, что у скидочной цены жирный шрифт:
        if(!(driver.findElement(By.cssSelector(".campaign-price"))
                .getCssValue("font-weight").equals("bold"))) {
            System.err.println("Шрифт не жирный!");
            System.exit(-1); }


        }
    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}