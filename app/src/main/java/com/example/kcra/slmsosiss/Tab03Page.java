package com.example.kcra.slmsosiss;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab03Page extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View Vu03 = inflater.inflate(R.layout.form_fragment,container,false);
        TextView txt = Vu03.findViewById(R.id.TxtVu);
        txt.setText("Tercera!");
        Vu03.setBackgroundColor(getResources().getColor(R.color.sausage));
        return Vu03;
    }
}
