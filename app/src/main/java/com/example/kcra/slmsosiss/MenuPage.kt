package com.example.kcra.slmsosiss

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView

class MenuPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_page)

        var bakToFirstPage = findViewById<ImageView>(R.id.back_to_firstpage)
        bakToFirstPage.setOnClickListener(View.OnClickListener {
            finish()
            overridePendingTransition(R.anim.exit_bak,R.anim.enter_bak)
        })

        var goToTamrEntryPage = findViewById<FrameLayout>(R.id.tamr_entry)
        goToTamrEntryPage.setOnClickListener(View.OnClickListener {
            var intent = Intent(this@MenuPage,TamrEntryPage::class.java)
            startActivity(intent)
        })

        var goToTamrRecycleViewPage = findViewById<FrameLayout>(R.id.tamr_recycle_view_card_view)
        goToTamrRecycleViewPage.setOnClickListener(View.OnClickListener {
            var intent = Intent(this@MenuPage,TamrListViewPage::class.java)
            startActivity(intent)
        })

        var goToTamr1APIPage = findViewById<FrameLayout>(R.id.tamr_api_1)
        goToTamr1APIPage.setOnClickListener(View.OnClickListener {
            var intent = Intent (this@MenuPage, TamrApi1Page::class.java)
            startActivity(intent)
        })

        var goToTamr2APIPage = findViewById<FrameLayout>(R.id.tamr_api_2)
        goToTamr2APIPage.setOnClickListener(View.OnClickListener {
            var intent = Intent (this@MenuPage,TamrApi2Page::class.java)
            startActivity(intent)
        })

        var goToTamrTabZ1 = findViewById<FrameLayout>(R.id.tamr_tab1)
        goToTamrTabZ1.setOnClickListener(View.OnClickListener {
            var intent = Intent (this@MenuPage, TamrTabAndFragment1Page::class.java)
            startActivity(intent)
        })

        var goToTamrTabZ2 = findViewById<FrameLayout>(R.id.tamr_tab2)
        goToTamrTabZ2.setOnClickListener(View.OnClickListener {
            var intent = Intent (this@MenuPage, TamrTabAndFragment2Page::class.java)
            startActivity(intent)
        })



    }
}