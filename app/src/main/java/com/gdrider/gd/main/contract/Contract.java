package com.gdrider.gd.main.contract;

import java.util.ArrayList;

public interface Contract {

    interface View{
        void setNews(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image);
        void setEven(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image);
        void setCart(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image);
        void setFavo(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image);
    }

    interface Presenter{
        void getNews();
        void getEven();
        void getCart();
        void getFavo();
    }
}
