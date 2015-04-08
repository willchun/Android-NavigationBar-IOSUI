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

    public void setOnClickLeftIcon(NavigationBarIosMenuView menu){
        if(mNavigationBarIosListener != null){
            NavigationBarIosMenuItem item = new NavigationBarIosMenuItem(NavigationBarIosMenuItem.NavigationBarIosMenuItemType.TYPE_LEFT, menu, NavigationBarIosMenuItem.ITEM_ID_LEFT);
            mNavigationBarIosListener.onClickMenuItem(item);
            mNavigationBarIosListener.onClickLeftIcon();
        }
    }

    public void setOnClickRightIcon(NavigationBarIosMenuView menu){
        if(mNavigationBarIosListener != null){
            NavigationBarIosMenuItem item = new NavigationBarIosMenuItem(NavigationBarIosMenuItem.NavigationBarIosMenuItemType.TYPE_RIGHT, menu, NavigationBarIosMenuItem.ITEM_ID_RIGHT);
            mNavigationBarIosListener.onClickMenuItem(item);
            mNavigationBarIosListener.onClickRightIcon();
        }
    }

    public void setOnClickTitle(NavigationBarIosMenuView menu){
        if(mNavigationBarIosListener != null){
            NavigationBarIosMenuItem item = new NavigationBarIosMenuItem(NavigationBarIosMenuItem.NavigationBarIosMenuItemType.TYPE_TITLE, menu, NavigationBarIosMenuItem.ITEM_ID_TITLE);
            mNavigationBarIosListener.onClickMenuItem(item);
            mNavigationBarIosListener.onClickTitle();
        }
    }

    public void setOnListSelected(NavigationBarIosMenuView menu){
        if(mNavigationBarIosListener != null){
            NavigationBarIosMenuItem item = new NavigationBarIosMenuItem(NavigationBarIosMenuItem.NavigationBarIosMenuItemType.TYPE_LIST, menu, (Integer)menu.getTag());
            mNavigationBarIosListener.onClickMenuItem(item);
        }
    }


}
