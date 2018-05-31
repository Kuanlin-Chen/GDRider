package com.gdrider.gd.main.contract;

import java.util.ArrayList;

public interface Contract {

    interface View{
        void setTitle(ArrayList<String> productTitle);
        void setColor(ArrayList<String> productColor);
        void setPrice(ArrayList<Integer> productPrice);
        void setImage(ArrayList<Integer> productImage);
    }

    interface Presenter{
        void getTitle();
        void getColor();
        void getPrice();
        void getImage();
    }
}
