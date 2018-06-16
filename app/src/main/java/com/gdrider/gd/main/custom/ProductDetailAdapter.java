package com.gdrider.gd.main.custom;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.gdrider.gd.R;
import com.gdrider.gd.main.contract.Contract;

public class ProductDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final int TYPE_FIRST_ITEM = 0;
    private final int TYPE_SECOND_ITEM = 1;
    private final int TYPE_ITEM = 2;
    private String mTitle;
    private String mColor;
    private Integer mPrice;
    private int[] mImage;
    private String[] mFeature;
    private Context context;
    private Handler imageSwitcherHandler;
    private int animationCounter = 0;
    private Contract.Presenter presenter;

    public ProductDetailAdapter(String title, String color, Integer price, int[] image, String[] feature, Context context, Contract.Presenter presenter){
        this.mTitle = title;
        this.mColor = color;
        this.mPrice = price;
        this.mImage = image;
        this.mFeature = feature;
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_FIRST_ITEM:
                final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ads, parent, false);
                return new ImageViewHolder(view);
            case TYPE_SECOND_ITEM:
                final View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
                return new DetailViewHolder(view2);
            case TYPE_ITEM:
                final View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feature, parent, false);
                return new FeatureViewHolder(view3);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (holder.getItemViewType()) {
            case TYPE_FIRST_ITEM:
                final ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
                imageViewHolder.imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left));
                imageViewHolder.imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right));
                imageViewHolder.imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
                    @Override
                    public View makeView() {
                        ImageView imageView = new ImageView(context);
                        imageView.setAdjustViewBounds(true);
                        return imageView;
                    }});
                imageViewHolder.imageSwitcher.setImageResource(mImage[0]);
                //Update image every five second
                imageSwitcherHandler = new Handler(Looper.getMainLooper());
                imageSwitcherHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        switch (animationCounter) {
                            case 0:
                                imageViewHolder.imageSwitcher.setImageResource(mImage[animationCounter]);
                                break;
                            case 1:
                                imageViewHolder.imageSwitcher.setImageResource(mImage[animationCounter]);
                                break;
                            case 2:
                                imageViewHolder.imageSwitcher.setImageResource(mImage[animationCounter]);
                                break;
                        }
                        if(++animationCounter > 2 ) animationCounter = 0;
                        imageSwitcherHandler.postDelayed(this, 5000);
                    }
                });
                break;
            case TYPE_SECOND_ITEM:
                DetailViewHolder detailViewHolder = (DetailViewHolder) holder;
                detailViewHolder.textView_title.setText(mTitle+" "+mColor);
                detailViewHolder.textView_price.setText("$"+String.valueOf(mPrice));
                detailViewHolder.imageButton_favo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        presenter.showToast("Add to favorite!");
                    }
                });
                break;
            case TYPE_ITEM:
                FeatureViewHolder featureViewHolder = (FeatureViewHolder) holder;
                featureViewHolder.textView_title.setText(R.string.title_feature);
                StringBuilder builder = new StringBuilder();
                for (String details : mFeature) {
                    builder.append(" • " + details + "\n");
                }
                featureViewHolder.textView_feature.setText(builder.toString());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_FIRST_ITEM;
        } else if (position == 1){
            return TYPE_SECOND_ITEM;
        } else {
            return TYPE_ITEM;
        }
    }

    final class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageSwitcher imageSwitcher;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageSwitcher = (ImageSwitcher)itemView.findViewById(R.id.image_switcher);
        }
    }

    final class DetailViewHolder extends RecyclerView.ViewHolder {

        TextView textView_title;
        TextView textView_price;
        ImageButton imageButton_favo;

        public DetailViewHolder(View itemView) {
            super(itemView);
            textView_title = (TextView)itemView.findViewById(R.id.info_text);
            textView_price = (TextView)itemView.findViewById(R.id.info_price);
            imageButton_favo = (ImageButton)itemView.findViewById(R.id.info_favo);
        }
    }

    final class FeatureViewHolder extends RecyclerView.ViewHolder {

        TextView textView_title;
        TextView textView_feature;

        public FeatureViewHolder(View itemView) {
            super(itemView);
            textView_title = (TextView)itemView.findViewById(R.id.textView_title);
            textView_feature = (TextView)itemView.findViewById(R.id.textView_feature);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
