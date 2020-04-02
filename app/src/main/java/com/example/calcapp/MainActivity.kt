package com.example.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.widget.EditText
import java.math.BigDecimal
import android.util.Log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add.setOnClickListener(this)
        subtract.setOnClickListener(this)
        multiply.setOnClickListener(this)
        divide.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(this, ResultActivity::class.java)
        try {
            var num1f = num1.text.toString().toFloat()
            var num2f = num2.text.toString().toFloat()
            var calcNum = 0f
            when (v.id) {
                R.id.add -> calcNum = num1f + num2f
                R.id.subtract -> calcNum = num1f - num2f
                R.id.multiply -> calcNum = num1f * num2f
                R.id.divide -> calcNum = num1f / num2f
            }
            intent.putExtra("ANSWER", calcNum)
            startActivity(intent)
        } catch (e: Exception) {
            Snackbar.make(v, "正しい数値を入力してください", Snackbar.LENGTH_LONG)
                .setAction("ok"){
                    // 単に閉じるのみ
                }.show()
            return
        }
    }
}