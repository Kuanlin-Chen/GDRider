package com.gdrider.gd.main.presenter;

import com.gdrider.gd.main.contract.Contract;
import com.gdrider.gd.main.model.RemoteServer;

public class NewsPresenter implements Contract.Presenter {

    private Contract.View view;
    private RemoteServer remoteServer;

    public NewsPresenter(Contract.View view) {
        this.view = view;
        this.remoteServer = new RemoteServer();
    }

    @Override
    public void getTitle() {
        view.setTitle(remoteServer.getTitle());
    }

    @Override
    public void getColor() {
        view.setColor(remoteServer.getColor());
    }

    @Override
    public void getPrice() {
        view.setPrice(remoteServer.getPrice());
    }

    @Override
    public void getImage(){
        view.setImage(remoteServer.getImage());
    }
}
