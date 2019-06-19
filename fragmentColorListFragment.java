package com.hungrok.myfragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class ColorListFragment extends ListFragment {
    private OnColorSelectedListener mListener ;
    private int count = 0 ;

    public void setOnColorSelectedListener(OnColorSelectedListener abc){
        mListener = abc ;
    }

    interface OnColorSelectedListener{
        public void onColorSelected(int color) ;
    }

    /*
    @Override
    public void onAttach(Context context){
        super.onAttach(context) ;
        try{

        }
    }
    */

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> colorList = Arrays.asList("Red","Green","Blue") ;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,colorList) ;
        setListAdapter(adapter) ;

        System.out.printf("ColorListFragment-onViewCreated \n") ;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        count++ ;
        int value = count%3 ;
        if (value==0) mListener.onColorSelected(Color.RED);
        if (value==1) mListener.onColorSelected(Color.GREEN);
        if (value==2) mListener.onColorSelected(Color.BLUE);

    }

}
