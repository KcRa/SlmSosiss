package com.example.kcra.slmsosiss;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab01Page extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//      return super.onCreateView(inflater, container, savedInstanceState); // این خط را احتیاج نداریم و می‌شود که کلا پاک کنیم
        View Vu01 = inflater.inflate(R.layout.form_fragment,container,false);
        TextView txt = Vu01.findViewById(R.id.TxtVu);
        txt.setText("خبر از ما");
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://khabarazma.com"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        Vu01.setBackgroundColor(getResources().getColor(R.color.color_primary));
        return Vu01;
    }
}
