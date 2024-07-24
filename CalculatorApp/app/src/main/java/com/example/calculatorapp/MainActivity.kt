package com.example.calculatorapp

import          androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    private var input : TextView? = null
    var lastNum : Boolean = false
    var lastDec : Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input = findViewById(R.id.input)
    }

    fun onDigit(view : View){
        if(input?.text == "0"){
            input?.text = ""
        }
        input?.append((view as Button).text)
        lastNum = true
        lastDec = false
    }

    fun onOperator(view: View){
        input?.text?.let{
            if(input?.text == "0"){
                if((view as Button).text == "-"){
                    input?.append((view as Button).text)
                }
                else{
                    input?.text = ""
                }
            }
            if(lastNum && !isOperatorAdded(it.toString())){
                    input?.append((view as Button).text)
                    lastNum = false
                    lastDec = false
                }
        }
    }

    fun onClear(view : View){
        input?.text = ""
    }
    fun onDec(view : View){
        if(lastNum && !lastDec){
            input?.append(".")
            lastNum = false
            lastDec = true
        }
    }
    fun onEqual(view: View){
        if(lastNum){
            var inputValue = input?.text.toString()
            var prefix = ""
            try {
                if(inputValue.startsWith("-")){
                    prefix = "-"
                    inputValue = inputValue.substring(1)
                }
                if(inputValue.contains("-")){
                    val splitValue = inputValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    input?.text = removeZeroAfterDec((one.toDouble() - two.toDouble()).toString())
                }else if(inputValue.contains("+")){
                    val splitValue = inputValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    input?.text = removeZeroAfterDec((one.toDouble() + two.toDouble()).toString())
                }else if(inputValue.contains("*")){
                    val splitValue = inputValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    input?.text = removeZeroAfterDec((one.toDouble() * two.toDouble()).toString())
                }else if(inputValue.contains("/")){
                    val splitValue = inputValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    input?.text = removeZeroAfterDec((one.toDouble() / two.toDouble()).toString())
                }
            }catch (e : ArithmeticException){
                e.printStackTrace()
            }
        }
    }
    fun onBack(view: View){
        input?.text = input?.text.toString().dropLast(1)
    }

    private fun removeZeroAfterDec(result : String) : String{
        var value = result
        if(result.contains(".0"))
            value = result.substring(0, result.length-2)
        return value
    }

    private fun isOperatorAdded(value : String) : Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("/") || value.contains("*")||value.contains("+")||value.contains("-")
        }
    }

}