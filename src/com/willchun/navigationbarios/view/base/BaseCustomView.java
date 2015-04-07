package com.willchun.navigationbarios.view.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by will on 2015/3/6.
 */
public abstract  class BaseCustomView extends RelativeLayout implements View.OnClickListener{

    protected View innerView;
    protected Context mContext;

    public BaseCustomView(Context context) {
        super(context);
        init(context);

    }

    public BaseCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        setCustomAttributes(context, attrs);
    }

    public BaseCustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
        setCustomAttributes(context, attrs);
    }


    private void init(Context context){
        mContext = context;
        innerView = LayoutInflater.from(mContext).inflate(getInnerViewId(), null);
        initBind(context);
        addView(innerView);
        setSize(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

    }

    public TextView findTextView(int id){
        return (TextView)innerView.findViewById(id);
    }

    public void color(TextView view, int colorId){
        view.setTextColor(getResources().getColor(colorId));
    }

    /**
     * 获取自定义布局的ID
     * @return
     */
    public abstract  int getInnerViewId();

    /**
     * 绑定自己的变量ID和监听等
     * @param context
     */
    public abstract  void initBind(Context context);

    public abstract void setCustomAttributes(Context context, AttributeSet set);

    protected void setSize(int width, int height) {
        ViewUtils.setRelativeLayoutSize(innerView, width, height);
        ViewUtils.setRelativeLayoutSize(this, width, height);
    }
}
