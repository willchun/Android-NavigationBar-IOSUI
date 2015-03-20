package com.willchun.navigationbarios;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.willchun.navigationbarios.base.NavigationBarIosActivity;
import com.willchun.navigationbarios.iconfont.WillChunIcon;
import com.willchun.navigationbarios.widget.NavigationBarIos;
import com.willchun.navigationbarios.widget.NavigationBarIosImpl;

public class MyActivity extends NavigationBarIosActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        getNavigationBarIos().setTitle("天空之城");
        getNavigationBarIos().setLeftIcon(WillChunIcon.ICON_FANHUI);
        getNavigationBarIos().setRightIcon(WillChunIcon.ICON_JIA);
    }


}
