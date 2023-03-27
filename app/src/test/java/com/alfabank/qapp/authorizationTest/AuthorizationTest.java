package com.alfabank.qapp

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.alfadirect.com.annotations.TestCase;

@Feature("Запуск и авторизация")
@Owner("ErmolchikAV")
class AuthorizationTest extends BaseAuth {

    @Test
    @TestCase(key = "TESTAD-1")
    @Link("Тут ссылка на кейс в джире")
    @Tags({ @Tag("ANDROID"), @Tag("IOS") })
    @Step("Проверка отображения Тайтла на странице авторизации")
    void checkTitleTest (){
        authorizationPage.loadPage();
        assertTrue(AuthorizationPage.isTitleVisible()); // проверка отображения "Вход в Alfa-Test"
    }

    @Test
    @TestCase(key = "TESTAD-2")
    @Link("Тут ссылка на кейс в джире")
    @Tags({ @Tag("ANDROID"), @Tag("IOS") })
    @Step("Авторизация по логину-паролю")
    void authorizationTest () {
        authorizationPage.setLogin(CORRECT_LOGIN);
        authorizationPage.setPassword(CORRECT_PASSWORD);
        authorizationPage.clickButtonEnter;
        assertTrue(MainPage.isNameAccauntVisible()); //Тут проверка на корректность номера счета или имени пользователя или на "Вход в Alfa-Test выполнен"
    }


}