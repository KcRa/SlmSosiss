package com.example.kcra.slmsosiss;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;

public class TamrTabAndFragment1Page extends AppCompatActivity {

     boolean isPlay = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamr_tab_and_fragment_1_page);

        ImageView bakToMenu = findViewById(R.id.back_to_menupage);
        bakToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.plus_100_bak_to_zero,R.anim.zero_bak_to_menus_100);
            }
        });

        final MediaPlayer mP = MediaPlayer.create(TamrTabAndFragment1Page.this,R.raw.a);
        final ImageView play = findViewById(R.id.play_muzik);
        final ImageView pause = findViewById(R.id.pause_muzik);

        final TabHost tbHst = findViewById(R.id.tab_host); //از جنس تب‌هاست متغیر می‌سازیم و فایندبای‌آی‌دی می‌کنیم
        tbHst.setup();

        TabHost.TabSpec tab1 = tbHst.newTabSpec("One"); // از کلاس تب‌اسپک آبجکت می‌سازیم و تگ می‌دهیم
        tab1.setContent(R.id.primary); // برای آبکجت ست‌کانتنت می‌کنیم با آی‌دی یکی از سه‌ ریلتیو‌لی‌آوت موجود در فریم لی‌آوت
        tab1.setIndicator("1'st"); // برای آبجکت ست ایندیکیتور می‌کنیم (روی خود تب نوشته می‌شود)
        tbHst.addTab(tab1); // آبجکت اول را (از تب‌اسپک ساختیم) اضافه می‌کنیم به آبجکتی که از تب‌هاست ساخته بودیم

        TabHost.TabSpec tab2 = tbHst.newTabSpec("Two");
        tab2.setContent(R.id.secondary);
        tab2.setIndicator("2'nd");
        tbHst.addTab(tab2);

        TabHost.TabSpec tab3 = tbHst.newTabSpec("Three");
        tab3.setContent(R.id.sosiss);
        tab3.setIndicator("3'rd");
        tbHst.addTab(tab3);


        TabHost.OnTabChangeListener tb = new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) { // برای آبکجتی که از تب‌هاست ساخته بودیم تب‌چنجد‌لیستنر ست می‌کنیم
                switch (s) { //  با سویچ و به ازای تگ‌هایی که به هر تب نسبت دادیم می‌تونیم کد‌های نه خیلی مفصل بنویسیم
                    case "One" :
                        if (!isPlay) {
                            play.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    play.setVisibility(View.GONE);
                                    mP.start();
                                    isPlay = true;
                                    pause.setVisibility(View.VISIBLE);
                                }
                            });
                        }
                        else {
                            pause.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    pause.setVisibility(View.GONE);
                                    mP.pause();
                                    isPlay = false;
                                    play.setVisibility(View.VISIBLE);
                                }
                            });
                        }
                        Toast.makeText(TamrTabAndFragment1Page.this,"صفحه اول",Toast.LENGTH_SHORT).show();
                        break;
                    case "Two" :
                        Toast.makeText(TamrTabAndFragment1Page.this,"صفحه دوم",Toast.LENGTH_SHORT).show();
                        break;
                    case "Three" :
                        Toast.makeText(TamrTabAndFragment1Page.this,"صفحه سوم",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        tbHst.setOnTabChangedListener(tb);
        tb.onTabChanged("One");
    }
}
