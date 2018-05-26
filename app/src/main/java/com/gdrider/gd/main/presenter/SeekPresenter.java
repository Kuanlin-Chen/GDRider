package com.gdrider.gd.main.presenter;

import com.gdrider.gd.main.contract.SeekContract;
import com.gdrider.gd.main.model.SeekModel;

public class SeekPresenter implements SeekContract.SeekPresenter{

    private SeekContract.SeekView view;
    private SeekModel model;

    public SeekPresenter(SeekContract.SeekView view) {
        this.view = view;
        this.model = new SeekModel();
    }

    @Override
    public void getText() {
        view.setText(model.getText());
    }

    @Override
    public void getImage(){
        view.setImage(model.getImage());
    }
}
