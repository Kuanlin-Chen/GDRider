package com.gdrider.gd.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdrider.gd.R;
import com.gdrider.gd.main.contract.SeekContract;

import java.util.ArrayList;

public class SeekFragment extends Fragment implements SeekContract.SeekView{

    private final String label = "SeekFragment:";
    private ArrayList<String> productText;
    private ArrayList<Integer> productImage;

    public SeekFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(label+"onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println(label+"onCreateView");
        return inflater.inflate(R.layout.fragment_seek, container, false);
    }

    @Override
    public void setText(ArrayList<String> productText){
        this.productText = productText;
    }

    @Override
    public void setImage(ArrayList<Integer> productImage){
        this.productImage = productImage;
    }
}
