package ivadas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class searchItem {
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
    public void searchItemWithSearchBar()
    {
        driver.get("https://pigu.lt/lt/");
        driver.manage().window().setSize(new Dimension(1381, 1030));
        driver.findElement(By.id("searchInput")).click();
        driver.findElement(By.id("searchInput")).sendKeys("Razer kraken green");
        driver.findElement(By.cssSelector(".c-icon--search")).click();
        driver.findElement(By.cssSelector("#productBlock25618050 .image-wrap img")).click();
        driver.findElement(By.cssSelector("#productBlock25618050 .image-wrap img"));
    }
    @Test
    public void searchItemWithFilter()
    {
        driver.get("https://pigu.lt/lt/");
        driver.manage().window().setSize(new Dimension(1381, 1030));
        driver.findElement(By.cssSelector("#menuBurger > span")).click();
        driver.findElement(By.cssSelector(".h-col--1-of-2:nth-child(2) > .c-categories-list__item:nth-child(3) .c-link--black:nth-child(1) > span")).click();
        driver.findElement(By.cssSelector(".category-list-item-wrap:nth-child(1) img")).click();
        WebElement Element = driver.findElement(By.name("filter_search"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(By.cssSelector("#filter27560 > .filters-block-search > input")).click();

        driver.findElement(By.cssSelector("#filter27560 > .filters-block-search > input")).sendKeys("Razer");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.id("item275601046320"));
        element.click();
    }
}
