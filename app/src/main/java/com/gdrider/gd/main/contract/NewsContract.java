package com.gdrider.gd.main.contract;

public interface NewsContract {

    interface NewsView{
        void setText(String string);
    }

    interface NewsPresenter{
        void getText();
    }
}
