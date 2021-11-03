package com.example.calculator.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.view.View
import com.example.calculator.R
import android.widget.EditText
import android.widget.TextView
import android.widget.Button





class FunctionActivity: AppCompatActivity() {
    lateinit var sinButton: Button
    lateinit var cosButton:Button
    lateinit var binButton:Button
    lateinit var octButton:Button
    lateinit var decButton:Button
    lateinit var hexButton:Button
    lateinit var sinResult: TextView
    lateinit var cosResult:TextView
    lateinit var sinValue: EditText
    lateinit var cosValue:EditText
    lateinit var binValue:EditText
    lateinit var octValue:EditText
    lateinit var decValue:EditText
    lateinit var hexValue:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function)
        initComponents()
    }

    private fun initComponents() {
        sinButton = findViewById(R.id.sin_button)
        cosButton = findViewById<Button>(R.id.cos_button)
        sinResult = findViewById(R.id.sinResult_text)
        cosResult = findViewById<TextView>(R.id.cosResult_text)
        sinValue = findViewById(R.id.sinValue_text)
        cosValue = findViewById<EditText>(R.id.cosValue_text)
        binButton = findViewById<Button>(R.id.bin_button)
        octButton = findViewById<Button>(R.id.oct_button)
        decButton = findViewById<Button>(R.id.dec_button)
        hexButton = findViewById<Button>(R.id.hex_button)
        binValue = findViewById<EditText>(R.id.binValue_text)
        octValue = findViewById<EditText>(R.id.octValue_text)
        decValue = findViewById<EditText>(R.id.decValue_text)
        hexValue = findViewById<EditText>(R.id.hexValue_text)
        sinButton.setOnClickListener(View.OnClickListener { sin() })
        cosButton.setOnClickListener(View.OnClickListener { cos() })
        binButton.setOnClickListener(View.OnClickListener { bin() })
        octButton.setOnClickListener(View.OnClickListener { oct() })
        decButton.setOnClickListener(View.OnClickListener { dec() })
        hexButton.setOnClickListener(View.OnClickListener { hex() })
    }

    private fun sin() {
        val s = sinValue.text.toString()
        if (s.isEmpty()) {
            return
        }
        val value = sinValue.text.toString().toDouble()
        val result = Math.sin(value)
        sinResult.text = result.toString()
    }

    private fun cos() {
        val s: String = cosValue.getText().toString()
        if (s.isEmpty()) {
            return
        }
        val value: Double = cosValue.getText().toString().toDouble()
        val result = Math.cos(value)
        cosResult.text = result.toString()
    }

    private fun bin() {
        val s: String = binValue.getText().toString()
        if (s.isEmpty()) {
            return
        }
        val value: Int
        value = try {
            Integer.valueOf(s, 2)
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "输入格式有误，请重新输入", Toast.LENGTH_LONG).show()
            return
        }
        octValue.setText(Integer.toOctalString(value))
        hexValue.setText(Integer.toHexString(value))
        decValue.setText(Integer.valueOf(value).toString())
    }

    private fun oct() {
        val s: String = octValue.getText().toString()
        if (s.isEmpty()) {
            return
        }
        val value: Int
        value = try {
            Integer.valueOf(s, 8)
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "输入格式有误，请重新输入", Toast.LENGTH_LONG).show()
            return
        }
        binValue.setText(Integer.toBinaryString(value))
        hexValue.setText(Integer.toHexString(value))
        decValue.setText(Integer.valueOf(value).toString())
    }

    private fun dec() {
        val s: String = decValue.getText().toString()
        if (s.isEmpty()) {
            return
        }
        val value: Int
        value = try {
            Integer.valueOf(s, 10)
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "输入格式有误，请重新输入", Toast.LENGTH_LONG).show()
            return
        }
        binValue.setText(Integer.toBinaryString(value))
        hexValue.setText(Integer.toHexString(value))
        octValue.setText(Integer.toOctalString(value))
    }

    private fun hex() {
        val s: String = hexValue.getText().toString()
        if (s.isEmpty()) {
            return
        }
        val value: Int
        value = try {
            Integer.valueOf(s, 16)
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "输入格式有误，请重新输入", Toast.LENGTH_LONG).show()
            return
        }
        binValue.setText(Integer.toBinaryString(value))
        octValue.setText(Integer.toOctalString(value))
        decValue.setText(Integer.valueOf(value).toString())
    }

}