package com.gdrider.gd;

/**
 * Created by kuanlin on 2018/5/1.
 */

public class LoginModel {

    public boolean login(String username, String password){
        if(username.equals("abc") && password.equals("123")){
            return true;
        }else{
            return false;
        }
    }
}
