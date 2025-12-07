
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Assert.*;
import pageobject.MainPage;


import static java.time.Duration.ofSeconds;

public class HomeFaqTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }


    @Test
    public void responseTextMatches() {
        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.clickFaqButton();
        String actual = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        System.out.println(mainPage.getText());
        Assert.assertEquals(actual, mainPage.getText(), "Должно совпадать");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
