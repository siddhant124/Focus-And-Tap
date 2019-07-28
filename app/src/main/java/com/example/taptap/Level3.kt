package com.example.taptap

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_level3.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.imageView1
import kotlinx.android.synthetic.main.activity_main.imageView10
import kotlinx.android.synthetic.main.activity_main.imageView11
import kotlinx.android.synthetic.main.activity_main.imageView12
import kotlinx.android.synthetic.main.activity_main.imageView2
import kotlinx.android.synthetic.main.activity_main.imageView3
import kotlinx.android.synthetic.main.activity_main.imageView4
import kotlinx.android.synthetic.main.activity_main.imageView5
import kotlinx.android.synthetic.main.activity_main.imageView6
import kotlinx.android.synthetic.main.activity_main.imageView7
import kotlinx.android.synthetic.main.activity_main.imageView8
import kotlinx.android.synthetic.main.activity_main.imageView9
import kotlinx.android.synthetic.main.activity_main.scoreText
import kotlinx.android.synthetic.main.activity_main.timeText
import java.util.*
import kotlin.random.Random

class Level3 : AppCompatActivity() {

    var score: Int = 0
    var imageArray = ArrayList<ImageView>()
    var handler : Handler = Handler()
    var runnable :Runnable = Runnable{}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level3)
        score = 0

        imageArray = arrayListOf(imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12)
        hideImages()

        btn_back.setOnClickListener {
            val intent = Intent(this,TouchTap::class.java)
            startActivity(intent)
        }

        object: CountDownTimer(10000,1000)
        {
            override fun onFinish() {
                timeText.text = "Time Up"
                handler.removeCallbacks(runnable)
                for(images in imageArray)
                    images.visibility = View.INVISIBLE
            }

            @SuppressLint("SetTextI18n")
            override fun onTick(p0: Long) {
                timeText.text = "Timer: " + p0/1000
            }

        }.start()
    }
    fun hideImages()
    {
        runnable = object : Runnable {
            override fun run() {

                for (images in imageArray) {
                    images.visibility = View.INVISIBLE
                }
                val random = Random
                val index = random.nextInt(0,11)
                imageArray[index].visibility = View.VISIBLE
                handler.postDelayed(runnable,300)
            }
        }
        handler.post(runnable)
    }


    @SuppressLint("SetTextI18n")
    fun increaseScore(view: View)
    {
        score++
        scoreText.text = "Score: "+score
    }
}
