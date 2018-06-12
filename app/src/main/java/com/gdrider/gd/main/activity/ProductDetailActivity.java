package com.gdrider.gd.main.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.gdrider.gd.R;

public class ProductDetailActivity extends AppCompatActivity{

    private ImageSwitcher imageSwitcher;
    private TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        imageSwitcher = (ImageSwitcher)findViewById(R.id.image_switcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ProductDetailActivity.this);
                imageView.setAdjustViewBounds(true);
                return imageView;
            }});
        imageSwitcher.setImageResource(R.drawable.gdemo);

        textView = (TextView)findViewById(R.id.info_text);
        textView.setText("Test");

    }

}
