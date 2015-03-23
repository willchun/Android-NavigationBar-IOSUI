package com.willchun.navigationbarios.widget;/**
 *@author willchun(277143980@qq.com)
 *@github https://github.com/willchun
 *@date 2015/3/19
 */

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.willchun.navigationbarios.R;
import com.willchun.navigationbarios.icon.Icon;
import com.willchun.navigationbarios.utils.IconfontUtil;

public class NavigationBarIosView extends AbsNavigationBarIosView{
    private static final String TAG = "NavigationBarIosView";

    private Activity mActivity;


    private RelativeLayout mNavigationLayout;
    private TextView mTitleTV;
    private TextView mLeftIcon;
    private TextView mRightIcon;
    private int mNavigationMode;

    private float mLayoutHeiht;
    private CharSequence mTitle;
    private int mDisplayOptions = -1;

    private final int DISPLAY_ALL =
            NavigationBarIos.DISPLAY_SHOW_LEFT_ICON |
            NavigationBarIos.DISPLAY_SHOW_TITLE |
            NavigationBarIos.DISPLAY_SHOW_LIST |
            NavigationBarIos.DISPLAY_SHOW_RIGHT_ICON |
            NavigationBarIos.DISPLAY_SHOW_TABS;

    public NavigationBarIosView(Context context){
        mActivity = ((Activity)context);
        mActivity.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.lib_willchun_layout_ng_ios);

        initDefault();
        initBindView();
        initAttrs();
    }

    private void initDefault(){

    }

    private void initBindView(){
        mNavigationLayout = relayout(R.id.lib_willchun_layout_ng_ios_layout_rl);
        mTitleTV =  text(R.id.lib_willchun_layout_ng_title_tv);
        mLeftIcon = text(R.id.lib_willchun_layout_ng_left_icon);
        mRightIcon = text(R.id.lib_willchun_layout_ng_right_icon);
    }

    private void initAttrs(){
        TypedArray a = mActivity.getTheme().obtainStyledAttributes(R.styleable.NavigationBarIos);
        int mode = a.getInt(R.styleable.NavigationBarIos_NavigationBarIos_mode, NavigationBarIos.NAVIGATION_MODE_STANDARD);
        setNavigationMode(mode);
        a.recycle();
    }


    private View id(int id){
        return mActivity.findViewById(id);
    }

    private TextView text(int id){
        return (TextView)id(id);
    }

    private RelativeLayout relayout(int id){
        return (RelativeLayout)id(id);
    }


    public void setTitle(CharSequence title){
        setTileImpl(title);
    }

    private void setTileImpl(CharSequence title){
        mTitle = title;
        if(mTitleTV != null){
            mTitleTV.setText(title);
            final boolean visible = (mDisplayOptions & NavigationBarIos.DISPLAY_SHOW_TITLE) != 0 && !TextUtils.isEmpty(mTitle);
            mTitleTV.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }

    public void setLeftIcon(Icon icon){
        if(mLeftIcon != null){
            IconfontUtil.setIcon(mActivity, mLeftIcon, icon);
        }
    }

    public void setRightIcon(Icon icon){
        if(mRightIcon != null){
            IconfontUtil.setIcon(mActivity, mRightIcon, icon);
        }
    }

    public void setNavigationMode(int mode){
        int op = 0;
        switch (mode){
            case NavigationBarIos.NAVIGATION_MODE_STANDARD:
                op = NavigationBarIos.DISPLAY_SHOW_TITLE | NavigationBarIos.DISPLAY_SHOW_LEFT_ICON | NavigationBarIos.DISPLAY_SHOW_RIGHT_ICON;
                break;
            case NavigationBarIos.NAVIGATION_MODE_LIST:

                break;
            case NavigationBarIos.NAVIGATION_MODE_TABS:

                break;
        }
        if(op == 0){
            throw new IllegalStateException(getClass().getName() + " Set Navigation Mode is failed, Please check navigation mode is effective");
        }

        mNavigationMode = mode;
        setDisplayOptions(op);
    }

    private void setDisplayOptions(int options){
        final int flagsChanged = mDisplayOptions == -1 ? -1 : options ^ mDisplayOptions;
        mDisplayOptions = options;

        if ((flagsChanged & DISPLAY_ALL) != 0) {
            if((flagsChanged & NavigationBarIos.DISPLAY_SHOW_TITLE) != 0){
                mTitleTV.setVisibility(View.VISIBLE);
            }else{
                mTitleTV.setVisibility(View.GONE);
            }

            if((flagsChanged & NavigationBarIos.DISPLAY_SHOW_LEFT_ICON) != 0){
                mLeftIcon.setVisibility(View.VISIBLE);
            }else{
                mLeftIcon.setVisibility(View.GONE);
            }

            if((flagsChanged & NavigationBarIos.DISPLAY_SHOW_RIGHT_ICON) != 0){
                mRightIcon.setVisibility(View.VISIBLE);
            }else{
                mRightIcon.setVisibility(View.GONE);
            }

            if((flagsChanged & NavigationBarIos.DISPLAY_SHOW_LIST) != 0){

            }else{

            }

            if((flagsChanged & NavigationBarIos.DISPLAY_SHOW_TABS) != 0){

            }else{

            }

        }
    }


}
