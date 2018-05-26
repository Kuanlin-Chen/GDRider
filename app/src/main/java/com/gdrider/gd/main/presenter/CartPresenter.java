package com.gdrider.gd.main.presenter;

import com.gdrider.gd.main.contract.CartContract;
import com.gdrider.gd.main.model.CartModel;

public class CartPresenter implements CartContract.CartPresenter{

    private CartContract.CartView view;
    private CartModel model;

    public CartPresenter(CartContract.CartView view) {
        this.view = view;
        this.model = new CartModel();
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
