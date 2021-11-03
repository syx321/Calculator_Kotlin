package com.example.calculator.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.R
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.EditText
import java.math.BigDecimal


class TranActivity: AppCompatActivity() {
    lateinit var lengthValue: EditText
    lateinit var volumeValue:EditText
    lateinit var lengthResult: TextView
    lateinit var volumeResult:TextView
    lateinit var lengthValues: RadioGroup
    lateinit var lengthResults:RadioGroup
    lateinit var volumeValues:RadioGroup
    lateinit var volumeResults:RadioGroup
    lateinit var length: BigDecimal
    lateinit var volume: BigDecimal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tran)
        initComponents()
    }

    private fun initComponents() {
        lengthValue = findViewById(R.id.length_value_text)
        volumeValue = findViewById<EditText>(R.id.volume_value_text)
        lengthResult = findViewById(R.id.length_result_text)
        volumeResult = findViewById<TextView>(R.id.volume_result_text)
        lengthValues = findViewById(R.id.length_values)
        lengthResults = findViewById<RadioGroup>(R.id.length_results)
        lengthValues.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val input = BigDecimal(lengthValue.getText().toString())
            when (checkedId) {
                R.id.length_value_km -> length = input.multiply(BigDecimal("1000"))
                R.id.length_value_m -> length = input
                R.id.length_value_cm -> length = input.multiply(BigDecimal("0.01"))
                R.id.length_value_mm -> length = input.multiply(BigDecimal("0.001"))
            }
        })
        lengthResults.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val result: String
            var temp = BigDecimal(0)
            when (checkedId) {
                R.id.length_result_km -> temp = length.multiply(BigDecimal("0.001"))
                R.id.length_result_m -> temp = length
                R.id.length_result_cm -> temp = length.multiply(BigDecimal("100"))
                R.id.length_result_mm -> temp = length.multiply(BigDecimal("1000"))
            }
            result = temp.toString()
            lengthResult.setText(result)
        })
        volumeValues = findViewById<RadioGroup>(R.id.volume_values)
        volumeResults = findViewById<RadioGroup>(R.id.volume_results)
        volumeValues.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val input = BigDecimal(volumeValue.getText().toString())
            when (checkedId) {
                R.id.volume_value_m2 -> volume = input.multiply(BigDecimal("1000"))
                R.id.volume_value_dm2 -> volume = input
                R.id.volume_value_cm2 -> volume = input.multiply(BigDecimal("0.001"))
            }
        })
        volumeResults.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val result: String
            var temp = BigDecimal(0)
            when (checkedId) {
                R.id.volume_result_m2 -> temp = volume.multiply(BigDecimal("0.001"))
                R.id.volume_result_dm2 -> temp = volume
                R.id.volume_result_cm2 -> temp = volume.multiply(BigDecimal("1000"))
            }
            result = temp.toString()
            volumeResult.setText(result)
        })
    }


}