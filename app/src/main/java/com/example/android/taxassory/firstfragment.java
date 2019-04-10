package com.example.android.taxassory;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class firstfragment extends Fragment {
    View myview;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.first_page,container,false);
        return myview;
    }

}
