import by.itacademy.svetakostyko.web.OnlinerPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlinerTest {
    @Test
    public void testOpenOnliner() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        By copyrightBy = By.xpath(OnlinerPage.COPYRIGHT);
        WebElement copyrightElement = driver.findElement(copyrightBy);
        String textOfCopyright = copyrightElement.getText();
        String realText = "© 2001—2023 Onlíner";
        if (realText.equals(textOfCopyright)) {
            System.out.println("Text is the same");
        } else {
            System.out.println("Text is wrong");
        }
        driver.quit();
    }

    @Test
    public void testOpenOnlinerLoginForm() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        By entranceBy = By.xpath(OnlinerPage.BTN_ENTRANCE);
        WebElement btnEntrance = driver.findElement(entranceBy);
        btnEntrance.click();
        By textOfBtnBy = By.xpath(OnlinerPage.LABEL_ENTRANCE);
        WebElement textOfBtnElement = driver.findElement(textOfBtnBy);
        String textOfBtn = textOfBtnElement.getText();
        String realText = "Вход";
        if (realText.equals(textOfBtn)) {
            System.out.println("Text is the same");
        } else {
            System.out.println("Text is wrong");
        }
        driver.quit();
    }
}
