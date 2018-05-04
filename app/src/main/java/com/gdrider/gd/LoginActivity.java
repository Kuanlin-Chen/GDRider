package com.gdrider.gd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.facebook.AccessToken;
import com.facebook.login.widget.LoginButton;
import java.util.Arrays;

public class LoginActivity extends AppCompatActivity implements LoginContract.FBLoginView{

    private Button button_guest_login;
    private LoginButton button_fb_login;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        button_guest_login = (Button)findViewById(R.id.button_guest_login);
        button_fb_login = (LoginButton)findViewById(R.id.button_fb_login);

        presenter = new LoginPresenter(this);

        //check if user has logged in
        if(AccessToken.getCurrentAccessToken()!=null){
            startMainPage();
        }

        button_fb_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.fbLogin(LoginActivity.this, Arrays.asList("public_profile"));
            }
        });

        //guest login
        button_guest_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainPage();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.fbActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    // Override LoginContract.View method
    @Override
    public void onFBLoginSuccess() {
        startMainPage();
    }

    @Override
    public void onFBLoginFail(String message) {

    }

    private void startMainPage(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();
    }
}
