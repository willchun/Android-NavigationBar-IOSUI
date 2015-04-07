package com.willchun.navigationbarios.widget;/**
 *@author willchun(277143980@qq.com)
 *@github https://github.com/willchun
 *@date 2015/3/19
 */

import android.app.Activity;
import android.widget.TextView;
import com.willchun.navigationbarios.icon.Icon;

/**
 * Created by Administrator on 2015/3/19.
 */
public class NavigationBarIosImpl extends NavigationBarIos{

    private NavigationBarIosView mNavigationBarIosView;
    private NavigationBarIosMenuPresenter mNavigationBarIosMenuPresenter;

    private Activity mActivity;

    public NavigationBarIosImpl(Activity activity) {
        mActivity = activity;
        mNavigationBarIosView = new NavigationBarIosView(activity);
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
    public void setTitle(CharSequence title) {
        mNavigationBarIosView.setTitle(title);
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
