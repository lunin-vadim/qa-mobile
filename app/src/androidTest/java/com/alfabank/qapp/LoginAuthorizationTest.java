package com.alfabank.qapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotClickable;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.alfabank.qapp.presentation.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginAuthorizationTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void loginWithValidCredentialsTest() {

        loginWithCredentialsAndExpectedResult("Login", "Password", R.string.login_result_title);
    }

    @Test
    public void loginWithWrongUsernameTest() {

        loginWithCredentialsAndExpectedResult("Login-1", "Password", R.string.incorrect_credentials);
    }

    @Test
    public void loginWithoutCredentialsTest() {

        loginWithCredentialsAndExpectedResult("", "", R.string.incorrect_credentials);
    }

    @Test
    public void loginWithWrongPasswordTest() {

        loginWithCredentialsAndExpectedResult("Login", "Pass-1", R.string.incorrect_credentials);
    }

    @Test
    public void validateTitleFieldPropertiesTest() {

        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.tvTitle)).check(matches(isNotClickable()));
        onView(withId(R.id.tvTitle)).check(matches(withText(R.string.login_screen_title)));
    }

    @Test
    public void validateLoginInputPropertiesTest(){

        onView(withId(R.id.etUsername)).check(matches(isDisplayed()));
        onView(withId(R.id.etUsername)).check(matches(isClickable()));
        onView(withId(R.id.etUsername)).check(matches(withHint(R.string.username)));
        onView(withId(R.id.etUsername)).check(matches(withHint(R.string.username)));
    }

    @Test
    public void validatePasswordInputPropertiesTest(){

        onView(withId(R.id.etPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.etPassword)).check(matches(isClickable()));
        onView(withId(R.id.etPassword)).check(matches(withHint(R.string.password)));
    }

    @Test
    public void validateConfirmButtonPropertiesTest(){

        onView(withId(R.id.btnConfirm)).check(matches(isDisplayed()));
        onView(withId(R.id.btnConfirm)).check(matches(isClickable()));
        onView(withId(R.id.btnConfirm)).check(matches(withText(R.string.action_enter)));
    }

    private void waitForMessage(int messageToWait, int timeoutInSec) {
        try {
            Thread.sleep(timeoutInSec * 1000);
            onView(withText(messageToWait)).check(matches(isDisplayed()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void loginWithCredentialsAndExpectedResult(String username, String password, int expectedMessage) {
        onView(withId(R.id.etUsername)).perform(typeText(username));
        onView(withId(R.id.etPassword)).perform(typeText(password));
        onView(withId(R.id.btnConfirm)).perform(click());
        waitForMessage(expectedMessage, 5);
    }
}