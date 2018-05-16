package com.gdrider.gd.main.presenter;

import com.gdrider.gd.main.contract.NewsContract;
import com.gdrider.gd.main.model.NewsModel;

public class NewsPresenter implements NewsContract.NewsPresenter{

    private NewsContract.NewsView view;
    private NewsModel model;

    public NewsPresenter(NewsContract.NewsView view){
        this.view = view;
        this.model = new NewsModel();
    }

    @Override
    public void getText(){
        view.setText(model.getText());
    }
}
