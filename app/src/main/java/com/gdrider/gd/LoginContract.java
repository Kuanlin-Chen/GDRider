package com.gdrider.gd;

import android.app.Activity;
import android.content.Intent;

import java.util.Collection;

public interface LoginContract {

    interface FBLoginView  {
        void onFBLoginSuccess();
        void onFBLoginFail();
    }

    interface FBLoginPresenter {
        void fbLogin(Activity activity, Collection<String> permissions);
        void fbActivityResult(int requestCode, int resultCode, Intent data);
    }
}
