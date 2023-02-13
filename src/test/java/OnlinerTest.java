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
        System.out.println(copyrightElement.getText());
        driver.quit();
    }



}
