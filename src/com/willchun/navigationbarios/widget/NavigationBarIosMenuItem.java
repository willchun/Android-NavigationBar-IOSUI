package com.willchun.navigationbarios.widget;/**
 *@author willchun(277143980@qq.com)
 *@github https://github.com/willchun
 *@date 2015/3/24
 */

import android.view.MenuItem;
import android.view.View;

/**
 * Created by Administrator on 2015/3/24.
 */
public class NavigationBarIosMenuItem {

    public static enum NavigationBarIosMenuItemType{
        TYPE_ITEM,
        TYPE_TITLE,
        TYPE_LEFT,
        TYPE_RIGHT,
        TYPE_LIST,
        TYPE_TAB
    }

    public static final int ITEM_ID_TITLE = -1;
    public static final int ITEM_ID_LEFT = -2;
    public static final int ITEM_ID_RIGHT = -3;

    public NavigationBarIosMenuItemType type;
    public NavigationBarIosMenuView menuView;
    public int id;

    public NavigationBarIosMenuItem(){
        type = NavigationBarIosMenuItemType.TYPE_ITEM;
    }

    public NavigationBarIosMenuItem(NavigationBarIosMenuItemType type, NavigationBarIosMenuView view, int id){
        this.type = type;
        this.menuView = view;
        this.id = id;
    }


    public interface onMenuItemClickListener {

        public void onMenuItemClick(NavigationBarIosMenuItem item);

    }



}
