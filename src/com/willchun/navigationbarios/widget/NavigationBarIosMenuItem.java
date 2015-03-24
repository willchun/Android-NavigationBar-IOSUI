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

    public NavigationBarIosMenuItemType type;
    public View root;


    public NavigationBarIosMenuItem(){
        type = NavigationBarIosMenuItemType.TYPE_ITEM;
    }

    public NavigationBarIosMenuItem(NavigationBarIosMenuItemType type, View view){
        this.type = type;
        this.root = view;
    }



    public interface onMenuItemClickListener {

        public void onMenuItemClick(NavigationBarIosMenuItem item);

    }



}
