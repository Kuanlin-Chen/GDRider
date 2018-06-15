package com.gdrider.gd.main.contract;

import java.util.ArrayList;

public interface CartContract {

    interface CartView{
        void setAllCart(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image);
    }

    interface CartPresenter{
        void getAllCart();
    }
}
