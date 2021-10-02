package com.example.calculator.controller

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuItemImpl
import com.example.calculator.model.Calculate
import com.example.calculator.R
import com.example.calculator.util.ButtonState

class MainActivity : AppCompatActivity() {

    lateinit var calculate: Calculate
    lateinit var answerText: TextView
    lateinit var formulaText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculate = Calculate()

        this.initAllCListener()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.help -> {
                Toast.makeText(this,"这是帮助",Toast.LENGTH_SHORT).show()
            }
            R.id.exit -> {
                android.os.Process.killProcess(android.os.Process.myPid())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initAllCListener() {
        answerText = findViewById(R.id.answer_text)
        formulaText = findViewById(R.id.formula_text)

        this.clickListener(findViewById<Button>(R.id.fx_button), ButtonState.FX)
        this.clickListener(findViewById<Button>(R.id.tran_button), ButtonState.TRAN)
        this.clickListener(findViewById<Button>(R.id.clear_button), ButtonState.CLEAR)
        this.clickListener(findViewById<Button>(R.id.root_button), ButtonState.Root)
        this.clickListener(findViewById<Button>(R.id.percent_button), ButtonState.PERCENT)
        this.clickListener(findViewById<Button>(R.id.delete_button), ButtonState.DELETE)
        this.clickListener(findViewById<Button>(R.id.divide_button), ButtonState.DIVIDE)
        this.clickListener(findViewById<Button>(R.id.multiply_button), ButtonState.MUTIPLY)
        this.clickListener(findViewById<Button>(R.id.minus_button), ButtonState.MINUS)
        this.clickListener(findViewById<Button>(R.id.plus_button), ButtonState.PLUS)
        this.clickListener(findViewById<Button>(R.id.equals_button), ButtonState.EQUALS)
        this.clickListener(findViewById<Button>(R.id.decimal_button), ButtonState.DECIMAL)

        this.clickListener(findViewById<Button>(R.id.btn_9), 9)
        this.clickListener(findViewById<Button>(R.id.btn_8), 8)
        this.clickListener(findViewById<Button>(R.id.btn_7), 7)
        this.clickListener(findViewById<Button>(R.id.btn_6), 6)
        this.clickListener(findViewById<Button>(R.id.btn_5), 5)
        this.clickListener(findViewById<Button>(R.id.btn_4), 4)
        this.clickListener(findViewById<Button>(R.id.btn_3), 3)
        this.clickListener(findViewById<Button>(R.id.btn_2), 2)
        this.clickListener(findViewById<Button>(R.id.btn_1), 1)
        this.clickListener(findViewById<Button>(R.id.btn_0), 0)

    }

    private fun clickListener(button: Button,num: Int) {
        button.setOnClickListener {
            when(num) {
                ButtonState.FX -> {
                    val intent: Intent = Intent()
                    intent.setClass(this, FunctionActivity::class.java)
                    startActivity(intent)
                }
                ButtonState.TRAN -> {
                    val intent: Intent = Intent()
                    intent.setClass(this, TranActivity::class.java)
                    startActivity(intent)
                }
                ButtonState.CLEAR -> {
                    calculate.clear()
                }
                ButtonState.DELETE -> {
                    calculate.delete()
                }

                ButtonState.EQUALS -> {
                    calculate.equals()
                }

                ButtonState.Root -> {
                    calculate.root()
                }

                ButtonState.PERCENT -> {
                    calculate.percent()
                }

                ButtonState.DECIMAL -> {
                    calculate.decimal()
                }

                ButtonState.PLUS -> {
                    calculate.arithmetic(ButtonState.PLUS)
                }

                ButtonState.MINUS -> {
                    calculate.arithmetic(ButtonState.MINUS)
                }

                ButtonState.MUTIPLY -> {
                    calculate.arithmetic(ButtonState.MUTIPLY)
                }

                ButtonState.DIVIDE -> {
                    calculate.arithmetic(ButtonState.DIVIDE)
                }

                else -> {
                    calculate.appendNum(num)
                }
            }
            answerText.setText(calculate.answer)
            formulaText.setText(
                calculate
                    .toString()
                    .replace('/', '÷')
                    .replace('*', '×')
            )
        }
    }

}