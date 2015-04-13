package com.willchun.navigationbarios.widget;/**
 *@author willchun(277143980@qq.com)
 *@github https://github.com/willchun
 *@date 2015/3/19
 */

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.willchun.navigationbarios.R;
import com.willchun.navigationbarios.icon.Icon;
import com.willchun.navigationbarios.utils.UIUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/3/19.
 */
public class NavigationBarIosImpl extends NavigationBarIos{

    private NavigationBarIosView mNavigationBarIosView;
    private NavigationBarIosMenuPresenter mNavigationBarIosMenuPresenter;
    private ArrayList<NavigationBarIosMenuView> mListMenus = new ArrayList<NavigationBarIosMenuView>();
    private ArrayList<NavigationBarIosMenuView> mTabsMenus = new ArrayList<NavigationBarIosMenuView>();

    private Activity mActivity;

    public NavigationBarIosImpl(Activity activity) {
        mActivity = activity;
        mNavigationBarIosView = new NavigationBarIosView(activity);
        mNavigationBarIosView.setDefaultTabsPadding(UIUtil.dip2px(mActivity, 32));
    }

    @Override
    public void setLeftIcon(Icon icon) {
        mNavigationBarIosView.setLeftIcon(icon);
    }

    @Override
    public void setLeftIcon(Icon icon, String content) {
        mNavigationBarIosView.setLeftIcon(icon, content);
    }

    @Override
    public void setRightIcon(Icon icon) {
        mNavigationBarIosView.setRightIcon(icon);
    }

    @Override
    public void setRightIcon(Icon icon, String content) {
        mNavigationBarIosView.setRightIcon(icon, content);
    }

    @Override
    public void setTitle(String title) {
        mNavigationBarIosView.setTitle(title);
    }

    @Override
    public void setNavigationMode(int mode) {
        mNavigationBarIosView.setNavigationMode(mode);
    }

    @Override
    public NavigationBarIos addListItem(Icon icon, String content, int id) {
        if(mNavigationBarIosView == null){
            throw new NullPointerException("NavigationBarIosView is null");
        }
        if(!mNavigationBarIosView.isCurrentModeList()){
            throw new IllegalStateException("current Navigation Mode is not list, please set list mode");
        }
        if(mListMenus == null){
            mListMenus = new ArrayList<NavigationBarIosMenuView>();
        }

        NavigationBarIosMenuView menu = new NavigationBarIosMenuView(mActivity);
        if(icon != null){
            menu.setIcon(icon);
        }
        if(!TextUtils.isEmpty(content)){
            menu.setContent(content);
        }
        menu.setTag(id);
        mListMenus.add(menu);
        return this;
    }

    @Override
    public NavigationBarIos addTabsItem(Icon icon, String content, int id) {
        if(mNavigationBarIosView == null){
            throw new NullPointerException("NavigationBarIosView is null");
        }
        if(!mNavigationBarIosView.isCurrentModeTabs()){
            throw new IllegalStateException("current Navigation Mode is not tabs, please set list mode");
        }
        if(mTabsMenus == null){
            mTabsMenus = new ArrayList<NavigationBarIosMenuView>();
        }

        NavigationBarIosMenuView menu = new NavigationBarIosMenuView(mActivity);
        if(icon != null){
            menu.setIcon(icon);
        }
        if(!TextUtils.isEmpty(content)){
            menu.setContent(content);
        }
        menu.setTag(id);
        mTabsMenus.add(menu);
        return this;
    }

    @Override
    public void commit() {
        if(mNavigationBarIosView == null){
            throw new NullPointerException("NavigationBarIosView is null");
        }
        if(mNavigationBarIosView.isCurrentModeList()){
            mNavigationBarIosView.setListMenu(mListMenus);
            mNavigationBarIosView.requestListLayout();
        }

        if(mNavigationBarIosView.isCurrentModeTabs()){
            mNavigationBarIosView.setTabsMenu(mTabsMenus);
            mNavigationBarIosView.requestTabsLayout();
        }

        if(mListMenus != null)
            mListMenus.clear();
        if(mTabsMenus != null)
            mTabsMenus.clear();
    }

    /**
     * 设置Tabs menu的Padding属性  需要在创建Tabs Menu前使用
     * @param padding
     */
    @Override
    public void setTabsPadding(int padding) {
        mNavigationBarIosView.setDefaultTabsPadding(UIUtil.dip2px(mActivity, padding));
    }

    /**
     * 设置List menu的间隔属性 需要在创建List menu前使用
     * @param interval
     */
    @Override
    public void setListInterval(int interval) {
        mNavigationBarIosView.setDefaultListInterval(UIUtil.dip2px(mActivity, interval));
    }


    public void setNavigationBarIosListener(NavigationBarIosListener listener){
        if(mNavigationBarIosMenuPresenter == null){
            mNavigationBarIosMenuPresenter = new NavigationBarIosMenuPresenter(mActivity, listener);
        }else{
            mNavigationBarIosMenuPresenter.setmNavigationBarIosListener(listener);
        }
        if(mNavigationBarIosView != null){
            mNavigationBarIosView.setNavigationMenuPresenter(mNavigationBarIosMenuPresenter);
        }
    }



}
