package com.willchun.navigationbarios.base;/**
 *@author willchun(277143980@qq.com)
 *@github https://github.com/willchun
 *@date 2015/3/20
 */

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import com.willchun.navigationbarios.R;
import com.willchun.navigationbarios.widget.NavigationBarIos;
import com.willchun.navigationbarios.widget.NavigationBarIosImpl;
import com.willchun.navigationbarios.widget.NavigationBarIosMenuItem;

/**
 * Created by Administrator on 2015/3/20.
 */
public class NavigationBarIosActivity extends Activity implements NavigationBarIos.NavigationBarIosListener{
    /**
     * Called when the activity is first created.
     */
    private NavigationBarIosImpl mNavigationBarIos;
    private boolean isNavigationBar =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TypedArray a = getTheme().obtainStyledAttributes(R.styleable.NavigationBarIos);
        int mode = a.getInt(R.styleable.NavigationBarIos_NavigationBarIos_mode, -1);
        a.recycle();

        if(mode != -1){
            isNavigationBar = true;
            getWindow().requestFeature(Window.FEATURE_CUSTOM_TITLE);
        }
        super.onCreate(savedInstanceState);
    }

    /**
     * 初始化NavigationBarIos
     */
    private void initNavigationBarIos(){
        if(!isNavigationBar){
            return;
        }

        Window window = getWindow();

        // Initializing the window decor can change window feature flags.
        // Make sure that we have the correct set before performing the test below.
        window.getDecorView();

        if (isChild() || !window.hasFeature(Window.FEATURE_CUSTOM_TITLE) || mNavigationBarIos != null) {
            return;
        }



        mNavigationBarIos = new NavigationBarIosImpl(this);
        mNavigationBarIos.setNavigationBarIosListener(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initNavigationBarIos();
    }

    protected NavigationBarIos getNavigationBarIos(){
        initNavigationBarIos();
        return mNavigationBarIos;
    }

    @Override
    public void onClickMenuItem(NavigationBarIosMenuItem item) {

    }

    @Override
    public void onClickLeftIcon() {

    }

    @Override
    public void onClickRightIcon() {

    }

    @Override
    public void onClickTitle() {

    }
}
