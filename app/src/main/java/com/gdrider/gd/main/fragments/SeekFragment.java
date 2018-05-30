package com.gdrider.gd.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gdrider.gd.R;
import com.gdrider.gd.main.contract.SeekContract;

import java.util.ArrayList;

public class SeekFragment extends Fragment implements SeekContract.SeekView{

    private final String label = "SeekFragment:";
    private ArrayList<String> productText;
    private ArrayList<Integer> productImage;
    private SearchView searchView;

    public SeekFragment() {
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
        View view = inflater.inflate(R.layout.fragment_seek, container, false);

        searchView = (SearchView)view.findViewById(R.id.searchview);
        searchView.setIconifiedByDefault(false);
        searchView.onActionViewExpanded();
        searchView.setBackgroundColor(getActivity().getResources().getColor(R.color.grey));
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getActivity(), "Search:" + query, Toast.LENGTH_SHORT).show();

                //Hide the keyboard after user submit text
                if (searchView != null) {
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
                    }
                    searchView.clearFocus();
                }

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return view;
    }

    @Override
    public void setText(ArrayList<String> productText){
        this.productText = productText;
    }

    @Override
    public void setImage(ArrayList<Integer> productImage){
        this.productImage = productImage;
    }
}
