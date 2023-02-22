package com.example.petofy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.petofy.databinding.ActivityLogInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogIn_Activity : AppCompatActivity() {
    public lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLoginUser.setOnClickListener()
        {


            val email = " vet.petofy@gmail.com"
            val password = "Pass@123"
            RetrofitLogInClient.logInterface.login(Login_Request(Data(email, password)))
                .enqueue(object : Callback<LogIn_Response?> {
                    override fun onResponse(
                        call: Call<LogIn_Response?>,
                        response: Response<LogIn_Response?>
                    ) {
                        if(response.code().equals(200))
                        {
                            Toast.makeText(this@LogIn_Activity, "${response.body()?.data?.encryptedId}", Toast.LENGTH_SHORT).show()
/*
                          if(response.body()?.data?.email=="vet.petofy@gmail.com"){
                              Toast.makeText(this@LogIn_Activity,"Valid User", Toast.LENGTH_SHORT).show()
                          }
                            else
                          {
                              Toast.makeText(this@LogIn_Activity, "Invalid User", Toast.LENGTH_SHORT).show()
                          }*/
                        }

                    }

                    override fun onFailure(call: Call<LogIn_Response?>, t: Throwable) {
                        Toast.makeText(this@LogIn_Activity, "error", Toast.LENGTH_SHORT).show()

                    }
                })

        }
    }
}