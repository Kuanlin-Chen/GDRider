package com.gdrider.gd.main.contract;

import java.util.ArrayList;

public interface FavoContract {

    interface FavoView{
        void setText(ArrayList<String> productText);
        void setImage(ArrayList<Integer> productImage);
    }

    interface FavoPresenter{
        void getText();
        void getImage();
    }
}
