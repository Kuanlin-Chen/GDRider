package com.gdrider.gd.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdrider.gd.R;
import com.gdrider.gd.main.contract.EvenContract;
import com.gdrider.gd.main.presenter.EvenPresenter;

import java.util.ArrayList;

public class EvenFragment extends Fragment implements EvenContract.EvenView{

    private final String label = "EvenFragment:";
    private ArrayList<String> productText;
    private ArrayList<Integer> productImage;
    private EvenPresenter presenter;

    public EvenFragment() {
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
        View view = inflater.inflate(R.layout.fragment_even, container, false);

        //get data via presenter
        presenter = new EvenPresenter(this);
        presenter.getText();
        presenter.getImage();

        return view;
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
