package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();

    TravelInsurancePageSteps travelInsuranceSteps = new TravelInsurancePageSteps();

    TravelInsuranceSendFormSteps travelInsuranceSendFormSteps = new TravelInsuranceSendFormSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(String menuName) {
        mainPageSteps.selectMenuItem(menuName);
    }

    @When("^выбран вид страхования \"(.+)\"$")
    public void selectMenuInsurance(String menuName) {
        mainPageSteps.selectMenuInsurance(menuName);
    }

    @When("^закрыто информационное окно$")
    public void closeCookieWindow() {
        mainPageSteps.closeCookieWindow();
    }

    @Then("^заголовок страницы - Страхование путешественников равен \"(.+)\"$")
    public void checkTitleDMSPage(String title) {
        travelInsuranceSteps.checkPageTitle(title);
    }

    @When("^выполнено нажатие на кнопку \"(.+)\"$")
    public void clickBtnSendApp(String name) {
        travelInsuranceSteps.clickButton(name);
    }

    @Then("^заголовок страницы - Заявка на Страхование путешественников равен \"(.+)\"$")
    public void checkTitleSendAppPage(String title) {
        travelInsuranceSendFormSteps.checkPageTitle(title);
    }

    @When("^выбрана сумма страховой защиты – Минимальная$")
    public void selectMinimal() {
        travelInsuranceSendFormSteps.selectMinimal();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> travelInsuranceSendFormSteps.fillField(field, value));
    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> travelInsuranceSendFormSteps.checkFillField(field, value));
    }

    @Then("^присутствует сообщение об ошибке \"(.+)\"$")
    public void checkErrorMessage(String errorMessage) {
        travelInsuranceSendFormSteps.checkErrorMessage(errorMessage);
    }

    @Then("^в полях присутствуют сообщения об ошибке:$")
    public void checkFieldsErrorMessage(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, errorMessage) -> {
                    travelInsuranceSendFormSteps.checkFieldErrorMessage(field, errorMessage);
                });
    }

    @When("^выбран пол \"(.+)\"$")
    public void selectGender(String sex) {
        travelInsuranceSendFormSteps.selectGender(sex);
    }
}
