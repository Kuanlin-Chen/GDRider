package com.gdrider.gd.main.contract;

import java.util.ArrayList;

public interface NewsContract {

    interface NewsView{
        void setText(ArrayList<String> productText);
        void setImage(ArrayList<Integer> productImage);
    }

    interface NewsPresenter{
        void getText();
        void getImage();
    }
}
