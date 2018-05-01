package com.gdrider.gd;

/**
 * Created by kuanlin on 2018/5/1.
 */

public class LoginPresenter implements LoginContext.ILoginPresenter{

    private LoginContext.ILoginView view;

    LoginPresenter(LoginContext.ILoginView view){
        this.view = view;
    }

    @Override
    public void login(String username, String password){
        LoginModel model = new LoginModel();

        boolean isSuccess = model.login(username, password);
        if(isSuccess){
            view.onLoginSuccess("Success");
        }else {
            view.onLoginFail("Fail");
        }
    }
}
