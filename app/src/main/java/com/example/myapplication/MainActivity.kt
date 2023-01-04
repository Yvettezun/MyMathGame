package com.example.myapplication

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = MyHelper(applicationContext)
        var db :SQLiteDatabase =helper.readableDatabase


        val btnAcct = findViewById<Button>(R.id.btnAcct)

        btnAcct .setOnClickListener{
            val intent= Intent(this, createAcct::class.java)
            intent.putExtra("data","test data")
            startActivity(intent)
        }


        val login= findViewById<Button>(R.id.login)
            login .setOnClickListener{
                if(username.text.trim().isNotEmpty() && password.text.trim().isNotEmpty()){

                    var args= listOf<String>(username.text.toString(),password.text.toString()).toTypedArray()
                    var rs = db.rawQuery("SELECT * FROM USERS WHERE UNAME = ? AND UPASSWORD = ? ",args)
                       if(rs.moveToNext()){
                        Toast.makeText(applicationContext,"Login successful",Toast.LENGTH_LONG).show()
                        val intent= Intent(this, MainPage::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(applicationContext,"Account doesn't exist",Toast.LENGTH_LONG).show()
                    }
            }
                else{
                    Toast.makeText(this,"Input Required",Toast.LENGTH_LONG).show()
                }
        }

    }
}