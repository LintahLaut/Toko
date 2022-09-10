package com.example.toko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputTanggalLahir: TextInputLayout
    private lateinit var inputNoTelepon: TextInputLayout
    private lateinit var mainLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setTitle("REGISTER")

        inputUsername = findViewById(R.id.inputLayoutUsername)
        inputPassword = findViewById(R.id.inputLayoutPassword)
        inputEmail = findViewById(R.id.inputLayoutEmail)
        inputTanggalLahir = findViewById(R.id.inputLayoutTanggalLahir)
        inputNoTelepon = findViewById(R.id.inputLayoutNoTelepon)
        mainLayout = findViewById(R.id.mainLayout)
        val btnRegister: Button = findViewById(R.id.btnRegister)
        val btnClear: Button = findViewById(R.id.btnClear)

        // Aksi btnClear ketika di klik
        btnClear.setOnClickListener { // Mengkosongkan Input
            inputUsername.getEditText()?.setText("")
            inputPassword.getEditText()?.setText("")
            inputEmail.getEditText()?.setText("")
            inputTanggalLahir.getEditText()?.setText("")
            inputNoTelepon.getEditText()?.setText("")

            // Memunculkan SnackBar
            Snackbar.make(mainLayout, "Text Cleared Success", Snackbar.LENGTH_LONG).show()
        }

        btnRegister.setOnClickListener {
            val moveHome = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(moveHome)
        }
    }
}