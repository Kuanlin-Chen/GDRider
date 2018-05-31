package com.gdrider.gd.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdrider.gd.R;
import com.gdrider.gd.main.contract.Contract;
import com.gdrider.gd.main.custom.RecyclerAdapter;
import com.gdrider.gd.main.presenter.EvenPresenter;

import java.util.ArrayList;

public class EvenFragment extends Fragment implements Contract.View{

    private final String label = "EvenFragment:";
    private ArrayList<String> productTitle;
    private ArrayList<String> productColor;
    private ArrayList<Integer> productPrice;
    private ArrayList<Integer> productImage;
    private EvenPresenter presenter;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;

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
        presenter.getTitle();
        presenter.getColor();
        presenter.getPrice();
        presenter.getImage();

        recyclerAdapter = new RecyclerAdapter(productTitle, productColor, productPrice, productImage, getActivity());
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }

    @Override
    public void setTitle(ArrayList<String> productTitle){
        this.productTitle = productTitle;
    }

    @Override
    public void setColor(ArrayList<String> productColor){
        this.productColor = productColor;
    }

    @Override
    public void setPrice(ArrayList<Integer> productPrice){
        this.productPrice = productPrice;
    }

    @Override
    public void setImage(ArrayList<Integer> productImage){
        this.productImage = productImage;
    }
}
