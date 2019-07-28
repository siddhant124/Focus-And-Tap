package com.example.taptap

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_touch_tap.*

class TouchTap : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_tap)

    btn_level2.setOnClickListener {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
        btn_level1.setOnClickListener {
            val intent = Intent(this,Level1::class.java)
            startActivity(intent)
        }
        btn_level3.setOnClickListener {
            val intent = Intent(this,Level3::class.java)
            startActivity(intent)
        }
    }
}
