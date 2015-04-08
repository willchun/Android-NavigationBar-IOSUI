package com.willchun.navigationbarios;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import com.willchun.navigationbarios.base.NavigationBarIosActivity;
import com.willchun.navigationbarios.iconfont.WillChunIcon;
import com.willchun.navigationbarios.widget.NavigationBarIos;
import com.willchun.navigationbarios.widget.NavigationBarIosImpl;
import com.willchun.navigationbarios.widget.NavigationBarIosMenuItem;

public class MyActivity extends NavigationBarIosActivity{


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //getNavigationBarIos().setNavigationMode(NavigationBarIos.NAVIGATION_MODE_LIST);
        getNavigationBarIos().setTitle("天空之城");
        getNavigationBarIos().setLeftIcon(WillChunIcon.ICON_FANHUI);
        getNavigationBarIos().setRightIcon(WillChunIcon.ICON_DINGXIANG, "上海");

//        getNavigationBarIos().addListItem(WillChunIcon.ICON_DINGXIANG, null, 0).
//                addListItem(WillChunIcon.ICON_JIA, null, 1).
//                addListItem(null, "测试", 2).commit();
    }

    @Override
    public void onClickTitle() {
        super.onClickTitle();
        Toast.makeText(this, "onClickTitle", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickLeftIcon() {
        super.onClickLeftIcon();
        Toast.makeText(this, "onClickLeftIcon", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickRightIcon() {
        super.onClickRightIcon();
        Toast.makeText(this, "onClickRightIcon", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickMenuItem(NavigationBarIosMenuItem item) {
        super.onClickMenuItem(item);
        //Toast.makeText(this, "onClickMenuItem", Toast.LENGTH_SHORT).show();
        if(item.type == NavigationBarIosMenuItem.NavigationBarIosMenuItemType.TYPE_LIST){
            Toast.makeText(this, "onClickMenuListItem  id:" + item.id , Toast.LENGTH_SHORT).show();
        }
    }
}
