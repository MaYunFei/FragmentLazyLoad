package io.github.mayunfei.fragmentlazyload;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mayunfei on 17-8-24.
 */

public abstract class LazyFragment extends Fragment {
    View rootView;

    //当前Fragment是否处于可见状态标志，防止因ViewPager的缓存机制而导致回调函数的触发
    private boolean isFragmentVisible = false;
    private boolean isFirstVisible = true;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (rootView == null) {
            return;
        }

        if (isFirstVisible && isVisibleToUser) {
            onFragmentFirstVisible();
            isFirstVisible = false;
        }

        if (isVisibleToUser) {
            onFragmentVisibleChange(true);
            isFragmentVisible = true;
        } else {
            if (isFragmentVisible) {
                isFragmentVisible = false;
                onFragmentVisibleChange(false);
            }
        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        if (rootView == null) {
            rootView = view;
            if (getUserVisibleHint()){
                if (isFirstVisible) {
                    onFragmentFirstVisible();
                    isFirstVisible = false;
                }
                onFragmentVisibleChange(true);
                isFragmentVisible = true;
            }

        }

    }

    /**
     * 初始化view
     *
     * @param view
     */
    protected abstract void initView(View view);

    /**
     * 第一次显示
     * 如果第一次　失败，或者取消　请调用resumeFirst
     */
    protected abstract void onFragmentFirstVisible();

    /**
     * 如果子类第一次初始化没有成功调用　resumeFirst
     */
    protected void resumeFirst() {
        isFirstVisible = true;
    }

    /**
     * 当前fragment可见状态发生变化时会回调该方法
     * 如果当前fragment是第一次加载，等待onCreateView后才会回调该方法，其它情况回调时机跟 {@link #setUserVisibleHint(boolean)}一致
     * 在该回调方法中你可以做一些加载数据操作，甚至是控件的操作.
     *
     * @param isVisible true  不可见 -> 可见
     *                  false 可见  -> 不可见
     */
    protected abstract void onFragmentVisibleChange(boolean isVisible);


}
