package com.example.myapplication

import android.content.Intent
import android.content.pm.ActivityInfo
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_page.*

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        var helper = MyHelper(applicationContext)
        var db : SQLiteDatabase =helper.readableDatabase

       signOut.setOnClickListener{

             db.close()
             finish()
           val intent=Intent(this,MainActivity::class.java)
           startActivity(intent)

       }




         amateur.setOnClickListener{
             val intent=Intent(this, Amateur::class.java)
             startActivity(intent)
         }
3
        semipro.setOnClickListener{
            val intent=Intent(this, SemiPro::class.java)
            startActivity(intent)
        }

        professional.setOnClickListener{
            val intent=Intent(this, Professional::class.java)
            startActivity(intent)
        }








    }






}