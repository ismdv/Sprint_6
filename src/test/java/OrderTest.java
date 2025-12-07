import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pageobject.MainPage;
import pageobject.OrderPage;

import static java.time.Duration.ofSeconds;

public class OrderTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    //тест первой кнопки Закачать
    @Test
    public void responseTextMatchesFirstButton() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.open();
        mainPage.clickOrderButton(mainPage.getOrderButtonOne());
        Assert.assertTrue(orderPage.getStatusFromOrderButton().contains("Заказ оформлен"));
    }
    //тест второй кнопки Заказать
        @Test
        public void responseTextMatchesSecondButton() {
            MainPage mainPage = new MainPage(driver);
            OrderPage orderPage = new OrderPage(driver);
            mainPage.open();
            mainPage.clickOrderButton(mainPage.getOrderButtonTwo());
            Assert.assertTrue(orderPage.getStatusFromOrderButton().contains("Заказ оформлен"));


        }

        @AfterEach
        public void tearDown () {
            driver.quit();
        }

    }
