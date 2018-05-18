package com.gdrider.gd.main.contract;

import java.util.ArrayList;

public interface EvenContract {

    interface EvenView{
        void setText(ArrayList<String> productText);
        void setImage(ArrayList<Integer> productImage);
    }

    interface EvenPresenter{
        void getText();
        void getImage();
    }
}
