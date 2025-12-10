import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pageobject.MainPage;
import pageobject.OrderPage;

import java.util.stream.Stream;

import static java.time.Duration.ofSeconds;

public class OrderTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    //тест первой кнопки Закачать
    @ParameterizedTest
    @MethodSource("clientsData")
    public void responseTextMatchesFirstButton(String name,
                                               String secondName,
                                               String adress,
                                               String metroLable,
                                               String phone) {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.open();
        mainPage.clickOrderButton(mainPage.getOrderButtonOne());
        Assert.assertTrue(orderPage.getStatusFromOrderButton(name, secondName, adress, metroLable, phone)
                .contains("Заказ оформлен"));
    }
    //тест второй кнопки Заказать
        @ParameterizedTest
        @MethodSource("clientsData")
        public void responseTextMatchesSecondButton(String name,
                                                    String secondName,
                                                    String adress,
                                                    String metroLable,
                                                    String phone) {
            MainPage mainPage = new MainPage(driver);
            OrderPage orderPage = new OrderPage(driver);
            mainPage.open();
            mainPage.clickOrderButton(mainPage.getOrderButtonTwo());
            Assert.assertTrue(orderPage.getStatusFromOrderButton(name, secondName, adress, metroLable, phone)
                    .contains("Заказ оформлен"));


        }

    private static Stream<Arguments> clientsData() {
        return Stream.of(
                Arguments.of("Игорь", "Петров", "Москва, ул. Мира, 28", "Проспект Мира", "89996663322", true),
                Arguments.of("Анна", "Иванова", "Москва, ул. 2-я Бауманская, 5", "Бауманская", "89996541233", true)
        );
    }

        @AfterEach
        public void tearDown () {
            driver.quit();
        }

    }
