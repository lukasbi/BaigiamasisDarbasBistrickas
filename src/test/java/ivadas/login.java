package ivadas;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


import java.time.Duration;


public class login {
    public static WebDriver driver;

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
        driver.quit();
    }

    @Test
    public void LoginUsingRightInfoTest() {


        driver.get("https://pigu.lt/lt/");
        driver.manage().window().setSize(new Dimension(1381, 1030));
        {
            WebElement element = driver.findElement(By.cssSelector(".c-user-menu-item:nth-child(2) > a"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".c-user-menu-item > a > .c-icon--profile")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("pienas1545@protonmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("lukasvcs");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("login")).click();
        String actualUrl = driver.getCurrentUrl();
        String expect = "https://pigu.lt/lt/u/dashboard";

        Assert.assertEquals(actualUrl, expect);
        try {
            Assert.assertEquals(actualUrl, expect);
        } catch (AssertionError e) {
            System.out.println("Test failed");
            throw e;
        }
        System.out.println("Test succeed");




    }
    @Test
    public void LoginUsingWrongInfoTest() {


        driver.get("https://pigu.lt/lt/");
        driver.manage().window().setSize(new Dimension(1381, 1030));
        driver.findElement(By.cssSelector(".c-user-menu-item > a > .c-icon--profile")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("neveikiantisinfo@gmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("123456789");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actual_msg = driver.findElement(By.cssSelector(".error-message:nth-child(2)")).getText();
        String expect="Neteisingi prisijungimo duomenys";
        System.out.println("As expected Error message is:" + actual_msg);
        Assert.assertEquals(actual_msg, expect);
        try {
            Assert.assertEquals(actual_msg, expect);
        } catch (AssertionError e) {
            System.out.println("Test failed");
            throw e;
        }
        System.out.println("Test succeed");

    }
}