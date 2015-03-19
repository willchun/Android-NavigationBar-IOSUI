package com.willchun.navigationbarios.widget;/**
 *@author willchun(277143980@qq.com)
 *@github https://github.com/willchun
 *@date 2015/3/19
 */

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.willchun.navigationbarios.R;

/**
 * Created by Administrator on 2015/3/19.
 */
public class NavigationBarIosView extends AbsNavigationBarIosView{

    public NavigationBarIosView(Context context){
        ((Activity)context).getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.lib_willchun_layout_ng_ios);
    }
}
