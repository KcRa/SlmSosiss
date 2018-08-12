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
        val sosiss = AnimationUtils.loadAnimation(this,R.anim.rotate)
        //sosiss.fillAfter=true
        sosissInCircle.startAnimation(sosiss)

//      sosiss.setAnimationListener(object : Animation.AnimationListener { // لیسنر برای آغاز یا آخر یا چندباره دیده شدن انیمیشن
//            override fun onAnimationRepeat(p0: Animation?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onAnimationEnd(p0: Animation?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onAnimationStart(p0: Animation?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//        })

    }
}