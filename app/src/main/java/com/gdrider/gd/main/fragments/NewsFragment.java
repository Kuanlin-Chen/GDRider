package com.gdrider.gd.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdrider.gd.R;
import com.gdrider.gd.main.contract.NewsContract;
import com.gdrider.gd.main.custom.RecyclerAdapter;
import com.gdrider.gd.main.presenter.NewsPresenter;

import java.util.ArrayList;

public class NewsFragment extends Fragment implements NewsContract.NewsView{

    private final String label = "NewsFragment:";
    private ArrayList<String> productTitle;
    private ArrayList<String> productColor;
    private ArrayList<Integer> productPrice;
    private ArrayList<Integer> productImage;
    private NewsContract.NewsPresenter presenter;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;

    public NewsFragment() {
        //Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(label+"onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        System.out.println(label+"onCreateView");
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        //get data via presenter
        presenter = new NewsPresenter(this);
        presenter.getAllData();

        recyclerAdapter = new RecyclerAdapter(productTitle, productColor, productPrice, productImage, getActivity());
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }

    @Override
    public void setAllData(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image){
        this.productTitle = title;
        this.productColor = color;
        this.productPrice = price;
        this.productImage = image;
    }
}
