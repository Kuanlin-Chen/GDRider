package com.gdrider.gd.main.contract;

import java.util.ArrayList;

public interface EvenContract {

    interface EvenView{
        void setNewEvent(ArrayList<String> title, ArrayList<String> color, ArrayList<Integer> price, ArrayList<Integer> image);
    }

    interface EvenPresenter{
        void getNewEvent();
    }
}
