package com.example.kcra.slmsosiss

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_tamr_entry_next_page.*

class TamrEntryNextPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tamr_entry_next_page)

        var bakToTamrEntryPage = findViewById<ImageView>(R.id.back_to_tamrentrypage)
        bakToTamrEntryPage.setOnClickListener(View.OnClickListener {
            finish()
        })

        var sosissInCircle = findViewById<CircleImageView>(R.id.sosiss_in_circle)
        var sosiss = AnimationUtils.loadAnimation(this,R.anim.rotate)
        //var sosiss2 = AnimationUtils.loadAnimation(this,R.anim.scale)
        sosiss.fillAfter=true
        //sosiss2.fillAfter=true
        //sosiss.repeatCount=2
        //sosiss_in_circle.startAnimation(sosiss2)
        sosiss_in_circle.startAnimation(sosiss)
//        sosiss.setAnimationListener(Animation.AnimationListener {
//
//        })
    }
}