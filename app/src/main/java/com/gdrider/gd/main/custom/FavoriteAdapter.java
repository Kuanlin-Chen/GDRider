package com.gdrider.gd.main.custom;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gdrider.gd.R;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder>{

    private ArrayList<String> mTitle;
    private ArrayList<String> mColor;
    private ArrayList<Integer> mPrice;
    private ArrayList<Integer> mImage;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView_title;
        public TextView textView_price;
        public Button button_cart;
        public CardView cardView;

        public ViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.imageView);
            textView_title = (TextView) v.findViewById(R.id.info_text);
            textView_price = (TextView) v.findViewById(R.id.info_price);
            button_cart = (Button) v.findViewById(R.id.button_cart);
            cardView = (CardView) v.findViewById(R.id.card_view);
        }
    }

    public FavoriteAdapter(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image, Context context) {
        this.mTitle = title;
        this.mColor = color;
        this.mPrice = price;
        this.mImage = image;
        this.context = context;
    }

    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favorite, parent, false);
        FavoriteAdapter.ViewHolder vh = new FavoriteAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(FavoriteAdapter.ViewHolder holder, final int position) {
        holder.imageView.setImageResource(mImage.get(position));
        holder.textView_title.setText(mTitle.get(position)+" "+mColor.get(position));
        holder.textView_price.setText("$"+String.valueOf(mPrice.get(position)));
        holder.button_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Cart:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }
}
