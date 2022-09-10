package com.example.toko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isEmpty
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputTanggalLahir: TextInputLayout
    private lateinit var inputNoTelepon: TextInputLayout
    private lateinit var mainLayout: ConstraintLayout
    private lateinit var btnClear: Button
    private lateinit var btnRegister: Button

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
        btnClear = findViewById(R.id.btnClear)
        btnRegister = findViewById(R.id.btnRegister)



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
            var checkRegister = false
            val mBundle = Bundle()

            val username: String = inputUsername.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()
            val email: String = inputEmail.getEditText()?.getText().toString()
            val tanggalLahir: String = inputTanggalLahir.getEditText()?.getText().toString()
            val noTelepon: String = inputNoTelepon.getEditText()?.getText().toString()

            // Pengecekan apakah input username kosong
            if (username.isEmpty()) {
                inputUsername.setError("Username must be filled with Text")
                checkRegister = false
            }
            if (password.isEmpty()) {
                inputPassword.setError("Password must be filled with Text")
                checkRegister = false
            }
            if (email.isEmpty()) {
                inputEmail.setError("Email must be filled with Text")
                checkRegister = false
            }
            if (tanggalLahir.isEmpty()) {
                inputTanggalLahir.setError("Tanggal Lahir must be filled with Text")
                checkRegister = false
            }
            if (noTelepon.isEmpty()) {
                inputNoTelepon.setError("No Telepon must be filled with Text")
                checkRegister = false
            }
            else {
                checkRegister = true
            }
            if (!checkRegister) return@setOnClickListener

            mBundle.putString("username",inputUsername.getEditText()?.getText().toString())
            mBundle.putString("password",inputPassword.getEditText()?.getText().toString())
            mBundle.putString("password",inputEmail.getEditText()?.getText().toString())
            mBundle.putString("password",inputTanggalLahir.getEditText()?.getText().toString())
            mBundle.putString("password",inputNoTelepon.getEditText()?.getText().toString())
            intent.putExtra("register", mBundle)


            val moveHome = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(moveHome)
        }
    }
}