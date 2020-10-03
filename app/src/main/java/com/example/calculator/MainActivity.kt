package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_answer.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var operator = "."
    var answer = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        equal.setOnClickListener() {
            openAnswer()
        }
        plus.setOnClickListener() {
            operator = "+"
        }
        minus.setOnClickListener() {
            operator = "-"
        }
        multiply.setOnClickListener() {
            operator = "*"
        }
        divide.setOnClickListener() {
            operator = "/"
        }
    }


    private fun findAnswer() {
        val a1:EditText = findViewById(R.id.firstNumber)
        val b1:EditText = findViewById(R.id.secondNumber)
        if (a1.text.toString() == "" || b1.text.toString() == "") {
            answer = 0
            Toast.makeText(this, "Please, enter every number", Toast.LENGTH_SHORT).show()
        } else {
            val a = a1.text.toString().trim().toInt()
            val b = b1.text.toString().trim().toInt()

            if ((operator == "/") and (b1.toString() == "0")) {
                answer = 0
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
            } else if (operator == ".") {
                answer = 0
                Toast.makeText(this, "Operator is not chosen", Toast.LENGTH_SHORT).show()
            } else {
                when (operator) {
                    "+" -> answer = a + b
                    "-" -> answer = (a - b)
                    "*" -> answer = (a * b)
                    "/" -> answer = (a / b)
                }
            }
        }
    }

    private fun openAnswer() {
        findAnswer()
        intent = Intent(this, AnswerActivity::class.java)
        intent.putExtra("answer", answer.toString())
        startActivity(intent)
    }
}