package com.gdrider.gd.fragments;

/**
 * Created by kuanlin on 2018/5/2.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.gdrider.gd.R;

import static com.gdrider.gd.MainActivity.KEYCHAR;
import static com.gdrider.gd.MainActivity.KEYCODE;

public class MainFragment extends Fragment {

    private EditText editText_main;
    private final String label = "MainFragment:";
    private final String tag = "KeyCode";

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(label+"onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println(label+"onCreateView");

        View v = inflater.inflate(R.layout.fragment_main, container, false);

        editText_main = (EditText)v.findViewById(R.id.editText_main);
        editText_main.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                monitorKeyCode();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return v;
    }

    private void monitorKeyCode(){
        //目前無法判斷特殊鍵
        if(editText_main.getText().length()>0){
            String content = editText_main.getText().toString();
            if(KEYCHAR == content.charAt(content.length()-1)){
                //Log.i(tag,"LastIndex:"+String.valueOf(content.charAt(content.length()-1)));
                Log.i(tag,">>"+KEYCODE+">>"+KEYCHAR+">>true>>");
            }else {
                //System.out.println(label+KEYCODE+":false");
                Log.i(tag,">>"+KEYCODE+">>"+KEYCHAR+">>false>>");
            }
        }
    }
}
