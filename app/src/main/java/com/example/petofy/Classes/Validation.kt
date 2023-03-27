package com.example.petofy.Classes

import com.google.android.material.textfield.TextInputEditText

class Validation {

    fun NameValidation(firstname: TextInputEditText):Boolean
    {
        if(firstname.text?.isEmpty()==true)
        {
            return false
        }
        return  true
    }

    fun PasswordValidation(password: TextInputEditText, confirmpassword: TextInputEditText):Boolean
    {
        if(password.text!=confirmpassword.text)
        {
            return  false

        }
        return  true
    }
}