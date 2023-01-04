package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context) : SQLiteOpenHelper(context,"DB",null,1){

    companion object{

    }
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE Users(_id INTEGER PRIMARY KEY AUTOINCREMENT, uName TEXT, uPassword TEXT, uEmail TEXT)")
        db?.execSQL("CREATE TABLE Levels(_id INTEGER PRIMARY KEY AUTOINCREMENT, level TEXT)")
        db?.execSQL("CREATE TABLE Users_Levels(_id INTEGER,levelID INTEGER, count INTEGER, FOREIGN KEY(_id) REFERENCES Users(_id), FOREIGN KEY (LevelID) REFERENCES Levels(levelID),PRIMARY KEY(_id,levelID))")
        db?.execSQL("CREATE TABLE Questions(_id INTEGER PRIMARY KEY AUTOINCREMENT, question TEXT, levelID INTEGER,FOREIGN KEY(levelID) REFERENCES Levels(levelID) )")
        db?.execSQL("CREATE TABLE Answers(_id INTEGER PRIMARY KEY AUTOINCREMENT, qID INTEGER, answers INTEGER, statusID INTEGER, FOREIGN KEY(qID) REFERENCES Questions(qID), FOREIGN KEY(statusID) REFERENCES Status(statusID))")
        db?.execSQL("CREATE TABLE Status(_id INTEGER PRIMARY KEY AUTOINCREMENT, status TEXT)")

        db?.execSQL("INSERT INTO LEVELS(level) Values('Amateur')")
        db?.execSQL("INSERT INTO LEVELS(level) Values('Semi-Pro')")
        db?.execSQL("INSERT INTO LEVELS(level) Values('Professional')")

        db?.execSQL("INSERT INTO QUESTIONS(question) Values('3+5')")
        db?.execSQL("INSERT INTO QUESTIONS(question) Values('6+5')")
        db?.execSQL("INSERT INTO QUESTIONS(question) Values('7+8')")
        db?.execSQL("INSERT INTO QUESTIONS(question) Values('4+3')")
        db?.execSQL("INSERT INTO QUESTIONS(question) Values('2+8')")

        db?.execSQL("INSERT INTO Answers(answers) Values(8)")
        db?.execSQL("INSERT INTO Answers(answers) Values(11)")
        db?.execSQL("INSERT INTO Answers(answers) Values(15)")
        db?.execSQL("INSERT INTO Answers(answers) Values(7)")
        db?.execSQL("INSERT INTO Answers(answers) Values(10)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}