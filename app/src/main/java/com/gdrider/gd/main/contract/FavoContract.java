package com.gdrider.gd.main.contract;

import java.util.ArrayList;

public interface FavoContract {

    interface FavoView{
        void setAllFavo(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image);
    }

    interface FavoPresenter{
        void getAllFavo();
    }
}
