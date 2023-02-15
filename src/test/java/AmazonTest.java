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
        WebElement emptyCard = driver.findElement(By.xpath(AmazonPage.LABEL_CARD_IS_EMPTY));
        Assert.assertEquals("my error", "Your Amazon Cart is empty", emptyCard.getText());
    }

    @Test
    public void testOpenAmazonLoginForm() {
        WebElement cartElement = driver.findElement(By.xpath(AmazonPage.CART));
        cartElement.click();
        WebElement btnSignIn = driver.findElement(By.xpath(AmazonPage.SIGH_IN_BTN));
        btnSignIn.click();
        WebElement textOfSign = driver.findElement(By.xpath(AmazonPage.SIGN_IN_LABEL));
        Assert.assertEquals("Another text", "Sign in", textOfSign.getText());
    }

    @Test
    public void testAmazonLoginFormWithEmptyCredentials() {
        WebElement cartElement = driver.findElement(By.xpath(AmazonPage.CART));
        cartElement.click();
        WebElement btnSignIn = driver.findElement(By.xpath(AmazonPage.SIGH_IN_BTN));
        btnSignIn.click();
        WebElement continueBtnElement = driver.findElement(By.xpath(AmazonPage.CONTINUE_BTN));
        continueBtnElement.click();
        WebElement alertTextElement = driver.findElement(By.xpath(AmazonPage.ERROR_TEXT));
        Assert.assertEquals("Not this text", alertTextElement.getText(), "Enter your email or mobile phone number");
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
