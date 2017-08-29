package com.example.administrator.kotlin.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.kotlin.R;


/**
 * Created by luosuihan on 2017/7/14.
 */
public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    //一定要实现的方法
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("tagluo","sssssssssssssssssss");
        View view = inflater.inflate(R.layout.fragment_main1,null);

        return view;
    }
}
