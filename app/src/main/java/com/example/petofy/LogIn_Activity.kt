package com.example.petofy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.petofy.databinding.ActivityLogInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogIn_Activity : AppCompatActivity() {
    public lateinit var binding: ActivityLogInBinding
    lateinit var email: String
    lateinit var password: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.progressBar.visibility = View.INVISIBLE
        binding.imgLoginBack.setOnClickListener() {
            onBackPressed()


        }
        binding.btnLoginUser.setOnClickListener() {


            /*  email = binding.etEmail.text.toString()
              password = binding.etPassword.text.toString()
  */
            binding.progressBar.visibility = View.VISIBLE
            email = "vet.petofy@gmail.com"
            password = "pass@123"
            if (isValid()) {
                RetrofitLogInClient.logInterface.login(Login_Request(Data(email, password)))
                    .enqueue(object : Callback<LogIn_Response?> {
                        override fun onResponse(
                            call: Call<LogIn_Response?>, response: Response<LogIn_Response?>
                        ) {
                            if (response.body() != null) {
                                if (response.body()?.data?.email == "vet.petofy@gmail.com") {

                                    val intent = Intent(this@LogIn_Activity, DashBoard::class.java)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this@LogIn_Activity, "Invalid user", Toast.LENGTH_SHORT
                                    ).show()
                                }

                            }

                        }

                        override fun onFailure(call: Call<LogIn_Response?>, t: Throwable) {
                            Toast.makeText(this@LogIn_Activity, "error", Toast.LENGTH_SHORT).show()

                        }
                    })
            }

        }
    }

    private fun isValid(): Boolean {
        if (email.isEmpty() && password.isEmpty()) {
            Toast.makeText(this@LogIn_Activity, "Email & password required", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (email.isEmpty()) {
            Toast.makeText(this@LogIn_Activity, "Email required", Toast.LENGTH_SHORT).show()
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.toString().trim()).matches()) {
            Toast.makeText(this@LogIn_Activity, "Invalid Email", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password.isEmpty()) {
            Toast.makeText(this@LogIn_Activity, "Password required", Toast.LENGTH_SHORT).show()
            return false
        } else if (password.length < 6) {
            Toast.makeText(
                this@LogIn_Activity, "Minimum length of password is 6", Toast.LENGTH_SHORT
            ).show()
            return false
        }
        return true

    }
}