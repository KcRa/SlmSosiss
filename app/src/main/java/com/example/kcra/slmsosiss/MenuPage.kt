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
            overridePendingTransition(R.anim.plus_100_bak_to_zero,R.anim.zero_bak_to_menus_100)
        })

        var goToTamrEntryPage = findViewById<FrameLayout>(R.id.tamr_entry)
        goToTamrEntryPage.setOnClickListener(View.OnClickListener {
            var intent = Intent(this@MenuPage,TamrEntryPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.menus_100_to_zero,R.anim.zero_to_plus_100)
        })

        var goToTamrRecycleViewPage = findViewById<FrameLayout>(R.id.tamr_recycle_view_card_view)
        goToTamrRecycleViewPage.setOnClickListener(View.OnClickListener {
            var intent = Intent(this@MenuPage,TamrListViewPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.menus_100_to_zero,R.anim.zero_to_plus_100)
        })

        var goToTamr1APIPage = findViewById<FrameLayout>(R.id.tamr_api_1)
        goToTamr1APIPage.setOnClickListener(View.OnClickListener {
            var intent = Intent (this@MenuPage, TamrApi1Page::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.menus_100_to_zero,R.anim.zero_to_plus_100)
        })

        var goToTamr2APIPage = findViewById<FrameLayout>(R.id.tamr_api_2)
        goToTamr2APIPage.setOnClickListener(View.OnClickListener {
            var intent = Intent (this@MenuPage,TamrApi2Page::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.menus_100_to_zero,R.anim.zero_to_plus_100)
        })

        var goToTamrTabZ1 = findViewById<FrameLayout>(R.id.tamr_tab1)
        goToTamrTabZ1.setOnClickListener(View.OnClickListener {
            var intent = Intent (this@MenuPage, TamrTabAndFragment1Page::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.menus_100_to_zero,R.anim.zero_to_plus_100)
        })

        var goToTamrTabZ2 = findViewById<FrameLayout>(R.id.tamr_tab2)
        goToTamrTabZ2.setOnClickListener(View.OnClickListener {
            var intent = Intent (this@MenuPage, TamrTabAndFragment2Page::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.menus_100_to_zero,R.anim.zero_to_plus_100)
        })

        var goToTamrMap = findViewById<FrameLayout>(R.id.tamr_map)
        goToTamrMap.setOnClickListener(View.OnClickListener {
            var intent = Intent (this@MenuPage, TamrMapPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.menus_100_to_zero,R.anim.zero_to_plus_100)
        })



    }
}