import by.itacademy.svetakostyko.web.OnlinerPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OnlinerTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(OnlinerPage.URL);
    }

    @Test
    public void testOpenOnliner() {
        By copyrightBy = By.xpath(OnlinerPage.COPYRIGHT);
        WebElement copyrightElement = driver.findElement(copyrightBy);
        String textOfCopyright = copyrightElement.getText();
        String realText = "© 2001—2023 Onlíner";
        Assert.assertEquals("my error", textOfCopyright, realText);
    }


    @Test
    public void testOpenOnlinerLoginForm() {
        By entranceBy = By.xpath(OnlinerPage.BTN_ENTRANCE);
        WebElement btnEntrance = driver.findElement(entranceBy);
        btnEntrance.click();
        By textOfBtnBy = By.xpath(OnlinerPage.LABEL_ENTRANCE);
        WebElement textOfBtnElement = driver.findElement(textOfBtnBy);
        String textOfBtn = textOfBtnElement.getText();
        String realText = "Вход";
        Assert.assertEquals("Text is wrong", textOfBtn, realText);
    }

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {
        WebElement btnEntrance = driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE));
        btnEntrance.click();
        WebElement elementBtnEntrance = driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE_SECOND));
        elementBtnEntrance.click();
        WebElement elementNik = driver.findElement(By.xpath(OnlinerPage.ERROR_LABEL_NIK));
        WebElement elementPassword = driver.findElement(By.xpath(OnlinerPage.ERROR_LABEL_PASSWORD));
        Assert.assertEquals("Nik text is wrong", elementNik.getText(), "Укажите ник или e-mail");
        Assert.assertEquals("Password text is wrong", elementPassword.getText(), "Укажите пароль");
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }
}
