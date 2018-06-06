package com.gdrider.gd.main.custom;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.gdrider.gd.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int TYPE_FIRST_ITEM = 0;
    private final int TYPE_ITEM = 1;
    private ArrayList<String> mTitle;
    private ArrayList<String> mColor;
    private ArrayList<Integer> mPrice;
    private ArrayList<Integer> mImage;
    private int[] mAdver;
    private Context context;
    private Handler imageSwitcherHandler;
    private int animationCounter = 0;

    public NewsAdapter(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image, int[] adver, Context context){
        this.mTitle = title;
        this.mColor = color;
        this.mPrice = price;
        this.mImage = image;
        this.mAdver = adver;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_FIRST_ITEM:
                final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ads, parent, false);
                return new BigViewHolder(view);
            case TYPE_ITEM:
                final View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
                return new NormalViewHolder(view2);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (holder.getItemViewType()) {
            case TYPE_FIRST_ITEM:
                final BigViewHolder bigViewHolder = (BigViewHolder) holder;
                bigViewHolder.imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left));
                bigViewHolder.imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right));
                bigViewHolder.imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
                     @Override
                     public View makeView() {
                         ImageView imageView = new ImageView(context);
                         imageView.setAdjustViewBounds(true);
                         return imageView;
                     }});
                bigViewHolder.imageSwitcher.setImageResource(mAdver[0]);
                //Update image every five second
                imageSwitcherHandler = new Handler(Looper.getMainLooper());
                imageSwitcherHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        switch (animationCounter) {
                            case 0:
                                bigViewHolder.imageSwitcher.setImageResource(mAdver[animationCounter]);
                                break;
                            case 1:
                                bigViewHolder.imageSwitcher.setImageResource(mAdver[animationCounter]);
                                break;
                            case 2:
                                bigViewHolder.imageSwitcher.setImageResource(mAdver[animationCounter]);
                                break;
                        }
                        if(++animationCounter > 2 ) animationCounter = 0;
                        imageSwitcherHandler.postDelayed(this, 5000);
                    }
                });
                break;
            case TYPE_ITEM:
                NormalViewHolder normalViewHolder = (NormalViewHolder) holder;
                normalViewHolder.textView_title.setText(mTitle.get(position-1)+" "+mColor.get(position-1));
                normalViewHolder.textView_price.setText("$"+String.valueOf(mPrice.get(position-1)));
                normalViewHolder.imageView_main.setImageResource(mImage.get(position-1));
                normalViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "CardView:" + (position-1), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_FIRST_ITEM;
        } else {
            return TYPE_ITEM;
        }
    }

    final class BigViewHolder extends RecyclerView.ViewHolder {

        ImageSwitcher imageSwitcher;

        public BigViewHolder(View itemView) {
            super(itemView);
            imageSwitcher = (ImageSwitcher)itemView.findViewById(R.id.image_switcher);
        }
    }

    final class NormalViewHolder extends RecyclerView.ViewHolder {

        TextView textView_title;
        TextView textView_price;
        ImageView imageView_main;
        ImageButton imageButton_favo;
        CardView mCardView;

        public NormalViewHolder(View itemView) {
            super(itemView);
            textView_title = (TextView)itemView.findViewById(R.id.info_text);
            textView_price = (TextView)itemView.findViewById(R.id.info_price);
            imageView_main = (ImageView)itemView.findViewById(R.id.info_img);
            imageButton_favo = (ImageButton)itemView.findViewById(R.id.info_favo);
            mCardView = (CardView)itemView.findViewById(R.id.card_view);
        }
    }

    @Override
    public int getItemCount() {
        return mTitle.size()+1;
    }
}
