package com.gdrider.gd.main.contract;

import java.util.ArrayList;

public interface NewsContract {

    interface NewsView{
        void setAllData(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image);
    }

    interface NewsPresenter{
        void getAllData();
    }
}
