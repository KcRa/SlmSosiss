package com.example.kcra.slmsosiss;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

public class TamrTabAndFragment2Page extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamr_tab_and_fragment_2_page);

        ImageView bakToMenu = findViewById(R.id.back_to_menupage);
        bakToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.plus_100_bak_to_zero,R.anim.zero_bak_to_menus_100);
            }
        });

        FragmentTabHost tbHst = findViewById(R.id.fragment_tab_host);
        tbHst.setup(this,getSupportFragmentManager(),R.id.contentZZZ);

        TabHost.TabSpec tab1 = tbHst.newTabSpec("One");
        tab1.setIndicator("1'st");
        tbHst.addTab(tab1,Tab01Page.class,null);

        TabHost.TabSpec tab2 = tbHst.newTabSpec("Two");
        tab2.setIndicator("2'nd");
        tbHst.addTab(tab2,Tab02Page.class,null);

        TabHost.TabSpec tab3 = tbHst.newTabSpec("Three");
        tab3.setIndicator("3'rd");
        tbHst.addTab(tab3,Tab03Page.class,null);
    }
}
