package com.example.kcra.slmsosiss;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TamrApiPage extends AppCompatActivity {

    LayoutInflater lIF;
    apiToListAdapter aDptr;
    ArrayList<String> toLstVu = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamr_api_page);

        lIF = LayoutInflater.from(this);
        ListView lVu = findViewById(R.id.list_vu_api);
        aDptr = new apiToListAdapter();
        lVu.setAdapter(aDptr);

        ImageView bakToMenu = findViewById(R.id.back_to_menupage);
        bakToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView pushMe = findViewById(R.id.push_me_to_api);
        pushMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Refresh r = new Refresh();
                r.execute();

            }
        });
    }

    class apiToListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return toLstVu.size();
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
        public View getView(int poZtion, View rowZ, ViewGroup viewGroup) {
            VuHldr VH = new VuHldr();
            if (rowZ == null) {
                rowZ = lIF.inflate(R.layout.surface_to_list_view,null);
                VH.nAME = rowZ.findViewById(R.id.api_name);
                rowZ.setTag(VH);
            }
            else {
                VH = (VuHldr) rowZ.getTag();
            }
            VH.nAME.setText(String.valueOf(toLstVu.get(poZtion)));
            return rowZ;
        }
    }

    class VuHldr {
        TextView nAME;
    }

    class Refresh extends AsyncTask {

        OkHttpClient clnt;
        Request rqst;
        Response resp;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            clnt = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30,TimeUnit.SECONDS)
                    .readTimeout(30,TimeUnit.SECONDS)
                    .build();
            rqst = new Request.Builder()
                    .url("http://www.shopiona.ir/api/v1/category/all")
                    .get()
                    .build();
        }

        @Override
        protected Object doInBackground(Object[] objects) {

            try {
                resp = clnt.newCall(rqst).execute();
                return resp.body().string();
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (o!=null) {
                if (resp.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(String.valueOf(o));
                        JSONArray jsonArray = jsonObject.getJSONArray("items");
                        for (int i = 0; i < jsonArray.length() ; i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            String namesFromJSON = jsonObject1.getString("name");
                            toLstVu.add(namesFromJSON);
                            aDptr.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        Toast.makeText(TamrApiPage.this,"خطای ۱",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(TamrApiPage.this,"خطای ۱",Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(TamrApiPage.this,"خطای ۲",Toast.LENGTH_LONG).show();
            }
        }
    }
}
