package com.elnps.passwordgenerator

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val generateButton: Button = findViewById(R.id.generateButton)
        val passwordLengthSeekBar: SeekBar = findViewById(R.id.passwordLengthSeekBar)
        val copyToClipboardButton: Button = findViewById(R.id.copyToClipboardButton)
        passwordLengthSeekBar.max = 120
        passwordLengthSeekBar.min = 4
        passwordLengthSeekBar.progress = 8
        generateButton.setOnClickListener{checkValue()}
        copyToClipboardButton.setOnClickListener { copyToClipboard() }
    }



    fun checkValue() {
        val passwordTextView: TextView = findViewById(R.id.passwordTextView)
        val CapitalRadioButton: RadioButton = findViewById(R.id.CapitalRadioButton)
        val minRadioButton: RadioButton = findViewById(R.id.minRadioButton)
        val numberRadioButton: RadioButton = findViewById(R.id.numberRadioButton)
        val specialCharRadioButton: RadioButton = findViewById(R.id.specialCharRadioButton)
        val passwordLengthSeekBar: SeekBar = findViewById(R.id.passwordLengthSeekBar)
        val generator = Generator()

       if (!CapitalRadioButton.isChecked && !minRadioButton.isChecked && !numberRadioButton.isChecked && !specialCharRadioButton.isChecked) {
            passwordTextView.text = "Set at least one of the requirements"
        } else {
            generator.setOptions(
                passwordLengthSeekBar.progress.toString().toInt(),
                CapitalRadioButton.isChecked,
                minRadioButton.isChecked,
                numberRadioButton.isChecked,
                specialCharRadioButton.isChecked
            )
            passwordTextView.text = generator.generate()
        }
    }
    fun copyToClipboard(){
        val passwordTextView: TextView = findViewById(R.id.passwordTextView)
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Password", passwordTextView.text.toString())
        clipboard.setPrimaryClip(clip)
    }
}