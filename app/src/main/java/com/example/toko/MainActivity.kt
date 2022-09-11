package com.example.toko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var mainLayout: ConstraintLayout

    lateinit var  mBundle: Bundle
    lateinit var newUsername: String
    lateinit var newPassword: String
    lateinit var newEmail: String
    lateinit var newTanggalLahir: String
    lateinit var newNoTelepon: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("USER LOGIN")

        // Hubungkan variabel dengan view di layoutnya
        inputUsername = findViewById(R.id.inputLayoutUsername)
        inputPassword = findViewById(R.id.inputLayoutPassword)
        mainLayout = findViewById(R.id.mainLayout)

        val btnRegister: Button = findViewById(R.id.btnRegister)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        var intent : Intent = intent

        // Mengambil data register ketika sudah register
        if (intent.hasExtra("register")) {
            getBundle()
            setText()
        }

        // Aksi pada btnLogin
        btnLogin.setOnClickListener(View.OnClickListener {
            var checkLogin = false
            val username: String = inputUsername.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()

            // EROR HANDLING
            if (username.isEmpty()) {
                inputUsername.setError("Username must be filled with Text")
                checkLogin = false
            }else if (username != "admin") {
                inputUsername.setError("Username false")
                checkLogin = false
            }else if (username == "admin" || username == newUsername) {
                checkLogin = true
            }

            // Pengecekan apakah input password kosong
            if (password.isEmpty()) {
                inputPassword.setError("Password must ben filled with text")
                checkLogin = false
            }else if (password != "admin") {
                inputPassword.setError("Password false")
                checkLogin = false
            }else if (password == "admin" || password == newPassword) {
                checkLogin = true
            }

            if (!checkLogin) return@OnClickListener
            val moveHome = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(moveHome)
        })

        // Move ke Activity Register
        btnRegister.setOnClickListener {
            val moveHome = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(moveHome)
        }
    }

    fun getBundle() {
        mBundle = intent.getBundleExtra("register")!!
        newUsername = mBundle.getString("username")!!
        newPassword = mBundle.getString("password")!!
    }

    fun setText() {
        inputUsername = findViewById(R.id.inputLayoutUsername)
        inputUsername.getEditText()?.setText(newUsername)
    }
}