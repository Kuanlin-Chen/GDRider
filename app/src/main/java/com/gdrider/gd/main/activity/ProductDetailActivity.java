package com.gdrider.gd.main.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.gdrider.gd.R;
import com.gdrider.gd.main.contract.Contract;
import com.gdrider.gd.main.custom.ProductDetailAdapter;
import com.gdrider.gd.main.presenter.Presenter;

import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity implements Contract.View{

    private Contract.Presenter presenter;
    private ProductDetailAdapter productDetailAdapter;
    private RecyclerView recyclerView;

    //Just for testing
    private int[] mImage = {
            R.drawable.gdemo,
            R.drawable.gdemo,
            R.drawable.gdemo
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        //get data via presenter
        presenter = new Presenter(this);

        productDetailAdapter = new ProductDetailAdapter("SOL SF3 全罩安全帽", "黑", 2700, mImage, this, presenter);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setAdapter(productDetailAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void setNews(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image){

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
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
