package com.example.ageinminutes

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.btn)
        val targText : TextView = findViewById(R.id.targText)
        val resText : TextView = findViewById(R.id.resText)

        btn.setOnClickListener(){
            clickDatePicker(btn, targText, resText)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun clickDatePicker(btn : Button, targText : TextView, resText : TextView){

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {view, year, month, day ->
            Toast.makeText(this,
                "Year : $year | Month : ${month + 1} | Day : $day",Toast.LENGTH_LONG).show()

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val dateSelected = sdf.parse("$day/${month+1}/$year")
                val dateCurrentMins = (sdf.parse(sdf.format(System.currentTimeMillis()))?.time  )?.div(
                    60000
                )
                val dateSelectedMins = dateSelected.time /60000
                val diffMins = dateCurrentMins?.minus(dateSelectedMins)

                if (dateSelected != null) {
                    targText.text = "$day/${month+1}/$year"
                }
                resText.text = diffMins.toString()
            }
            , year,month,day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()

    }
}