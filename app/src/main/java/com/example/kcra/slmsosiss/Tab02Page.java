package com.example.kcra.slmsosiss;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab02Page extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View Vu02 = inflater.inflate(R.layout.form_fragment,container,false);
        TextView txt = Vu02.findViewById(R.id.TxtVu);
        txt.setText("Segunda!");
        Vu02.setBackgroundColor(getResources().getColor(R.color.color_secondary));
        return Vu02;
    }
}