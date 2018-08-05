package com.example.kcra.slmsosiss

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView

class TamrEntryNextPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tamr_entry_next_page)

        var bakToTamrEntryPage = findViewById<ImageView>(R.id.back_to_tamrentrypage)
        bakToTamrEntryPage.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}