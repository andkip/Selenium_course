import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.MainPageSteps;
import steps.TravelInsurancePageSteps;
import steps.TravelInsuranceSendFormSteps;

import java.util.HashMap;

public class InsuranseTest extends BaseSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    TravelInsurancePageSteps travelInsurancePageSteps = new TravelInsurancePageSteps();
    TravelInsuranceSendFormSteps travelInsuranceSendFormSteps = new TravelInsuranceSendFormSteps();

    HashMap<String, String> testData = new HashMap<>();

    @Title("Заявка на Страхование путешественников")
    @Test
    public void InsuranseTest() {

        //тестовые данные
        testData.put("Фамилия застрахованного", "Ванко");
        testData.put("Имя застрахованного", "Иван");
        testData.put("Дата рождения застрахованного", "01.01.1990");
        testData.put("Фамилия страхователя", "Петров");
        testData.put("Имя страхователя", "Петр");
        testData.put("Отчество страхователя", "Петрович");
        testData.put("Дата рождения страхователя", "01.01.1990");
        testData.put("Серия паспорта", "1234");
        testData.put("Номер паспорта", "567890");
        testData.put("Дата выдачи", "01.01.2011");
        testData.put("Кем выдан", "УФМС");

        mainPageSteps.selectMenuItem("Страхование");
        mainPageSteps.selectMenuInsurance("Путешествия");
        mainPageSteps.closeCookieWindow();
        travelInsurancePageSteps.checkPageTitle("Страхование путешественников");

        travelInsurancePageSteps.clickButton("Оформить онлайн");
        travelInsuranceSendFormSteps.checkPageTitle("Страхование путешественников");
        travelInsuranceSendFormSteps.selectMinimal();

        travelInsurancePageSteps.clickButton("Оформить");
        travelInsuranceSendFormSteps.fillFields(testData);
        travelInsuranceSendFormSteps.selectGender("Мужской");
        travelInsuranceSendFormSteps.checkFillFields(testData);
        travelInsurancePageSteps.clickButton("Продолжить");
        travelInsuranceSendFormSteps.checkErrorMessage("При заполнении данных произошла ошибка");
        travelInsuranceSendFormSteps.checkFieldErrorMessage("Мобильный телефон", "Поле не заполнено");
        travelInsuranceSendFormSteps.checkFieldErrorMessage("Электронная почта", "Поле не заполнено");
        travelInsuranceSendFormSteps.checkFieldErrorMessage("Повтор электронной почты", "Поле не заполнено");

    }

}
