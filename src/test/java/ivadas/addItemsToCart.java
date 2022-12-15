package ivadas;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;



import java.time.Duration;


public class addItemsToCart {
    public WebDriver driver;

    JavascriptExecutor js;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);

        js = (JavascriptExecutor) driver;

    }

    @After
    public void tearDown() {
        // driver.quit();
    }

    @Test
    public void addItemsToCart1() {
        driver.get("https://pigu.lt/lt/kvepalai-kosmetika/kvepalai/namu-kvapai-old/namu-kvapo-papildymas-acappella-juodoji-orchideja-500?id=41644553&feat=home&navigation_source=interactionStudio");
        driver.manage().window().setSize(new Dimension(1381, 1030));
        WebElement Element = driver.findElement(By.cssSelector(".btn-big-icon-inline:nth-child(2)"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        WebElement button = driver.findElement(By.linkText("Į krepšelį"));
        button.click();
    }
}