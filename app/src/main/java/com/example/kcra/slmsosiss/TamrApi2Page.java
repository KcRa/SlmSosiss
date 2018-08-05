package com.example.kcra.slmsosiss;

import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TamrApi2Page extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamr2_api_page);

        ImageView bakToMenu = findViewById(R.id.back_to_menupage);
        bakToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Refresh r = new Refresh();
        r.execute();

    }

    class Refresh extends AsyncTask {

        OkHttpClient clnt;
        Request rqst;
        Response rspons;

        Dialog dLogCnctng;
        Dialog dLogErr;

        ImageView prdctPict = findViewById(R.id.product_pic);
        TextView storeName = findViewById(R.id.TxVu_store_name);
        TextView prdctName = findViewById(R.id.TxVu_product_name);
        TextView prdctPrice = findViewById(R.id.TxVu_product_price);
        TextView prdcrDescription = findViewById(R.id.TxVu_product_description);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dLogCnctng = new Dialog(TamrApi2Page.this);
            dLogCnctng.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dLogCnctng.setContentView(R.layout.dialog_connecting);
            dLogCnctng.show();



            clnt = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30,TimeUnit.SECONDS)
                    .writeTimeout(30,TimeUnit.SECONDS)
                    .build();

            RequestBody bud = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject);
            rqst = new Request.Builder()
                    .url("http://www.shopiona.ir/api/v1/product/detail/10034")
                    .addHeader()
                    .post(bud)
                    .build();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                rspons = clnt.newCall(rqst).execute();
                return rspons.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            dLogCnctng.dismiss();
            if (o != null) {
                if (rspons.isSuccessful()) {
                    try {

                        JSONObject jsonObject = new JSONObject(String.valueOf(o));
                        String pic = jsonObject.getString("primaryImage");
                        Picasso.get().load(pic).into(prdctPict);
                        storeName.setText(jsonObject.getString("storeName"));
                        prdctName.setText(jsonObject.getString("name"));
                        prdctPrice.setText(jsonObject.getString("price"));
                        prdcrDescription.setText(jsonObject.getString("description"));

                    } catch (JSONException e) {
                        Toast.makeText(TamrApi2Page.this,"خطای ۱",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(TamrApi2Page.this,"خطای ۱",Toast.LENGTH_LONG).show();
                }
            }
            else {
                dLogErr = new Dialog(TamrApi2Page.this);
                dLogErr.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dLogErr.setContentView(R.layout.dialog_connecting_error);

                TextView tryAgn = dLogErr.findViewById(R.id.try_again);
                tryAgn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dLogErr.dismiss();
                        Refresh r = new Refresh();
                        r.execute();
                    }
                });
                dLogErr.show();
                TextView closeErr = dLogErr.findViewById(R.id.close_it);
                closeErr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dLogErr.dismiss();
                    }
                });

            }
        }
    }
}
