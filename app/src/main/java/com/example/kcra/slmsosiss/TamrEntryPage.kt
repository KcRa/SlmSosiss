package com.example.kcra.slmsosiss

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class TamrEntryPage : AppCompatActivity() {

        var dLogProcess: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tamr_entry_page)

        var bakToMenuPage = findViewById<ImageView>(R.id.back_to_menupage)
        bakToMenuPage.setOnClickListener(View.OnClickListener {
            finish()
            overridePendingTransition(R.anim.plus_100_bak_to_zero,R.anim.zero_bak_to_menus_100)
        })

        var userName = findViewById<EditText>(R.id.username)
        var passWord = findViewById<EditText>(R.id.password)

        var hndlr = Handler()

        var runble = Runnable { kotlin.run {

            if ((userName.text.toString()=="p")&&(passWord.text.toString()=="p")) {
                var intent = Intent(this@TamrEntryPage,TamrEntryNextPage::class.java)
                dLogProcess!!.dismiss()
                startActivity(intent)
                overridePendingTransition(R.anim.menus_100_to_zero,R.anim.zero_to_plus_100)
            }

            else {
                dLogProcess!!.dismiss()
                var dlogErr = Dialog(this@TamrEntryPage)
                dlogErr.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dlogErr.setContentView(R.layout.dialog_error)
                var close = dlogErr.findViewById<TextView>(R.id.close_it)
                close.setOnClickListener(View.OnClickListener {
                    dlogErr.dismiss()
                })
                dlogErr.show()
            }
        } }

        var goToNextPage = findViewById<TextView>(R.id.go_to_tamr_entry_page)
        goToNextPage.setOnClickListener(View.OnClickListener {
            dLogProcess = Dialog(this@TamrEntryPage)
            dLogProcess!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dLogProcess!!.setContentView(R.layout.dialog_processing)

            var closeProcess = dLogProcess!!.findViewById<TextView>(R.id.close_it)
            closeProcess.setOnClickListener(View.OnClickListener {
                dLogProcess!!.dismiss()
                hndlr.removeCallbacks(runble)
            })
            hndlr.postDelayed(runble,1000)
            dLogProcess!!.show()

        })
    }
}