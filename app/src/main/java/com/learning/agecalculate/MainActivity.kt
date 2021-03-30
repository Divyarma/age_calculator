package com.learning.agecalculate

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener{view ->
            clickdp(view)
        }

    }

    fun clickdp(view: View){
        val myCalendar=Calendar.getInstance()
        val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, Syear, Smonth, SdayOfMonth ->
                val Sdate="$SdayOfMonth/${Smonth+1}/$Syear"
                date.setText(Sdate)
                val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate=sdf.parse(Sdate)
                val dim=(theDate!!.time/60000)
                val cd=sdf.parse(sdf.format(System.currentTimeMillis()))
                val cdm=cd!!.time/60000
                val diff=(cdm-dim)/(24*60)
                age.setText(diff.toString())
            }
            ,year,month,day).show()



    }
}