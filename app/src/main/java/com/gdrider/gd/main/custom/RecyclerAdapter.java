package com.gdrider.gd.main.custom;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gdrider.gd.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<String> mTitle;
    private List<String> mColor;
    private List<Integer> mPrice;
    private List<Integer> mImage;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public ImageView mImageView;
        public CardView mCardView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.info_text);
            mImageView = (ImageView) v.findViewById(R.id.info_img);
            mCardView = (CardView) v.findViewById(R.id.card_view);
        }
    }

    public RecyclerAdapter(List<String> title, List<String> color, List<Integer> price, List<Integer> image, Context context) {
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
        holder.mTextView.setText(mTitle.get(position)); //" "+mColor.get(position)+" "+mPrice.get(position)
        holder.mImageView.setImageResource(mImage.get(position));
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
