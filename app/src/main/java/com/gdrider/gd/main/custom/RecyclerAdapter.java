package com.gdrider.gd.main.custom;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gdrider.gd.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<String> mTitle;
    private ArrayList<String> mColor;
    private ArrayList<Integer> mPrice;
    private ArrayList<Integer> mImage;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView_title;
        public TextView textView_price;
        public ImageView imageView_main;
        public ImageButton imageButton_favo;
        public CardView mCardView;

        public ViewHolder(View v) {
            super(v);
            textView_title = (TextView) v.findViewById(R.id.info_text);
            textView_price = (TextView) v.findViewById(R.id.info_price);
            imageView_main = (ImageView) v.findViewById(R.id.info_img);
            imageButton_favo = (ImageButton) v.findViewById(R.id.info_favo);
            mCardView = (CardView) v.findViewById(R.id.card_view);
        }
    }

    public RecyclerAdapter(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image, Context context) {
        this.mTitle = title;
        this.mColor = color;
        this.mPrice = price;
        this.mImage = image;
        this.context = context;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        RecyclerAdapter.ViewHolder vh = new RecyclerAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, final int position) {
        holder.textView_title.setText(mTitle.get(position)+" "+mColor.get(position));
        holder.textView_price.setText("$"+String.valueOf(mPrice.get(position)));
        holder.imageView_main.setImageResource(mImage.get(position));
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "CardView:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }
}
