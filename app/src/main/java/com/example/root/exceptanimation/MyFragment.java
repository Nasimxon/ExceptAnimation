package com.example.root.exceptanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by root on 6/1/17.
 */

public class MyFragment extends Fragment {
    @BindView(R.id.svCell)
    NestedScrollView scrollView;

    ScrollActivity scrollActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scrollActivity = (ScrollActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cell, container, false);
        ButterKnife.bind(this, rootView);

        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                final float percent = (scrollY * 1f) / v.getMaxScrollAmount();
                scrollActivity.setExpectAnimMove(percent);
            }
        });
        return rootView;
    }
}
