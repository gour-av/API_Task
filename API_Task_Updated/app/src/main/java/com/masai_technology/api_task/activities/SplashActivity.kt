package com.masai_technology.api_task.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.masai_technology.api_task.R

/***
 * In this activity we can able see the splash screen
 */

class SplashActivity : AppCompatActivity() {
    private val mhandler: Handler = Handler()
    private val delay = 5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mhandler.postDelayed({
           OpenActivity()
        }, delay.toLong())
    }

    private fun OpenActivity() {
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }



    override fun onStop() {
        super.onStop()
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
    }


}