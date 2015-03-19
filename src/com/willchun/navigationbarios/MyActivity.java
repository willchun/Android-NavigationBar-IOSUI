package com.willchun.navigationbarios;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.willchun.navigationbarios.widget.NavigationBarIos;
import com.willchun.navigationbarios.widget.NavigationBarIosImpl;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private NavigationBarIosImpl mNavigationBarIos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CUSTOM_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    /**
     * 初始化NavigationBarIos
     */
    private void initNavigationBarIos(){
        Window window = getWindow();

        // Initializing the window decor can change window feature flags.
        // Make sure that we have the correct set before performing the test below.
        window.getDecorView();

        if (isChild() || !window.hasFeature(Window.FEATURE_CUSTOM_TITLE) || mNavigationBarIos != null) {
            return;
        }
        mNavigationBarIos = new NavigationBarIosImpl(this);
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
}
