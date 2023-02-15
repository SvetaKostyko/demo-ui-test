import by.itacademy.svetakostyko.web.AmazonPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonTest {
    private static WebDriver driver;

    @Before
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(AmazonPage.URL);
    }

    @Test
    public void testOpenAmazon() {
        WebElement copyright = driver.findElement(By.xpath(AmazonPage.COPYRIGHT));
        Assert.assertEquals("Text is wrong", "© 1996-2023, Amazon.com, Inc. or its affiliates", copyright.getText());
    }
    @Test
    public void testOpenAmazonCart() {
        WebElement cartElement = driver.findElement(By.xpath(AmazonPage.CART));
        cartElement.click();


    }




    @After
    public void closeBrowser() {
        driver.quit();
    }


}
