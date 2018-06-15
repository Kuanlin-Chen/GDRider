package com.gdrider.gd.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gdrider.gd.R;
import com.gdrider.gd.main.contract.Contract;
import com.gdrider.gd.main.custom.RecyclerHorizonAdapter;
import com.gdrider.gd.main.presenter.Presenter;

import java.util.ArrayList;

public class CartFragment extends Fragment implements Contract.View{

    private final String label = "CartFragment:";
    private ArrayList<String> productTitle;
    private ArrayList<String> productColor;
    private ArrayList<Integer> productPrice;
    private ArrayList<Integer> productImage;
    private Contract.Presenter presenter;
    private RecyclerHorizonAdapter recyclerAdapter;
    private RecyclerView recyclerView;

    public CartFragment() {
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
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        //get data via presenter
        presenter = new Presenter(this);
        presenter.getCart();

        recyclerAdapter = new RecyclerHorizonAdapter(productTitle, productColor, productPrice, productImage, getActivity());
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        System.out.println(label+"onDestroyView");
        presenter = null;
    }

    @Override
    public void setCart(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image){
        this.productTitle = title;
        this.productColor = color;
        this.productPrice = price;
        this.productImage = image;
    }

    @Override
    public void setNews(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image){

    }

    @Override
    public void setEven(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image){

    }

    @Override
    public void setFavo(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image){

    }

    @Override
    public void setToast(String string){
        Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
    }
}
