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


public class HomeFragment extends Fragment {
View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){


        return inflater.inflate(R.layout.homelayout, viewGroup, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView ia1o=(ImageView)view.findViewById(R.id.ia1);
        ia1o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), opencoffe.class);
                i.putExtra("ItemName","Cappuccino");
                startActivity(i);
            }
        });
        ImageView ia2o=(ImageView)view.findViewById(R.id.ia2);
        ia2o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), opencoffe.class);
                i.putExtra("ItemName","Macchiato");
                startActivity(i);
            }
        });
        ImageView ia3o=(ImageView)view.findViewById(R.id.ia3);
        ia3o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), opencoffe.class);
                i.putExtra("ItemName","Latte");
                startActivity(i);
            }
        });
        ImageView ia4o=(ImageView)view.findViewById(R.id.ia4);
        ia4o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), opencoffe.class);
                i.putExtra("ItemName","Americano");
                startActivity(i);
            }
        });
        ImageView ia5o=(ImageView)view.findViewById(R.id.ia5);
        ia5o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), opencoffe.class);
                i.putExtra("ItemName","Cafemocha");
                startActivity(i);
            }
        });
        ImageView ia6o=(ImageView)view.findViewById(R.id.ia6);
        ia6o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), opencoffe.class);
                i.putExtra("ItemName","Frappe");
                startActivity(i);
            }
        });
    }
}