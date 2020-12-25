package com.example.handgesture

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var backPressTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gesture(view: View?) {
        val third_activity = Intent(this@MainActivity, ThirdActivity::class.java)
        startActivity(third_activity)
        overridePendingTransition(R.anim.slide_from_top, R.anim.slide_to_bottom)
    }

    fun manual(view: View?) {
        val second_activity = Intent(this@MainActivity, SecondActivity::class.java)
        startActivity(second_activity)
        overridePendingTransition(R.anim.slide_from_bottom, R.anim.slide_to_top)
    }

    override fun onBackPressed() {
        if (backPressTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            return
        } else {
            Toast.makeText(baseContext, "Press Back again to Exit", Toast.LENGTH_SHORT).show()
        }
        backPressTime = System.currentTimeMillis()
    }
}