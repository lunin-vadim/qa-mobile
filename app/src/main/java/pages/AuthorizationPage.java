
@Getter
@PageEntry(title = "Старница авторизации")
public class AuthorizationPage extends Page {

    @ElementTitle("Кнопка Войти")
    @AndroidFindBy(id = "button")
    @iOSXCUITFindBy(accessibility = "button")
    MobileElement buttonEnter;

    @ElementTitle("Заголовок страницы")
    @AndroidFindBy(id = "title")
    @iOSXCUITFindBy(accessibility = "title")
    MobileElement titlePage;

    @ElementTitle("Поле ввода лагина")
    @AndroidFindBy(id = "loginPlace")
    @iOSXCUITFindBy(accessibility = "loginPlace")
    MobileElement loginInput;

    @ElementTitle("Поле ввода пароля")
    @AndroidFindBy(id = "passwordPlace")
    @iOSXCUITFindBy(accessibility = "passwordPlace")
    MobileElement passwordInput;

    @Step("Тап на кнопку Войти")
    public void clickButtonEnter() {
        buttonEnter.click();
    }

    @Step("Ввод логина")
    public void setLogin(String login) {
        loginInput.sendKeys(login);
    }

    @Step("Ввод пароля")
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Проверка отображения Тайтла")
    public boolean isTitleVisible() {
        return isElementVisible(titlePage, 5);
    }
}
