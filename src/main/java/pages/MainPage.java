package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePageObject {


    @FindBy(xpath = "//ul[contains(@class,'kitt-top-menu')]")
    WebElement menuItems;

    @FindBy(xpath = "//div[@class=' kitt-top-menu__column kitt-top-menu__column_3  kitt-top-menu__column_subaction']/ul")
    WebElement subMenu;

    @FindBy(xpath = "//button[text()='Закрыть']")
    public
    WebElement closeCookie;

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String itemName){
        menuItems.findElement(By.xpath("//*[text()='"+itemName+"']")).click();
    }

    public void selectSubMenu(String itemName){
        subMenu.findElement(By.xpath("//a[text()='"+itemName+"']")).click();
    }
}
