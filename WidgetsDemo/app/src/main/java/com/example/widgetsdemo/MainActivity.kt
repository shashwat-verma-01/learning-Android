package com.example.widgetsdemo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    lateinit var checkBox : CheckBox

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayCheckBox()
        displayRadioGroup()
        displaySpinner()
        displayTimePicker()
        displayDatePicker()
        displayProgressBar()
        }

    fun displayCheckBox() {
        checkBox = findViewById(R.id.checkBox)

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            // buttonView represents the "CompoundButton" that has had its checked state changed.
            // Its refers to the checkBox

            // isChecked: a boolean indicating whether the button is checked (true) or unchecked(false)

            if (isChecked) {

                Toast.makeText(this, "You Checked Tomato", Toast.LENGTH_SHORT).show()
            } else {
                //
            }
        }
    }

    fun displayRadioGroup(){
        val radioGroup : RadioGroup = findViewById(R.id.radioGroup)
        val cheeseRB : RadioButton = findViewById(R.id.cheeseRadioButton)
        val spicesRB : RadioButton = findViewById(R.id.spiceRadioButton)
        val onionRB : RadioButton = findViewById(R.id.onionRadioButton)

        radioGroup.setOnCheckedChangeListener { group, i ->

            when(i){
                R.id.cheeseRadioButton -> {
                    Toast.makeText(this,"You selected Cheese", Toast.LENGTH_SHORT).show()
                }

                R.id.spiceRadioButton -> {
                    Toast.makeText(this,"You selected Spices", Toast.LENGTH_SHORT).show()
                }

                R.id.onionRadioButton -> {
                    Toast.makeText(this,"You selected Onion", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun displaySpinner(){
        val spinner : Spinner = findViewById(R.id.mySpinner)

        val toppings = arrayOf("Chicken", "Pepperoni", "Paneer", "Mushroom")

//        Adapter : a bridge between the data and the UI components
//        ArrayAdapter : used to bind an array of data to a spinner
//        converts each item in the array to a view in a Spinner

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            toppings
        )

        spinner.adapter = adapter

//        Handling item selection on Spinner
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
//                val selectedItem = parent?.getItemAtPosition(position).toString()
                val selectedItem2 = toppings[position]
                Toast.makeText(applicationContext,
                    "You selected $selectedItem2.",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    fun displayTimePicker(){
        val timePicker : TimePicker = findViewById(R.id.timePicker)

//        Handle changes in time
        
        timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            val selectedTime = String.format("%02d : %02d", hourOfDay, minute)

            Toast.makeText(applicationContext,
                "Your selected time : $selectedTime",
                Toast.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun displayDatePicker(){
        val datePicker : DatePicker = findViewById(R.id.datePicker)

//        Handling Date Change
        datePicker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->

            Toast.makeText(applicationContext,
                "Your date :: Year: $year, Month: ${monthOfYear+1}, Day: $dayOfMonth",
                Toast.LENGTH_SHORT).show()
        }

    }

    fun displayProgressBar() {
        val progressBar: ProgressBar = findViewById(R.id.progresBar)
        val progressValue = 60
        progressBar.progress = progressValue
    }

}