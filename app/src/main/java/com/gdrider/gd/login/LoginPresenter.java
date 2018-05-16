package com.gdrider.gd.login;

import android.app.Activity;
import android.content.Intent;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Collection;

public class LoginPresenter implements LoginContract.FBLoginPresenter {

    private LoginContract.FBLoginView view;
    private LoginModel model;
    private CallbackManager callbackManager;

    public LoginPresenter(LoginContract.FBLoginView view){
        this.view = view;
        this.model = new LoginModel();
    }

    @Override
    public void fbLogin(Activity activity, Collection<String> permissions){
        callbackManager = CallbackManager.Factory.create();
        FacebookCallback<LoginResult> callback = new Callback();
        LoginManager.getInstance().logInWithReadPermissions(activity, permissions);
        LoginManager.getInstance().registerCallback(callbackManager,callback);
    }

    @Override
    public void fbActivityResult(int requestCode, int resultCode, Intent data){
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void fbIsLoggedIn(){
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken != null){
            view.onFBisLoggedIn();
        }
    }

    private class Callback implements FacebookCallback<LoginResult> {

        public Callback ( ){
        }

        @Override
        public void onSuccess(LoginResult loginResult) {
            view.onFBLoginSuccess();
        }

        public boolean isLoggedIn() {
            AccessToken accessToken = AccessToken.getCurrentAccessToken();
            return accessToken != null;
        }

        @Override
        public void onCancel() {
            view.onFBLoginFail();
        }

        @Override
        public void onError(FacebookException error) {
            view.onFBLoginFail();
        }
    }
}
