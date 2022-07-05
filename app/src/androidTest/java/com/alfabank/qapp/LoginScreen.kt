package com.alfabank.qapp

import com.alfabank.qapp.presentation.MainActivity
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object LoginScreen : KScreen<LoginScreen>(){
    override val layoutId: Int?= R.layout.fragment_login
    override val viewClass: Class<*>?=MainActivity::class.java

    val tvTitle = KTextView{withId(R.id.tvTitle)}
    val etLogin = KEditText{withId(R.id.etUsername)}
    val etPass = KEditText{withId(R.id.etPassword)}
    val btnConfirm = KButton{withId(R.id.btnConfirm)}
    val tvError = KTextView{withId(R.id.tvError)}
    val stBar = KView{withId(R.id.loader)}
    val eye = KView{withId(R.id.tilPassword)}
}