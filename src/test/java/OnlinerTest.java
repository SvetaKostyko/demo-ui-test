import by.itacademy.svetakostyko.web.OnlinerPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OnlinerTest {
    WebDriver driver;

    @Before
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(OnlinerPage.URL);
    }

    @Test
    public void testOpenOnliner() {
        Assert.assertEquals("my error", "© 2001—2023 Onlíner", driver.findElement(By.xpath(OnlinerPage.COPYRIGHT)).getText());
    }


    @Test
    public void testOpenOnlinerLoginForm() {
        driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE)).click();
        Assert.assertEquals("Text is wrong", "Вход", driver.findElement(By.xpath(OnlinerPage.LABEL_ENTRANCE)).getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {
        driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE)).click();
        driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE_SECOND)).click();
        Assert.assertEquals("Nik text is wrong", "Укажите ник или e-mail", driver.findElement(By.xpath(OnlinerPage.ERROR_LABEL_NIK)).getText());
        Assert.assertEquals("Password text is wrong", "Укажите пароль", driver.findElement(By.xpath(OnlinerPage.ERROR_LABEL_PASSWORD)).getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE)).click();
        driver.findElement(By.xpath(OnlinerPage.INPUT_NIK)).sendKeys("test@gmail.com");
        driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE_SECOND)).click();
        Assert.assertEquals("Password text is wrong", "Укажите пароль", driver.findElement(By.xpath(OnlinerPage.ERROR_LABEL_PASSWORD_ONLY)).getText());
    }

    @Test
    public void testOnlinerLoginWithPasswordOnly() {
        driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE)).click();
        driver.findElement(By.xpath(OnlinerPage.INPUT_PASSWORD)).sendKeys("testOnliner");
        driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE_SECOND)).click();
        Assert.assertEquals("Nik text is wrong", "Укажите ник или e-mail", driver.findElement(By.xpath(OnlinerPage.ERROR_LABEL_NIK)).getText());

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
