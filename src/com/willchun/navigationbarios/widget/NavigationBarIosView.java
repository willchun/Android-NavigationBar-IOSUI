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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.willchun.navigationbarios.R;
import com.willchun.navigationbarios.icon.Icon;
import com.willchun.navigationbarios.utils.IconfontUtil;
import com.willchun.navigationbarios.utils.UIUtil;

import java.util.ArrayList;
import java.util.List;

public class NavigationBarIosView extends AbsNavigationBarIosView implements View.OnClickListener {
    private static final String TAG = "NavigationBarIosView";

    private Activity mActivity;


    private RelativeLayout mNavigationLayout;
    private NavigationBarIosMenuView mTitleIcon;
    private NavigationBarIosMenuView mLeftIcon;
    private NavigationBarIosMenuView mRightIcon;

    private int mNavigationMode;

    private LinearLayout mListLayout;
    private ArrayList<NavigationBarIosMenuView> mViewMenus;
    private int LIST_INTERVAL = 8;//list模式间隔的大小

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
        mViewMenus = new ArrayList<NavigationBarIosMenuView>();
    }

    private void initBindView(){
        mNavigationLayout = relayout(R.id.lib_willchun_layout_ng_ios_layout_rl);
        mTitleIcon =  (NavigationBarIosMenuView)id(R.id.lib_willchun_layout_ng_title_icon);
        mLeftIcon = (NavigationBarIosMenuView)id(R.id.lib_willchun_layout_ng_left_icon);
        mRightIcon = (NavigationBarIosMenuView)id(R.id.lib_willchun_layout_ng_right_icon);
        mListLayout = (LinearLayout)id(R.id.lib_willchun_layout_ng_list_layout);

        mTitleIcon.setOnClickListener(this);
        mLeftIcon.setOnClickListener(this);
        mRightIcon.setOnClickListener(this);
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


    public void setTitle(String title){
        setTileImpl(title);
    }

    private void setTileImpl(String title){
        mTitle = title;
        if(mTitleIcon != null){
            mTitleIcon.setTitle(title);
            final boolean visible = (mDisplayOptions & NavigationBarIos.DISPLAY_SHOW_TITLE) != 0 && !TextUtils.isEmpty(mTitle);
            mTitleIcon.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }

    public void setLeftIcon(Icon icon){
        if(mLeftIcon != null){
            mLeftIcon.setIcon(icon);
        }
    }

    public void setLeftIcon(Icon icon, String content){
        if(mLeftIcon != null){
            mLeftIcon.setIcon(icon);
            if(!TextUtils.isEmpty(content))
                mLeftIcon.setContent(content);
        }
    }

    public void setRightIcon(Icon icon){
        if(mRightIcon != null){
            mRightIcon.setIcon(icon);
        }
    }

    public void setRightIcon(Icon icon, String content){
        if(mRightIcon != null){
            mRightIcon.setIcon(icon);
            if(!TextUtils.isEmpty(content))
                mRightIcon.setContent(content);
        }
    }

    public void setNavigationMode(int mode){
        int op = 0;
        switch (mode){
            case NavigationBarIos.NAVIGATION_MODE_STANDARD:
                op = NavigationBarIos.DISPLAY_SHOW_TITLE | NavigationBarIos.DISPLAY_SHOW_LEFT_ICON | NavigationBarIos.DISPLAY_SHOW_RIGHT_ICON;
                break;
            case NavigationBarIos.NAVIGATION_MODE_LIST:
                op = NavigationBarIos.DISPLAY_SHOW_TITLE | NavigationBarIos.DISPLAY_SHOW_LEFT_ICON | NavigationBarIos.DISPLAY_SHOW_LIST;
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


    public boolean isCurrentModeList(){
        return mNavigationMode == NavigationBarIos.NAVIGATION_MODE_LIST ? true:false;
    }

    public boolean isCurrentModeStandard(){
        return mNavigationMode == NavigationBarIos.NAVIGATION_MODE_STANDARD ? true:false;
    }

    private void setDisplayOptions(int options){
        final int flagsChanged = mDisplayOptions == -1 ? -1 : options ^ mDisplayOptions;
        mDisplayOptions = options;

        if ((flagsChanged & DISPLAY_ALL) != 0) {
            if((mDisplayOptions & NavigationBarIos.DISPLAY_SHOW_TITLE) != 0){
                mTitleIcon.setVisibility(View.VISIBLE);
            }else{
                mTitleIcon.setVisibility(View.GONE);
            }

            if((mDisplayOptions & NavigationBarIos.DISPLAY_SHOW_LEFT_ICON) != 0){
                mLeftIcon.setVisibility(View.VISIBLE);
            }else{
                mLeftIcon.setVisibility(View.GONE);
            }

            if((mDisplayOptions & NavigationBarIos.DISPLAY_SHOW_RIGHT_ICON) != 0){
                mRightIcon.setVisibility(View.VISIBLE);
            }else{
                mRightIcon.setVisibility(View.GONE);
            }

            if((mDisplayOptions & NavigationBarIos.DISPLAY_SHOW_LIST) != 0){
                mListLayout.setVisibility(View.VISIBLE);
            }else{
                mListLayout.setVisibility(View.GONE);
            }

            if((mDisplayOptions & NavigationBarIos.DISPLAY_SHOW_TABS) != 0){

            }else{

            }

        }
    }

    protected void requestListLayout(){
        if(mViewMenus != null && mViewMenus.size() > 0) {
            mListLayout.removeAllViews();
            int width = UIUtil.dip2px(mActivity, LIST_INTERVAL);
            int size = mViewMenus.size();
            for (int i=0; i<size; i++) {
                //增加间隔
                if(i != 0){
                    TextView intervalView = new TextView(mActivity);
                    intervalView.setWidth(width);
                    mListLayout.addView(intervalView);
                }
                mListLayout.addView(mViewMenus.get(i));
                mViewMenus.get(i).setOnClickListener(this);
            }
        }
    }

    public void setListMenu(List<NavigationBarIosMenuView> menus){
        if(mViewMenus != null)
            mViewMenus.clear();

        if(menus != null && menus.size() > 0){
            mViewMenus.addAll(menus);
        }
    }

    public void addListMenu(NavigationBarIosMenuView menu){
        if(mViewMenus == null|| menu == null)
            return;

        mViewMenus.add(menu);
    }

    @Override
    public void onClick(View v) {
        if(v instanceof NavigationBarIosMenuView)
        if(mNavigationBarIosMenuPresenter != null) {
            if (v == mTitleIcon) {
                mNavigationBarIosMenuPresenter.setOnClickTitle((NavigationBarIosMenuView)v);
            } else if (v == mLeftIcon) {
                mNavigationBarIosMenuPresenter.setOnClickLeftIcon((NavigationBarIosMenuView)v);
            } else if (v == mRightIcon) {
                mNavigationBarIosMenuPresenter.setOnClickRightIcon((NavigationBarIosMenuView)v);
            } else if (mNavigationMode == NavigationBarIos.NAVIGATION_MODE_LIST){

                for(NavigationBarIosMenuView menu : mViewMenus){
                    if(menu == v){
                        mNavigationBarIosMenuPresenter.setOnListSelected((NavigationBarIosMenuView)v);
                        return;
                    }
                }
            } else if (mNavigationMode == NavigationBarIos.NAVIGATION_MODE_TABS){

            }
        }
    }

    public void setNavigationMenuPresenter(NavigationBarIosMenuPresenter presenter){
        this.mNavigationBarIosMenuPresenter = presenter;
    }


}
