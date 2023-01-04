package com.example.myapplication

import android.content.pm.ActivityInfo
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SimpleCursorAdapter
import kotlinx.android.synthetic.main.activity_amateur.*
import kotlinx.android.synthetic.main.activity_create_acct.view.*
import kotlinx.android.synthetic.main.activity_main_page.view.*
import android.util.Log
import android.widget.RadioButton
import android.graphics.Color
import android.graphics.Typeface
import android.provider.MediaStore
import android.widget.Toast
import android.widget.TextView
import androidx.core.content.ContextCompat
import android.content.Intent


class Amateur : AppCompatActivity(), View.OnClickListener{


    private var mCurrentPosition:Int=1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers:Int=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amateur)

        mQuestionsList=Constants.getQuestions()

        setQuestion()

        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
        submit_next.setOnClickListener(this)


    }

    private fun setQuestion(){

        val question=mQuestionsList!![mCurrentPosition-1] //question variable = questionsList array[0]

        defaultOptionsView()//sets options to default color,

       // if(mCurrentPosition==mQuestionsList!!.size){ // sets button to submit again-when current and size is same-no questions left
           submit_next.text="submit"
       // }
      // else{
       // if(mCurrentPosition==mQuestionsList!!.size){
          // submit_next.text="finish" }//still questions left
       // }

        progressBar.progress=mCurrentPosition
        tv_progress.text="$mCurrentPosition"+"/"+progressBar.max

        view_question.text=question!!.question //viewing question
        option1.text=question.option1//displaying the options
        option2.text=question.option2
        option3.text=question.option3
        option4.text=question.option4
    }

    private fun defaultOptionsView(){
        val options=ArrayList<TextView>()
        options.add(0,option1)
        options.add(1,option2)
        options.add(2,option3)
        options.add(3,option4)

        for(option in options){
            option.setTextColor(Color.parseColor( "#7A8089" ))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }


    }

    override fun onClick(v: View?){
when(v?.id){ //when an option is clicked,
    R.id.option1->{
        selectedOptionView(option1,1) //if clicked, call selectedOptionView
    }
    R.id.option2->{
        selectedOptionView(option2,2)
    }
    R.id.option3->{
        selectedOptionView(option3,3)
    }
    R.id.option4->{
        selectedOptionView(option4,4)
    }
    R.id.submit_next->{ //if submit is clicked
        if(mSelectedOptionPosition==0){//no option clicked?
            mCurrentPosition++ //goes to next question


            when{ mCurrentPosition<=(mQuestionsList!!.size-40) ->{//theres still questions left
                setQuestion() //default settings for questions
            } else->{//no questions left
                if(mCorrectAnswers<mQuestionsList!!.size-40){
                    //Toast.makeText(this,"You need to practice",Toast.LENGTH_LONG).show()
                    val intent1=Intent(this,Result2::class.java)
                    intent1.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                    intent1.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size-40)
                    startActivity(intent1)
                }
                else{
                    val intent=Intent(this,ResultActivity::class.java)
                    intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                    intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size-40)
                    startActivity(intent)
                    finish()
                }

            }
            }
        }

        else{
            val question=mQuestionsList?.get(mCurrentPosition-1)
            if(question!!.answer==mSelectedOptionPosition){ //if answers is correct
                mCorrectAnswers++ //increase by 1
            }

            if(mCurrentPosition!=mQuestionsList!!.size-40){ //checks if questions left, then changes button
                submit_next.text="Go to next question"
           }
            else{
                submit_next.text="finish"
            }

            mSelectedOptionPosition=0 // change to 0 to in order to change next question



        }
    }


}
    }

    private fun answerView(answer:Int,drawableView:Int){
          when(answer){
              1->{
                  option1.background=ContextCompat.getDrawable(this,drawableView)
              }
              2->{
                  option2.background=ContextCompat.getDrawable(this,drawableView)
              }
              3->{
                  option3.background=ContextCompat.getDrawable(this,drawableView)
              }
              4->{
                  option4.background=ContextCompat.getDrawable(this,drawableView)
              }
          }
    }


    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int){ //makes selected option appear in bold, selected border
        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor( "#363A43" ))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }







}