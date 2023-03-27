package ru.yandex.praktikum;

import PageObject.MainPage;
import PageObject.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Parameterized.class)

public class OrderTestNew {
    private final String nameUser;
    private final String surnameUser;

    private final String adressUser;

    private final String telUser;

    private final String dateOrder;

    private final String commentsUser;
    private final boolean coincidence;
    ;

    public OrderTestNew(String nameUser, String surnameUser, String adressUser, String telUser, String dateOrder, String commentsUser, boolean coincidence) {
        this.nameUser = nameUser;
        this.surnameUser = surnameUser;
        this.adressUser = adressUser;
        this.telUser = telUser;
        this.dateOrder = dateOrder;
        this.commentsUser = commentsUser;
        this.coincidence= coincidence;

    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Имя", "Фамилия", "Адрес", "+79090000000", "22.12.2023","неа", true},
                {"НЕ имя", "Фамилия", "Адрес", "+79090000000", "22.12.2023","неа", true},

        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();

    }
    @Test
    public void newCheckActivityOrderInBody() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAgreeCookies();
        objMainPage.clickBtnInBody();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillFirstStep(nameUser, surnameUser, adressUser, telUser);
        objOrderPage.fillSecondStep(dateOrder, commentsUser);
        driver.quit();
    }
    @Test
    public void newCheckActivityOrderInHeader() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAgreeCookies();
        objMainPage.clickBtnInHeader();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillFirstStep(nameUser, surnameUser, adressUser, telUser);
        objOrderPage.fillSecondStep(dateOrder, commentsUser);
        driver.quit();
    }
}
