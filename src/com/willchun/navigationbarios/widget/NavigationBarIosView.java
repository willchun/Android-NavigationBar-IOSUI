package com.willchun.navigationbarios.widget;/**
 *@author willchun(277143980@qq.com)
 *@github https://github.com/willchun
 *@date 2015/3/19
 */

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.willchun.navigationbarios.R;
import com.willchun.navigationbarios.icon.Icon;
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
    private ArrayList<NavigationBarIosMenuView> mViewListMenus;
    private int mDefaultListInterval = 0;//list模式间隔的大小

    private LinearLayout mTabsLayout;
    private ArrayList<NavigationBarIosMenuView> mViewTabsMenus;
    private int mSelectedMenuId = -1;//当前选中的MENU的id
    private int mDefaultTabsPadding;


    private int mTabsUnSelectBgColor = R.color.lib_willchun_ng_ios_title_color;
    private int mTabsUnSelectTextColor = R.color.lib_willchun_ng_ios_theme_bg_color;
    private int mTabsSelectBgColor = R.color.lib_willchun_ng_ios_theme_bg_color;
    private int mTabsSelectTextColor = R.color.lib_willchun_ng_ios_title_color;

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
        mDefaultListInterval = UIUtil.dip2px(mActivity, 8);
        mViewListMenus = new ArrayList<NavigationBarIosMenuView>();
        mViewTabsMenus = new ArrayList<NavigationBarIosMenuView>();
    }

    private void initBindView(){
        mNavigationLayout = relayout(R.id.lib_willchun_layout_ng_ios_layout_rl);
        mTitleIcon =  (NavigationBarIosMenuView)id(R.id.lib_willchun_layout_ng_title_icon);
        mLeftIcon = (NavigationBarIosMenuView)id(R.id.lib_willchun_layout_ng_left_icon);
        mRightIcon = (NavigationBarIosMenuView)id(R.id.lib_willchun_layout_ng_right_icon);
        mListLayout = (LinearLayout)id(R.id.lib_willchun_layout_ng_list_layout);
        mTabsLayout = (LinearLayout)id(R.id.lib_willchun_layout_ng_ios_tabs_layout);

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

    private int color(int id){
        return mActivity.getResources().getColor(id);
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
                op = NavigationBarIos.DISPLAY_SHOW_LEFT_ICON | NavigationBarIos.DISPLAY_SHOW_TABS;
                break;
        }
        if(op == 0){
            throw new IllegalStateException(getClass().getName() + " Set Navigation Mode is failed, Please check navigation mode is effective");
        }

        mNavigationMode = mode;
        setDisplayOptions(op);
    }


    public boolean isCurrentModeList(){
        return mNavigationMode == NavigationBarIos.NAVIGATION_MODE_LIST;
    }

    public boolean isCurrentModeStandard(){
        return mNavigationMode == NavigationBarIos.NAVIGATION_MODE_STANDARD;
    }

    public boolean isCurrentModeTabs(){
        return mNavigationMode == NavigationBarIos.NAVIGATION_MODE_TABS;
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
                mTabsLayout.setVisibility(View.VISIBLE);
            }else{
                mTabsLayout.setVisibility(View.GONE);
            }

        }
    }

    protected void requestListLayout(){
        if(mViewListMenus != null && mViewListMenus.size() > 0) {
            mListLayout.removeAllViews();
            int size = mViewListMenus.size();
            for (int i=0; i<size; i++) {
                //增加间隔
                if(i != 0){
                    TextView intervalView = new TextView(mActivity);
                    intervalView.setWidth(mDefaultListInterval);
                    mListLayout.addView(intervalView);
                }
                mListLayout.addView(mViewListMenus.get(i));
                mViewListMenus.get(i).setOnClickListener(this);
            }
        }
    }

    protected void requestTabsLayout(){
        if(mViewTabsMenus != null && mViewTabsMenus.size() > 0) {
            mTabsLayout.removeAllViews();
            int size = mViewTabsMenus.size();
            for(int i=0; i<size; i++){
                mTabsLayout.addView(mViewTabsMenus.get(i));
                if(mDefaultTabsPadding > 0)
                    mViewTabsMenus.get(i).setLeftAndRightPadding(mDefaultTabsPadding);

                mViewTabsMenus.get(i).setOnClickListener(this);
                //默认以第一个
                if(mSelectedMenuId == -1 && i == 0){
                    mSelectedMenuId = (Integer)mViewTabsMenus.get(i).getTag();
                }
            }

            refreshTabsUI();
        }
    }

    protected void refreshTabsUI(){
        if(mViewTabsMenus != null){
            for(NavigationBarIosMenuView menu : mViewTabsMenus){
                if((Integer)menu.getTag() == mSelectedMenuId){
                    menu.setBgAndFontColor(color(mTabsSelectBgColor), color(mTabsSelectTextColor));
                }else{
                    menu.setBgAndFontColor(color(mTabsUnSelectBgColor), color(mTabsUnSelectTextColor));
                }
            }
        }
    }

    public void setDefaultTabsPadding(int padding){
        mDefaultTabsPadding = padding;
    }

    public void setDefaultListInterval(int interval){
        mDefaultListInterval = interval;
    }

    public void setListMenu(List<NavigationBarIosMenuView> menus){
        if(mViewListMenus != null) {
            mViewListMenus.clear();
            if(menus != null && menus.size() > 0){
                mViewListMenus.addAll(menus);
            }
        }

    }

    public void addListMenu(NavigationBarIosMenuView menu){
        if(mViewListMenus == null|| menu == null)
            return;

        mViewListMenus.add(menu);
    }

    public void setTabsMenu(List<NavigationBarIosMenuView> menus){
        if(mViewTabsMenus != null) {
            mViewTabsMenus.clear();
            if(menus != null && menus.size() > 0){
                mViewTabsMenus.addAll(menus);
            }
        }

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

                for(NavigationBarIosMenuView menu : mViewListMenus){
                    if(menu == v){
                        mNavigationBarIosMenuPresenter.setOnListSelected((NavigationBarIosMenuView)v);
                        return;
                    }
                }
            } else if (mNavigationMode == NavigationBarIos.NAVIGATION_MODE_TABS){
                for(NavigationBarIosMenuView menu : mViewTabsMenus){
                    if(menu == v){
                        mNavigationBarIosMenuPresenter.setOnTabsSelected((NavigationBarIosMenuView)v);
                        mSelectedMenuId = (Integer)v.getTag();
                        refreshTabsUI();
                        return;
                    }
                }
            }
        }
    }

    public void setNavigationMenuPresenter(NavigationBarIosMenuPresenter presenter){
        this.mNavigationBarIosMenuPresenter = presenter;
    }


}
