package com.gdrider.gd.main.contract;

import java.util.ArrayList;

public interface SeekContract {

    interface SeekView{
        void setText(ArrayList<String> productText);
        void setImage(ArrayList<Integer> productImage);
    }

    interface SeekPresenter{
        void getText();
        void getImage();
    }
}
