import by.itacademy.svetakostyko.web.OnlinerPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OnlinerTest {
    private static WebDriver driver;

    @Before
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(OnlinerPage.URL);
    }

    @Test
    public void testOpenOnliner() {
        WebElement copyrightElement = driver.findElement(By.xpath(OnlinerPage.COPYRIGHT));
        Assert.assertEquals("my error", "© 2001—2023 Onlíner", copyrightElement.getText());
    }


    @Test
    public void testOpenOnlinerLoginForm() throws InterruptedException {
        WebElement btnEntrance = driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE));
        btnEntrance.click();
        WebElement textOfBtnElement = driver.findElement(By.xpath(OnlinerPage.LABEL_ENTRANCE));
        Assert.assertEquals("Text is wrong", "Вход", textOfBtnElement.getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() throws InterruptedException {
        WebElement btnEntrance = driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE));
        btnEntrance.click();
        WebElement elementBtnEntrance = driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE_SECOND));
        elementBtnEntrance.click();
        WebElement elementNik = driver.findElement(By.xpath(OnlinerPage.ERROR_LABEL_NIK));
        WebElement elementPassword = driver.findElement(By.xpath(OnlinerPage.ERROR_LABEL_PASSWORD));
        Assert.assertEquals("Nik text is wrong", "Укажите ник или e-mail", elementNik.getText());
        Assert.assertEquals("Password text is wrong", "Укажите пароль", elementPassword.getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        WebElement btnEntrance = driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE));
        btnEntrance.click();
        WebElement inputNik = driver.findElement(By.xpath(OnlinerPage.INPUT_NIK));
        inputNik.sendKeys("test@gmail.com");
        WebElement elementBtnEntrance = driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE_SECOND));
        elementBtnEntrance.click();
        WebElement elementPassword = driver.findElement(By.xpath(OnlinerPage.ERROR_LABEL_PASSWORD_ONLY));
        Assert.assertEquals("Password text is wrong", "Укажите пароль", elementPassword.getText());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
