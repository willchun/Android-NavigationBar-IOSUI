package com.willchun.navigationbarios.iconfont;


import com.willchun.navigationbarios.R;
import com.willchun.navigationbarios.icon.Icon;
import com.willchun.navigationbarios.icon.TypefaceManager;

public enum WillChunIcon implements Icon {
    // @formatter:on
    ICON_FANHUI(0xf0292), ICON_JIA(0xf0175), ICON_DINGXIANG(0xf0295);
    //@formatter:off

    private final int mIconUtfValue;

    private WillChunIcon(int iconUtfValue) {
        mIconUtfValue = iconUtfValue;
    }

    @Override
    public TypefaceManager.IconicTypeface getIconicTypeface() {
        return TypefaceManager.IconicTypeface.getInstance(R.raw.willchun);
    }

    @Override
    public int getIconUtfValue() {
        return mIconUtfValue;
    }

}