package com.gdrider.gd.main.contract;

import java.util.ArrayList;

public interface CartContract {

    interface CartView{
        void setText(ArrayList<String> productText);
        void setImage(ArrayList<Integer> productImage);
    }

    interface CartPresenter{
        void getText();
        void getImage();
    }
}
