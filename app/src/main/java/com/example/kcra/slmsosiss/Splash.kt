package com.example.kcra.slmsosiss

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.Toast

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        Toast.makeText(this@Splash,"سلام سوسیـــس !",Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable {kotlin.run {
            var intent = Intent(this@Splash,FirstPage::class.java)
            startActivity(intent)
            finish()
        }},3000)

    }
}
