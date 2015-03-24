package com.willchun.navigationbarios.widget;


import android.view.View;
import com.willchun.navigationbarios.icon.Icon;

/**
 *@author willchun(277143980@qq.com)
 *@github https://github.com/willchun
 *@date 2015/3/19
 */
public abstract class NavigationBarIos {

    /**
     * Standard Mode
     */
    public static final int NAVIGATION_MODE_STANDARD = 0;
    /**
     * List Mode, Items为多个的情况
     */
    public static final int NAVIGATION_MODE_LIST = 1;

    /**
     * Tabs, 采用Tabs 切换的模式
     */
    public static final int NAVIGATION_MODE_TABS = 2;

    /**
     * 显示左边的Icon
     */
    public static final int DISPLAY_SHOW_LEFT_ICON = 0x1;

    /**
     * 显示Title
     */
    public static final int DISPLAY_SHOW_TITLE = 0x2;

    /**
     * 显示右边的Icon
     */
    public static final int DISPLAY_SHOW_RIGHT_ICON = 0x4;

    /**
     * 显示按键列表
     */
    public static final int DISPLAY_SHOW_LIST = 0x8;

    /**
     * 显示Tabs
     */
    public static final int DISPLAY_SHOW_TABS = 0x10;

    public abstract void setLeftIcon(Icon icon);

    public abstract void setRightIcon(Icon icon);

    public abstract void setTitle(CharSequence title);


    /**
     * NavigationBarIosListener 相关监听器
     */
    public interface NavigationBarIosListener{

        public void onClickMenuItem(NavigationBarIosMenuItem item);

        public void onClickLeftIcon();

        public void onClickRightIcon();

        public void onClickTitle();

    }


}
