package com.example.myapplication

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_acct.*
import kotlinx.android.synthetic.main.activity_main.*

class createAcct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_acct)

        var helper = MyHelper(applicationContext)
        var db : SQLiteDatabase =helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS",null)

        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val submit= findViewById<Button>(R.id.submit)
        submit .setOnClickListener{
            if( password1.text.trim()==((confirmPass.text.trim()))){
                if(editText_user.text.trim().isNotEmpty()&& email.text.trim().isNotEmpty()){

                    Toast.makeText(this,"Account created! Login",Toast.LENGTH_LONG).show()
                    val intent= Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    var cv = ContentValues()
                    cv.put("uName",editText_user.text.toString())
                    cv.put("uPassword", password1.text.toString())
                    cv.put("uEmail",email.text.toString())
                    db.insert("Users",null,cv)
                    rs.close()

                }
                else{
                    Toast.makeText(this,"Username or Email is not filled", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this,"Passwords do not match", Toast.LENGTH_LONG).show()

            }
        }






    }
}