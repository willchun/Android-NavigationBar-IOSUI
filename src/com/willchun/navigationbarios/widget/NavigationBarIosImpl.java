package com.willchun.navigationbarios.widget;/**
 *@author willchun(277143980@qq.com)
 *@github https://github.com/willchun
 *@date 2015/3/19
 */

import android.app.Activity;
import com.willchun.navigationbarios.icon.Icon;

/**
 * Created by Administrator on 2015/3/19.
 */
public class NavigationBarIosImpl extends NavigationBarIos{

    private NavigationBarIosView mNavigationBarIosView;
    private Activity mActivity;

    public NavigationBarIosImpl(Activity activity) {
        mActivity = activity;
        mNavigationBarIosView = new NavigationBarIosView(activity);
    }

    @Override
    public void setLeftIcon(Icon icon) {

    }

    @Override
    public void setRightIcon(Icon icon) {

    }

    @Override
    public void setTitle(CharSequence title) {

    }
}
