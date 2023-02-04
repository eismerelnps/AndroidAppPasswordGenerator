package com.elnps.passwordgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val generateButton: Button = findViewById(R.id.generateButton)
        generateButton.setOnClickListener{checkValue()}
    }



    fun checkValue() {
        val passwordTextView: TextView = findViewById(R.id.passwordTextView)
        val passwordLengthEditText: EditText = findViewById(R.id.passwordLengthEditText)
        val CapitalRadioButton: RadioButton = findViewById(R.id.CapitalRadioButton)
        val minRadioButton: RadioButton = findViewById(R.id.minRadioButton)
        val numberRadioButton: RadioButton = findViewById(R.id.numberRadioButton)
        val specialCharRadioButton: RadioButton = findViewById(R.id.specialCharRadioButton)
        val generator = Generator()
        if (passwordLengthEditText.text.isEmpty()) {
            passwordTextView.text = "Please set a length first"
        } else if (passwordLengthEditText.text.toString()
                .toInt() <= 4 || passwordLengthEditText.text.toString().toInt() > 120
        ) {
            passwordTextView.text = "For security set a length between 4 and 120 characters "
        } else if (!CapitalRadioButton.isChecked && !minRadioButton.isChecked && !numberRadioButton.isChecked && !specialCharRadioButton.isChecked) {
            passwordTextView.text = "Set at least one of the requirements"
        } else {
            generator.setOptions(
                passwordLengthEditText.text.toString().toInt(),
                CapitalRadioButton.isChecked,
                minRadioButton.isChecked,
                numberRadioButton.isChecked,
                specialCharRadioButton.isChecked
            )
            val password: String
            password = generator.generate()
            passwordTextView.text = generator.generate()
        }
    }
}