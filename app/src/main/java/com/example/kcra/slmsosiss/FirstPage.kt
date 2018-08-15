package com.example.kcra.slmsosiss

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

class FirstPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)

        var goToMenuPage = findViewById<TextView>(R.id.go_to_menu_page)
        goToMenuPage.setOnClickListener(View.OnClickListener {
            var intent = Intent(this@FirstPage,MenuPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.menus_100_to_zero,R.anim.zero_to_plus_100)
        })
    }
}