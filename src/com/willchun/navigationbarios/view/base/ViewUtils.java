package com.willchun.navigationbarios.view.base;

import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by will on 2015/3/5.
 */
public class ViewUtils {

    public static void setRelativeLayoutSize(View v, int width, int height) {
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) v.getLayoutParams();
        if (lp == null) {
            lp = new RelativeLayout.LayoutParams(width, height);
        } else {
            lp.width = width;
            lp.height = height;
        }
        v.setLayoutParams(lp);
    }
}
