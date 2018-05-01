package com.gdrider.gd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity implements LoginContext.ILoginView{

    private Button button_guest_login;
    private LoginButton button_fb_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_guest_login = (Button)findViewById(R.id.button_guest_login);
        button_fb_login = (LoginButton)findViewById(R.id.button_fb_login);
    }

    // Override LoginContext.View method
    @Override
    public void onLoginSuccess(String message) {
        //this.textView_result.setText(message);
    }

    @Override
    public void onLoginFail(String message) {
        //this.textView_result.setText(message);
        //this.editText_password.setText("");
    }
}
