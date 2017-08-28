package io.github.mayunfei.fragmentlazyload;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mayunfei on 17-8-24.
 */

public class ShowFragment extends LazyFragment {


    private int index = 888;
    private static final String TAG = "ShowFragment";

    private static final String INDEX = "index";

    public static ShowFragment getInstance(int position) {
        ShowFragment fragment = new ShowFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(INDEX, position);
        fragment.setArguments(bundle);
        Log.i(TAG,"getInstance " + position);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, index + " " + "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = getArguments().getInt(INDEX, 0);
        Log.i(TAG, index + " " + "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show,container,false);
    }



    @Override
    protected void initView(View rootView) {
        ((TextView) rootView.findViewById(R.id.tv_index)).setText("" + index);
    }

    @Override
    protected void onFragmentFirstVisible() {
        Log.d(TAG,index + " onFragmentFirstVisible 可以去网络请求");
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        Log.d(TAG,index + " onFragmentVisibleChange " + isVisible);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, index + " " + "onActivityCreated");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, index + " " + "onViewCreated");
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onStart() {
        Log.i(TAG, index + " " + "onStart");
        super.onStart();
    }

    @Override
    public void onPause() {
        Log.i(TAG, index + " " + "onPause");
        super.onPause();
    }

    @Override
    public void onResume() {
        Log.i(TAG, index + " " + "onResume");
        super.onResume();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, index + " " + "onDestroy");
        super.onDestroy();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.i(TAG, index + " " + "setUserVisibleHint = " + isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
    }
}
