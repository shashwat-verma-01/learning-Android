package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mUserName : String? = null
    private var mCorrectAnswers : Int = 0

    private var progressBar : ProgressBar? = null
    private var progress : TextView? = null
    private var question : TextView? = null
    private var img : ImageView? = null

    private var optionOne : TextView? = null
    private var optionTwo : TextView? = null
    private var optionThree : TextView? = null
    private var optionFour : TextView? = null
    private var btnSubmit : Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.User_Name)

        progressBar = findViewById(R.id.progressBar)
        progress = findViewById(R.id.progress)
        question = findViewById(R.id.question)
        img = findViewById(R.id.img)
        optionOne = findViewById(R.id.optionOne)
        optionTwo = findViewById(R.id.optionTwo)
        optionThree = findViewById(R.id.optionThree)
        optionFour = findViewById(R.id.optionFour)
        btnSubmit = findViewById(R.id.btnSubmit)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionsView()
        val que: Question = mQuestionList!![mCurrentPosition - 1]
        img?.setImageResource(que.image)
        progressBar?.progress = mCurrentPosition
        progress?.text = "$mCurrentPosition/${progressBar?.max}"
        question?.text = que.question
        optionOne?.text = que.optionOne
        optionTwo?.text = que.optionTwo
        optionThree?.text = que.optionThree
        optionFour?.text = que.optionFour

        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SKIP"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        optionOne?.let{
            options.add(0,it)
        }
        optionTwo?.let{
            options.add(1,it)
        }
        optionThree?.let{
            options.add(2,it)
        }
        optionFour?.let{
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_order
            )
        }
    }

    private fun selectedOption(tv : TextView, selectedOption : Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOption
        tv.setTextColor(Color.parseColor("#364a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border
        )
        btnSubmit?.text = "SUBMIT"
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne -> {
                optionOne?.let{
                    selectedOption(it,1)
                }
            }
            R.id.optionTwo -> {
                optionTwo?.let{
                    selectedOption(it,2)
                }
            }
            R.id.optionThree -> {
                optionThree?.let{
                    selectedOption(it,3)
                }
            }
            R.id.optionFour -> {
                optionFour?.let{
                    selectedOption(it,4)
                }
            }
            R.id.btnSubmit ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++
                when{
                    mCurrentPosition <= mQuestionList!!.size ->{
                        setQuestion()
                    }
                    else ->{
                        Toast.makeText(this, "Congrats! You finished the Quiz!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.User_Name, mUserName)
                        intent.putExtra(Constants.Correct_Answers, mCorrectAnswers)
                        intent.putExtra(Constants.Total_Questions, mQuestionList?.size)
                        startActivity(intent)
                        finish()
                    }
                }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_boder_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_boder_bg)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btnSubmit?.text = "FINISH"
                    }
                    else{
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                optionThree?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                optionFour?.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

}