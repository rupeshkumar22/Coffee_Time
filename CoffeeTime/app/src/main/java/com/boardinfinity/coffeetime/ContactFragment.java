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


public class ContactFragment extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return inflater.inflate(R.layout.contactlayout, viewGroup, false);
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView ia1o = (ImageView) view.findViewById(R.id.ic1);
        ia1o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), coffeeorder3.class);
                i.putExtra("ItemName", "Cookies");
                startActivity(i);
            }
        });
        ImageView ia2o = (ImageView) view.findViewById(R.id.ic2);
        ia2o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), coffeeorder3.class);
                i.putExtra("ItemName", "Caremel Cake");
                startActivity(i);
            }
        });
        ImageView ia3o = (ImageView) view.findViewById(R.id.ic3);
        ia3o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), coffeeorder3.class);
                i.putExtra("ItemName", "Choko Cake");
                startActivity(i);
            }
        });
        ImageView ia4o = (ImageView) view.findViewById(R.id.ic4);
        ia4o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), coffeeorder3.class);
                i.putExtra("ItemName", "Choco Bar");
                startActivity(i);
            }
        });
        ImageView ia5o = (ImageView) view.findViewById(R.id.ic5);
        ia5o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), coffeeorder3.class);
                i.putExtra("ItemName", "Milk Shake");
                startActivity(i);
            }
        });
        ImageView ia6o = (ImageView) view.findViewById(R.id.ic6);
        ia6o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), coffeeorder3.class);
                i.putExtra("ItemName", "Orange Juice");
                startActivity(i);
            }
        });
    }
}