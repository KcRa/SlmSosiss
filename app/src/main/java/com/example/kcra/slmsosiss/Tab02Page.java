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

import com.example.kcra.slmsosiss.Functionality.OperationZ;

public class Tab02Page extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View Vu02 = inflater.inflate(R.layout.form_fragment,container,false);
        TextView txt = Vu02.findViewById(R.id.TxtVu);
        txt.setText("خبر از ما در مارکت");
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW); // برای واز کردن برتزر یا ویو
                intent.setData(Uri.parse("market://details?id=ir.khabarazma"));
                if (OperationZ.isAppAvailable(getActivity(),"com.farsitel.bazaar") ){ // نکته‌ی گت‌اکتیویتی به جای دیس
                    intent.setPackage("com.farsitel.bazaar"); // به این ترتیب مستقیما کافه‌بازار واز می‌شود (با سرچ اپلیکیشن آی‌دی یا پکیج نیم اپلیکیشن موردنظر)
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        Vu02.setBackgroundColor(getResources().getColor(R.color.color_secondary));
        return Vu02;
    }
}