package com.gdrider.gd.main.presenter;

import com.gdrider.gd.main.contract.FavoContract;
import com.gdrider.gd.main.model.FavoModel;

public class FavoPresenter implements FavoContract.FavoPresenter{

    private FavoContract.FavoView view;
    private FavoModel model;

    public FavoPresenter(FavoContract.FavoView view) {
        this.view = view;
        this.model = new FavoModel();
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
