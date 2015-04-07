package com.willchun.navigationbarios.widget;/**
 *@author willchun(277143980@qq.com)
 *@github https://github.com/willchun
 *@date 2015/4/7
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.willchun.navigationbarios.R;
import com.willchun.navigationbarios.icon.Icon;
import com.willchun.navigationbarios.utils.IconfontUtil;
import com.willchun.navigationbarios.view.base.BaseCustomView;

/**
 * Created by Administrator on 2015/4/7.
 */
public class NavigationBarIosMenuView extends BaseCustomView{

    private TextView mIconTV;
    private TextView mContentTV;


    public NavigationBarIosMenuView(Context context) {
        super(context);
        setSize(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    public NavigationBarIosMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setSize(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    public NavigationBarIosMenuView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setSize(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    public int getInnerViewId() {
        return R.layout.lib_willchun_layout_ng_ios_menu;
    }

    @Override
    public void initBind(Context context) {
        mIconTV = (TextView)innerView.findViewById(R.id.lib_willchun_layout_ng_ios_menu_icon);
        mContentTV = (TextView)innerView.findViewById(R.id.lib_willchun_layout_ng_ios_menu_content_tv);

    }

    @Override
    public void setCustomAttributes(Context context, AttributeSet set) {
        TypedArray a = context.obtainStyledAttributes(set, R.styleable.NavigationBarIosMenu);

        a.recycle();
    }

    @Override
    public void onClick(View v) {

    }

    public void setIcon(Icon icon){
        IconfontUtil.setIcon(mContext, mIconTV, icon);
    }

    public void setContent(String content){
        mContentTV.setText(content);
    }
}
