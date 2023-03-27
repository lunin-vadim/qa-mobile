package com.alfabank.qapp

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.alfadirect.com.annotations.TestCase;

@Feature("Авторизация с невалидными Паролями и Логинами")
@Owner("ErmolchikAV")
class AuthorizationWrongTest extends BaseAuth{

    @Test
    @TestCase(key = "TESTAD-4")
    @Link("Тут ссылка на кейс в джире")
    @Tags({ @Tag("ANDROID"), @Tag("IOS") })
    @Step("Авторизация без логина")
    void authorizationTest () {
        authorizationPage.setLogin();
        authorizationPage.setPassword(CORRECT_PASSWORD);
        authorizationPage.clickButtonEnter;
        assertTrue(authorizationPage.isLoginAllertVisible());
    }

    @Test
    @TestCase(key = "TESTAD-5")
    @Link("Тут ссылка на кейс в джире")
    @Tags({ @Tag("ANDROID"), @Tag("IOS") })
    @Step("Авторизация без пароля")
    void authorizationTest () {
        authorizationPage.setLogin(CORRECT_LOGIN);
        authorizationPage.setPassword();
        authorizationPage.clickButtonEnter;
        assertTrue(authorizationPage.isPasswordAllertVisible());
    }

    @Test
    @TestCase(key = "TESTAD-6")
    @Link("Тут ссылка на кейс в джире")
    @Tags({ @Tag("ANDROID"), @Tag("IOS") })
    @Step("Авторизация c не верным паролем")
    void authorizationTest () {
        authorizationPage.setLogin(CORRECT_LOGIN);
        authorizationPage.setPassword(WRONG_PASSWORD);
        authorizationPage.clickButtonEnter;
        assertTrue(authorizationPage.isPasswordAllertVisible());
    }

    @Test
    @TestCase(key = "TESTAD-7")
    @Link("Тут ссылка на кейс в джире")
    @Tags({ @Tag("ANDROID"), @Tag("IOS") })
    @Step("Авторизация c избыточно длинным паролем")
    void authorizationTest () {
        authorizationPage.setLogin(CORRECT_LOGIN);
        authorizationPage.setPassword(LONG_WRONG_PASSWORD);
        authorizationPage.clickButtonEnter;
        assertTrue(authorizationPage.isPasswordAllertVisible()); // Здесь подразумавается проверка на ExceptValue.
    }

    @Test
    @TestCase(key = "TESTAD-8")
    @Link("Тут ссылка на кейс в джире")
    @Tags({ @Tag("ANDROID"), @Tag("IOS") })
    @Step("Авторизация с недопустимыми символами в пароле")
    void authorizationTest () {
        authorizationPage.setLogin(CORRECT_LOGIN);
        authorizationPage.setPassword(WRONG_SYMBOL_PASSWORD);
        authorizationPage.clickButtonEnter;
        assertTrue(authorizationPage.isPasswordAllertVisible()); // Здесь подразумавается проверка на InvalidValue.
}
