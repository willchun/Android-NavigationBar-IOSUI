package com.willchun.navigationbarios.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.willchun.navigationbarios.icon.Icon;


public class IconfontUtil {

    public static void addIcon(Context context, TextView textView, Icon... icons) {
        addIcon(context, textView, null, icons);
    }

    public static void setIcon(Context context, TextView textView, Icon... icons) {
        setIcon(context, textView, null, icons);
    }

    public static void addIcon(Context context, TextView textView, int fontSize, Icon... icons) {
        addIcon(context, textView, null, fontSize, icons);
    }

    public static void setIcon(Context context, TextView textView, int fontSize, Icon... icons) {
        setIcon(context, textView, null, fontSize, icons);
    }

    /**
     * append一个icon到TextView
     * 
     * @param context
     * @param textView
     * @param iconColor
     *            color值为"#ffffff"类型, 传null为TextView默认颜色, 暂不支持八位如"#ff000000"
     * @param icons
     *            如果传多个参数，icons必须是同一个字体内，否者可能会显示不正常
     */
    public static void addIcon(Context context, TextView textView, String iconColor, int fontSize, Icon... icons) {
        if (icons == null) {
            return;
        }

        for (Icon icon : icons) {
            textView.setTypeface(icon.getIconicTypeface().getTypeface(context));
            String mIconUtfStr = new String(Character.toChars(icon.getIconUtfValue()));
            Spannable sp = new SpannableString(mIconUtfStr);

            if (!TextUtils.isEmpty(iconColor)) {
                sp.setSpan(new ForegroundColorSpan(parseColor(iconColor)), 0, mIconUtfStr.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            if (fontSize > 0) {
                int fontSizePx = (int) UIUtil.sp2px(context, (float) fontSize);
                sp.setSpan(new AbsoluteSizeSpan(fontSizePx), 0, mIconUtfStr.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            textView.append(sp);
        }
    }

    public static Spannable getIconSpannable(Context context, String iconColor, int fontSize, Icon icon) {
        String mIconUtfStr = new String(Character.toChars(icon.getIconUtfValue()));
        Spannable sp = new SpannableString(mIconUtfStr);

        if (!TextUtils.isEmpty(iconColor)) {
            sp.setSpan(new ForegroundColorSpan(parseColor(iconColor)), 0, mIconUtfStr.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if (fontSize > 0) {
            int fontSizePx = (int) UIUtil.sp2px(context, (float) fontSize);
            sp.setSpan(new AbsoluteSizeSpan(fontSizePx), 0, mIconUtfStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return sp;
    }

    /**
     * 添加Icon置于TextView左边
     * 
     * @param context
     * @param textView
     * @param iconColor
     * @param fontSize
     * @param icons
     */
    public static void addIconLeft(Context context, TextView textView, String iconColor, int fontSize, Icon... icons) {
        for (Icon icon : icons) {
            String text = textView.getText().toString();
            textView.setText("");
            addIcon(context, textView, iconColor, fontSize, icon);
            textView.append(text);
        }
    }

    public static void addIcon(Context context, TextView textView, String iconColor, Icon... icons) {
        addIcon(context, textView, iconColor, 0, icons);
    }

    public static void setIcon(Context context, TextView textView, String iconColor, Icon... icons) {
        textView.setText("");
        addIcon(context, textView, iconColor, icons);
    }

    public static void setIcon(Context context, TextView textView, String iconColor, int fontSize, Icon... icons) {
        textView.setText("");
        addIcon(context, textView, iconColor, fontSize, icons);
    }

    private static int parseColor(String str) {
        String color = "";
        if (str.length() == 9) {
            color = str.substring(3, str.length());
        } else if (str.length() == 7) {
            color = str.substring(1, str.length());
        } else {
            return Color.BLACK;
        }

        int r = Integer.parseInt(color.substring(0, 2), 16);
        int g = Integer.parseInt(color.substring(2, 4), 16);
        int b = Integer.parseInt(color.substring(4, 6), 16);

        return Color.rgb(r, g, b);
    }
}
