package com.sample.vsegura15dev.customkeyboard.service

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.text.TextUtils
import android.view.View
import com.sample.vsegura15dev.customkeyboard.R

class CustomKeyBoardService : InputMethodService(), KeyboardView.OnKeyboardActionListener {


    override fun onCreateInputView(): View {


        val keyboardView = layoutInflater.inflate(R.layout.keyboard_preview, null) as KeyboardView
        val keyboard = Keyboard(this, R.xml.number_pad)
        keyboardView.keyboard = keyboard
        keyboardView.setOnKeyboardActionListener(this)
        return keyboardView
    }


    override fun swipeRight() {
    }

    override fun onPress(primaryCode: Int) {
    }

    override fun onRelease(primaryCode: Int) {
    }

    override fun swipeLeft() {
    }

    override fun swipeUp() {
    }

    override fun swipeDown() {
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {

        val inputConnection = currentInputConnection

        when (primaryCode) {

            Keyboard.KEYCODE_DELETE -> {

                val selected = inputConnection.getSelectedText(0)

                if (TextUtils.isEmpty(selected)) {
                    inputConnection.deleteSurroundingText(1, 0)
                } else {
                    inputConnection.commitText("", 1)
                }
                inputConnection.deleteSurroundingText(1, 0)
            }
            else -> {
                val code = primaryCode.toChar()
                inputConnection.commitText(String(charArrayOf(code)), 1)
            }
        }


    }

    override fun onText(text: CharSequence?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}