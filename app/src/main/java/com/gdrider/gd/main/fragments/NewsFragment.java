package com.gdrider.gd.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdrider.gd.R;
import com.gdrider.gd.main.contract.NewsContract;
import com.gdrider.gd.main.presenter.NewsPresenter;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment implements NewsContract.NewsView{

    private final String label = "NewsFragment:";
    private ArrayList<String> productText;
    private ArrayList<Integer> productImage;
    private NewsPresenter presenter;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;

    public NewsFragment() {
        //Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(label+"onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        System.out.println(label+"onCreateView");
        //return inflater.inflate(R.layout.fragment_news, container, false);
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        //get data via presenter
        presenter = new NewsPresenter(this);
        presenter.getText();
        presenter.getImage();

        recyclerAdapter = new RecyclerAdapter(productText, productImage);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

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

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

        private List<String> mText;
        private List<Integer> mImage;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView;
            public ImageView mImageView;

            public ViewHolder(View v) {
                super(v);
                mTextView = (TextView) v.findViewById(R.id.info_text);
                mImageView = (ImageView) v.findViewById(R.id.info_img);
            }
        }

        public RecyclerAdapter(List<String> text, List<Integer> image) {
            mText = text;
            mImage = image;
        }

        @Override
        public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(mText.get(position));
            holder.mImageView.setImageResource(mImage.get(position));
        }

        @Override
        public int getItemCount() {
            return mText.size();
        }
    }
}
