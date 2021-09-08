package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps {

    @Step("выбран пункт меню {0}")
    public void selectMenuItem(String menuItem) {
        new MainPage().selectMenuItem(menuItem);
    }

    @Step("выбран вид страхования {0}")
    public void selectMenuInsurance(String menuItem) {
        new MainPage().selectSubMenu(menuItem);
    }

    @Step("закрыто информационное окно")
    public void closeCookieWindow() {
        new MainPage().closeCookie.click();
    }
}
