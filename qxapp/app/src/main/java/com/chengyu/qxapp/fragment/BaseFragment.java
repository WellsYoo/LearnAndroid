package com.chengyu.qxapp.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    public  Context context;
    public Resources resources;
    public LayoutInflater layoutInflater;

    private View rootView;  //缓存fragment
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        this.resources = context.getResources();
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutID(), container, false);
        }

        ViewGroup parent =(ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        bindEvent();
        initData();
    }

    //VV View的类型 id，控件的id
    protected <VV extends View> VV  findView(View view, @IdRes int id){
        return  view.findViewById(id);
    }

    protected  <VV extends View> VV findView(@IdRes int id){
        return  rootView.findViewById(id);
    }

    protected abstract void initData();

    protected abstract void bindEvent();

    protected abstract void initView(View view);

    protected abstract int getLayoutID();

}
