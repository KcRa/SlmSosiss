package com.example.kcra.slmsosiss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.kcra.slmsosiss.Model.AddRemove;

import static com.example.kcra.slmsosiss.R.id.btm_remove;

public class TamrListViewPage extends AppCompatActivity {

    LayoutInflater lIF;
    AdReAdapter aDptr;
    ArrayList<AddRemove> AdRe = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_tamr_list_view_page);

        lIF = LayoutInflater.from(this);

        ListView LV;
        LV = findViewById(R.id.list_view);
        aDptr = new AdReAdapter();
        LV.setAdapter(aDptr);

        //LV.setAdapter(new AdReAdapter());

        ImageView aDD = findViewById(R.id.btm_add);
        aDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AddRemove n = new AddRemove();
                n.numb = AdRe.size()+1;
                AdRe.add(n);
                aDptr.notifyDataSetChanged();
            }
        });

            ImageView rEMOVE = findViewById(btm_remove);
            rEMOVE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ((AdRe.size())>0) {
                        AdRe.remove(AdRe.size()-1);
                        aDptr.notifyDataSetChanged();
                    }
                }
            });

        ImageView bakToMenuPage = findViewById(R.id.back_to_menupage);
        bakToMenuPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    class AdReAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return AdRe.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View cardVu, ViewGroup viewGroup) {
            VuHldr VH = new VuHldr();
            if (cardVu == null) {
                cardVu = lIF.inflate(R.layout.card_view_add_remove,null);
                VH.nUMB = cardVu.findViewById(R.id.card_view_no);
                cardVu.setTag(VH);

            }
            else {
                VH = (VuHldr) cardVu.getTag();
            }

            VH.nUMB.setText(String.valueOf(AdRe.get(position).numb));
            return cardVu;
        }

        class VuHldr {
            TextView nUMB;
        }
    }
}
