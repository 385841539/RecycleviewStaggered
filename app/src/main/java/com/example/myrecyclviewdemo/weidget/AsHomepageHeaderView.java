package com.example.myrecyclviewdemo.weidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myrecyclviewdemo.R;


/**
 * Created by ruedy on 2016/11/29.
 * 自定义view，首页item头部
 */

public class AsHomepageHeaderView extends RelativeLayout implements View.OnClickListener {


    private ImageView iv_more;
    private TextView tv_more;
    private TextView tv_type;
    private String typeName;
    private TextView iv_left;
    private Drawable leftDrawable;

    private Context mContext;
    private boolean isrightivtvvisible;


    public AsHomepageHeaderView(Context context) {
        this(context, null);
    }

    public AsHomepageHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AsHomepageHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initviews(context);
        initAttrs(attrs);

    }

    private void initviews(Context context) {
        View.inflate(context, R.layout.ashomepagerheaderview, this);
        iv_left = ((TextView) findViewById(R.id.iv_ashomeitem_left));
        iv_more = ((ImageView) findViewById(R.id.iv_ashomepagerheader_more));
        tv_more = ((TextView) findViewById(R.id.tv_ashomepagerheader_more));
        tv_type = ((TextView) findViewById(R.id.tv_ashomepagerheader_type));
    }

    private void initAttrs(AttributeSet attrs) {
        TintTypedArray tta = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                R.styleable.HomepageHeaderView);

        typeName = tta.getString(R.styleable.HomepageHeaderView_typename);
        leftDrawable = tta.getDrawable(R.styleable.HomepageHeaderView_lefthimage);
        isrightivtvvisible = tta.getBoolean(R.styleable.HomepageHeaderView_isrightivtvvisible, false);

        if (isrightivtvvisible) {
            tv_more.setVisibility(GONE);
            iv_more.setVisibility(GONE);

        }

//初始化textview的值，到时候需要动态设置



        if (typeName != null) {
            tv_type.setText(typeName + "");
        }
        tv_more.setOnClickListener(this);
        iv_more.setOnClickListener(this);

    }


    //对外提供给tv_type设置内容的方法
    public void setTypeName(String typename) {

        tv_type.setText(typename + "");


    }



    @Override
    public void onClick(View view) {
        if (moreclicklistenser != null) {

            moreclicklistenser.setmoreclicklistenser();
        }
    }

    public void setRightIvtVGone(boolean visibleless) {

        if (visibleless) {
            tv_more.setVisibility(GONE);
            iv_more.setVisibility(GONE);

        } else {
            tv_more.setVisibility(VISIBLE);
            iv_more.setVisibility(VISIBLE);

        }

    }

    //定义接口，当点击图片和文字跳转到新的页面
    public interface MoreclickListenser {
        public void setmoreclicklistenser();


    }

    public MoreclickListenser moreclicklistenser;

    public void setMoreclicklistenser(MoreclickListenser moreclicklistenser) {
        this.moreclicklistenser = moreclicklistenser;
    }
}
