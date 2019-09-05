package com.boardinfinity.coffeetime;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment; import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/*
Created By- Rupesh Kumar at July 2019
A part of open source project GitHub Link
https://github.com/rupesh-kumar-lpu/Coffee_Time
 */

public class AboutFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.aboutlayout, viewGroup, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView ia1o = (ImageView) view.findViewById(R.id.ib1);
        ia1o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), coffeeorder2.class);
                i.putExtra("ItemName", "Indonesian Coffee");
                startActivity(i);
            }
        });
        ImageView ia2o = (ImageView) view.findViewById(R.id.ib2);
        ia2o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), coffeeorder2.class);
                i.putExtra("ItemName", "Ethopian Coffee");
                startActivity(i);
            }
        });
        ImageView ia3o = (ImageView) view.findViewById(R.id.ib3);
        ia3o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), coffeeorder2.class);
                i.putExtra("ItemName", "Viennese Coffee");
                startActivity(i);
            }
        });
        ImageView ia4o = (ImageView) view.findViewById(R.id.ib4);
        ia4o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), coffeeorder2.class);
                i.putExtra("ItemName", "Turkish Coffee");
                startActivity(i);
            }
        });
        ImageView ia5o = (ImageView) view.findViewById(R.id.ib5);
        ia5o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), coffeeorder2.class);
                i.putExtra("ItemName", "Vietnamese");
                startActivity(i);
            }
        });
        ImageView ia6o = (ImageView) view.findViewById(R.id.ib6);
        ia6o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), coffeeorder2.class);
                i.putExtra("ItemName", "Portugal Coffee");
                startActivity(i);
            }
        });
    }
}
