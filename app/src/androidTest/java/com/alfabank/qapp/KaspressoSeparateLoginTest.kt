package com.alfabank.qapp

import android.Manifest
import android.view.View
import android.widget.EditText
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.alfabank.qapp.presentation.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.edit.EditableActions
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KaspressoSeparateLoginTest : TestCase() {

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun visibleTest() {
        run {
            step("Title and fields test") {
                LoginScreen {
                    tvTitle {
                        isVisible()
                        hasText("Вход в Alfa-Test")
                    }
                }
            }
            step("Btn test") {
                LoginScreen {
                    btnConfirm {
                        isVisible()
                        isClickable()
                    }
                }
            }
            step("Login field test") {
                LoginScreen {
                    etLogin {
                        isVisible()
                        hasEmptyText()
                        typeText("wrongLogin")
                        clearText()
                    }
                }
            }
            step("Pass field test") {
                LoginScreen {
                    etPass {
                        isVisible()
                        hasEmptyText()
                        typeText("wrongPass")
                        clearText()
                    }
                }
            }
        }
    }

        @Test
    fun emptyTest() {
        run {
            step("Empy fields test") {
                LoginScreen {
                    btnConfirm {
                        click()
                    }
                    tvError {
                        hasAnyText()
                    }
                }
            }
        }
    }

    @Test
    fun wrongLoginTest() {
        run {
            step("Wrong login test") {
                LoginScreen {
                    etLogin {
                        typeText("wrongLogin")
                    }
                    etPass {
                        typeText("Password")
                    }
                    btnConfirm {
                        click()
                    }
                    tvError {
                        hasAnyText()
                    }
                }
            }
        }
    }

    @Test
    fun wrongPassTest() {
        run {
            step("Wrong pass test") {
                LoginScreen {
                    etLogin {
                        typeText("Login")
                    }
                    etPass {
                        typeText("wrongPassword")
                    }
                    btnConfirm {
                        click()
                    }
                    tvError {
                        hasAnyText()
                    }
                }
            }
        }
    }

    @Test
    fun wrongLoginPassTest() {
        run {
            step("Wrong login & pass test") {
                LoginScreen {
                    etLogin {
                        typeText("wrongLogin")
                    }
                    etPass {
                        typeText("wrongPassword")
                    }
                    btnConfirm {
                        click()
                    }
                    tvError {
                        hasAnyText()
                    }
                }
            }
        }
    }

    @Test
    fun validTest() {
        run {
            step("Valid login & pass test") {
                LoginScreen {
                    etLogin {
                        typeText("Login")
                    }
                    etPass {
                        typeText("Password")
                    }
                    btnConfirm {
                        click()
                    }
                    tvError {
                        hasEmptyText()
                    }

                }
            }
            step("Loader test") {
                LoginScreen {
                    stBar {
                        isVisible()
                        isEnabled()
                    }
                }
            }
            step("Success screen test") {
                SuccessScreen.tvTitle.isVisible()
            }
        }
    }

    @Test
    fun wrongSymbols() {
        run {
            step("Wrong login symbols test") {
                LoginScreen {
                    val login = "Login+!&*?()-"
                    val regex = "[^A-z.,'_\\s-]".toRegex()
                    val matched = regex.containsMatchIn(login)
                    etLogin {
                        typeText(login)
                        device.screenshots.take("Additional_screenshot")
                    }
                    testLogger.i(matched.toString())
                    if (matched) {
                        tvError {
                            hasAnyText()
                        }
                    }
                }
            }
        }
    }
}