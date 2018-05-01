package com.gdrider.gd;

/**
 * Created by kuanlin on 2018/5/1.
 */

public interface LoginContext {

    interface ILoginView  {
        void onLoginSuccess(String message);
        void onLoginFail(String message);
    }

    interface ILoginPresenter {
        void login(String username, String password);
    }
}
