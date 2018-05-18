package com.gdrider.gd.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdrider.gd.R;
import com.gdrider.gd.main.contract.FavoContract;
import com.gdrider.gd.main.custom.RecyclerAdapter;
import com.gdrider.gd.main.presenter.FavoPresenter;

import java.util.ArrayList;

public class FavoFragment extends Fragment implements FavoContract.FavoView{

    private final String label = "FavoFragment:";
    private ArrayList<String> productText;
    private ArrayList<Integer> productImage;
    private FavoPresenter presenter;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;

    public FavoFragment() {
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
        View view = inflater.inflate(R.layout.fragment_favo, container, false);

        //get data via presenter
        presenter = new FavoPresenter(this);
        presenter.getText();
        presenter.getImage();

        recyclerAdapter = new RecyclerAdapter(productText, productImage, getActivity());
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

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

