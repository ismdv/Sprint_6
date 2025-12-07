package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.lang.model.element.Element;

public class MainPage {

    private String url = "https://qa-scooter.praktikum-services.ru/";

    private WebDriver driver;

    // Кнопка раскрытия вопроса class="accordion__button" с текстом вопроса

    private By faqButton = By.xpath(".//div[@class='accordion__heading'][1]");

    // Область ответа <p>   class='accordion__panel
    private By answerArea = By.xpath(".//div[@aria-labelledby='accordion__heading-0']/p");

    //Кнопка заказать вверху страницы  class ='Button_Button__ra12g'
    private By orderButtonOne = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']");

    //Кнопка заказать в низу страицы class="Button_Button__ra12g Button_Middle__1CSJM"
    private By orderButtonTwo = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void clickFaqButton() {
        WebElement element = driver.findElement(faqButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void clickOrderButton(By orderButton) {
        WebElement element = driver.findElement(orderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public String getText() {
        return driver.findElement(answerArea).getText();
    }



    public By getOrderButtonOne() {
        return orderButtonOne;
    }

    public By getOrderButtonTwo() {
        return orderButtonTwo;
    }
}
