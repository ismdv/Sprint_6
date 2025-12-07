package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
WebDriver driver;
    //Поля ввода Имени class =  Input_Input__1iN_Z Input_Error__1Tx5d Input_Responsible__1jDKN
    private By nameInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' " +
            "and @placeholder='* Имя']");

    // Поле ввода Фамилии class="Input_Input__1iN_Z Input_Responsible__1jDKN"
    private By secondNameInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' " +
            "and @placeholder='* Фамилия']");

    // Поле ввода адреса class="Input_Input__1iN_Z Input_Responsible__1jDKN"
    private By adress = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' " +
            "and @placeholder='* Адрес: куда привезти заказ']");

    // Станция метро class="select-search__input"
    private By metroStation = By.xpath(".//input[@class='select-search__input']");
//select-search__select

    private By metroSelect = By.xpath(".//div[@class='select-search__select']");
    //Номер телефона class="Input_Input__1iN_Z Input_Error__1Tx5d Input_Responsible__1jDKN"
    private By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка далее class="Button_Button__ra12g Button_Middle__1CSJM"
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'" +
            "and text()='Далее']");
    // Поле ввода даты доставки class="Input_Input__1iN_Z Input_Responsible__1jDKN"
    private By date = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' " +
            "and @placeholder='* Когда привезти самокат']");
    //Дата календаря   1   class="react-datepicker__day react-datepicker__day--001"
    private By dateOneDay = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--001']");
//Дата календаря   1   class="react-datepicker__day react-datepicker__day--001"

//class="Input_Input__1iN_Z Input_Responsible__1jDKN"


// Срок аренды class="Dropdown-placeholder"  клакабельная

    private By duration = By.className("Dropdown-placeholder");
    // Выбор количества ".//div[@class='Dropdown-option'][1]"
    private By durationDay = By.xpath(".//div[@class='Dropdown-option'][1]");
    //Цвет самоката id="black"
    private By color = By.id("black");


    //Кнопка заказать class="Button_Button__ra12g Button_Middle__1CSJM"
    private By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //Кнопка да class="Button_Button__ra12g Button_Middle__1CSJM"
//
    private By yesButton = By.xpath(".//button[text()='Да']");
// Окошко class="Order_ModalHeader__3FDaJ"

    private By orderUppr = By.className("Order_ModalHeader__3FDaJ");


    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void insertName(String name){
        driver.findElement(nameInput).sendKeys(name);
    }
    public void insertSecondName(String secondName){
        driver.findElement(secondNameInput).sendKeys(secondName);
    }

    public void insertAdress(String adressStr){
        driver.findElement(adress).sendKeys(adressStr);
    }

    public void insertMetroStation(String mertoLable){
        driver.findElement(metroStation).sendKeys(mertoLable);

    }
    public void clickMetroStation(){
        driver.findElement(metroSelect).click();

    }

    public void insertPhoneNumber(String phone){
        //driver.findElement(phoneNumber).click();
        driver.findElement(phoneNumber).sendKeys(phone);

    }

    public void clickNextButton(){
        driver.findElement(nextButton).click();

    }

    public void clickDate(){
        driver.findElement(date).click();

    }

    public void insertDate(){
        driver.findElement(dateOneDay).click();

    }
    public void durationClick(){
        driver.findElement(duration).click();

    }public void insertDuration(){
        driver.findElement(durationDay).click();

    }

    public void checkColor(){
        driver.findElement(color).click();

    }
    public void clickOrderButton(){
        driver.findElement(orderButton).click();

    }
    public void clickYes(){
        driver.findElement(yesButton).click();

    }

    public String getTextOrderUppr(){
        return driver.findElement(orderUppr).getText();
    }

public String getStatusFromOrderButton(String name,
                                       String secondName,
                                       String adress,
                                       String metroLable,
                                       String phone){
    insertName(name);
    insertSecondName(secondName);
    insertAdress(adress);
    insertMetroStation(metroLable);
    clickMetroStation();
    insertPhoneNumber(phone);
    clickNextButton();
    clickDate();
    insertDate();
    durationClick();
    insertDuration();
    checkColor();
    clickOrderButton();
    clickYes();
    return  getTextOrderUppr();
}

}
