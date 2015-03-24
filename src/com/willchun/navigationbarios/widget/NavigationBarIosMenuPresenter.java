package com.willchun.navigationbarios.widget;


/**
 *采用MVP模式
 *@author willchun(277143980@qq.com)
 *@github https://github.com/willchun
 *@date 2015/3/24
 */

import android.content.Context;
import android.view.View;

public class NavigationBarIosMenuPresenter{

    private Context mContext;
    private NavigationBarIos.NavigationBarIosListener mNavigationBarIosListener;


    public NavigationBarIosMenuPresenter(Context context, NavigationBarIos.NavigationBarIosListener listener){
        mContext = context;
        mNavigationBarIosListener = listener;
    }

    public void setmNavigationBarIosListener(NavigationBarIos.NavigationBarIosListener listener){
        mNavigationBarIosListener = listener;
    }

    public void setOnClickLeftIcon(View view){
        if(mNavigationBarIosListener != null){
            NavigationBarIosMenuItem item = new NavigationBarIosMenuItem(NavigationBarIosMenuItem.NavigationBarIosMenuItemType.TYPE_LEFT, view);
            mNavigationBarIosListener.onClickMenuItem(item);
            mNavigationBarIosListener.onClickLeftIcon();
        }
    }

    public void setOnClickRightIcon(View view){
        if(mNavigationBarIosListener != null){
            NavigationBarIosMenuItem item = new NavigationBarIosMenuItem(NavigationBarIosMenuItem.NavigationBarIosMenuItemType.TYPE_RIGHT, view);
            mNavigationBarIosListener.onClickMenuItem(item);
            mNavigationBarIosListener.onClickRightIcon();
        }
    }

    public void setOnClickTitle(View view){
        if(mNavigationBarIosListener != null){
            NavigationBarIosMenuItem item = new NavigationBarIosMenuItem(NavigationBarIosMenuItem.NavigationBarIosMenuItemType.TYPE_TITLE, view);
            mNavigationBarIosListener.onClickMenuItem(item);
            mNavigationBarIosListener.onClickTitle();
        }
    }


}
