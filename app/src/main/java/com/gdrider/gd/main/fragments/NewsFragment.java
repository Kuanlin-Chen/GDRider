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
import com.gdrider.gd.main.custom.NewsAdapter;
import com.gdrider.gd.main.presenter.Presenter;

import java.util.ArrayList;

public class NewsFragment extends Fragment implements Contract.View{

    private final String label = "NewsFragment:";
    private ArrayList<String> productTitle;
    private ArrayList<String> productColor;
    private ArrayList<Integer> productPrice;
    private ArrayList<Integer> productImage;
    private Contract.Presenter presenter;
    private NewsAdapter newsAdapter;
    private RecyclerView recyclerView;

    //Just for testing
    private int[] mAdver = {
            R.drawable.news1,
            R.drawable.news2,
            R.drawable.news3
    };

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
        presenter = new Presenter(this);
        presenter.getNews();

        //Display data in CardView
        newsAdapter = new NewsAdapter(productTitle, productColor, productPrice, productImage, mAdver, getActivity(), presenter);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(),2);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(newsAdapter.getItemViewType(position)){
                    case 0:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(mLayoutManager);

        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        System.out.println(label+"onDestroyView");
        presenter = null;
    }

    @Override
    public void setNews(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image){
        this.productTitle = title;
        this.productColor = color;
        this.productPrice = price;
        this.productImage = image;
    }

    @Override
    public void setEven(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image){

    }

    @Override
    public void setCart(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image){

    }

    @Override
    public void setFavo(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image){

    }

    @Override
    public void setToast(String string){
        Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
    }
}
