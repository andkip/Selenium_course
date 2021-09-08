package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class TravelInsurancePage extends BasePageObject {

    @FindBy(xpath = "//h1[contains(@class,'kitt-heading  page-teaser-dict__header kitt-heading_size_l')]")
    public WebElement title;

    public TravelInsurancePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        (new WebDriverWait(BaseSteps.getDriver(), 10))
                .until(ExpectedConditions.visibilityOf(title));
    }
}
