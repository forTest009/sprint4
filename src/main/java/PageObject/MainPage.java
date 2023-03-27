package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By accordionHeader = By.xpath("//div[starts-with(@id,'accordion__heading')]");
    private By accordionBody = By.xpath("//div[starts-with(@id,'accordion__panel')]");
    private By btnOrderInHeader = By.xpath("//div[starts-with(@class,'Header')]//button[text()='Заказать']");
    private By btnOrderInBody = By.xpath("//div[starts-with(@class,'Home_FinishButton')]//button[text()='Заказать']");
    private By btnAgreeCookies = By.xpath("//button[text()='да все привыкли']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public String checkTextBodyAccordeon() {
        driver.findElement(accordionBody).getText();
        return checkTextBodyAccordeon();
    }
    public void clickBtnInHeader() {
        driver.findElement(btnOrderInHeader).click();
    }
    public void clickBtnInBody() {
        driver.findElement(btnOrderInBody).click();
    }
    public void clickAgreeCookies() {
        driver.findElement(btnAgreeCookies).click();
    }


}
