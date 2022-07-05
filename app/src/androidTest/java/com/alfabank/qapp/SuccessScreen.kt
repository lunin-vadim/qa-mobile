package com.alfabank.qapp

import com.alfabank.qapp.presentation.MainActivity
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView

object SuccessScreen : KScreen<SuccessScreen>(){
    override val layoutId: Int?= R.layout.activity_main
    override val viewClass: Class<*>?=MainActivity::class.java

    val tvTitle = KView{withText("Вход в Alfa-Test выполнен")}
//    val tvTitle = KView{containsText("выполнен")}
}