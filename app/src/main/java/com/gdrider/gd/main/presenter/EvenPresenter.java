package com.gdrider.gd.main.presenter;

import com.gdrider.gd.main.contract.EvenContract;
import com.gdrider.gd.main.model.EvenModel;

public class EvenPresenter implements EvenContract.EvenPresenter{

    private EvenContract.EvenView view;
    private EvenModel model;

    public EvenPresenter(EvenContract.EvenView view) {
        this.view = view;
        this.model = new EvenModel();
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
