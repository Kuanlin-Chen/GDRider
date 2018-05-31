package com.gdrider.gd.main.contract;

import java.util.ArrayList;

public interface NewsContract {

    interface NewsView{
        void setTitle(ArrayList<String> productTitle);
        void setColor(ArrayList<String> productColor);
        void setPrice(ArrayList<Integer> productPrice);
        void setImage(ArrayList<Integer> productImage);
    }

    interface NewsPresenter{
        void getTitle();
        void getColor();
        void getPrice();
        void getImage();
    }
}
