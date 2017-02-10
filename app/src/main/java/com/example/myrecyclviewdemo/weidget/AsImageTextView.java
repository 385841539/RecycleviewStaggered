package com.example.myrecyclviewdemo.weidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myrecyclviewdemo.R;


/**
 * Created by ruedy on 2016/11/30.
 */

public class AsImageTextView extends RelativeLayout implements View.OnClickListener {
    private ImageView ivImagetext;
    private TextView tvImagetext;

    public ImageView getIvImagetext() {
        return ivImagetext;
    }

    public void setIvImagetext(ImageView ivImagetext) {
        this.ivImagetext = ivImagetext;
    }

    public TextView getTvImagetext() {
        return tvImagetext;
    }

    public void setTvImagetext(TextView tvImagetext) {
        this.tvImagetext = tvImagetext;
    }

    public AsImageTextView(Context context) {
        this(context, null);
    }

    public AsImageTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AsImageTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.asimagetextview, this);
        ivImagetext = ((ImageView) findViewById(R.id.iv_imagetext));
        tvImagetext = ((TextView) findViewById(R.id.tv_imagetext));
        initattrs();
        //ivImagetext.setOnClickListener(this);
        //  tvImagetext.setOnClickListener(this);
    }

    private void initattrs() {

//如果需要静态设置，此处可拓展
    }

    public void setIvImagetext(int imageid) {
        Drawable drawable = getResources().getDrawable(imageid);

        if (drawable != null) {
            ivImagetext.setImageDrawable(drawable);
        }
    }

    public void setTvImagetext(String typename) {

        if (typename != null) {
            tvImagetext.setText(typename + "");

        }

    }

    @Override
    public void onClick(View view) {
        if (imagetextclick != null) {
            imagetextclick.setImagetextclick();

        }
    }

    public interface Imagetextclick {
        public void setImagetextclick();

    }

    public Imagetextclick imagetextclick;

    public Imagetextclick getImagetextclic() {
        return imagetextclick;
    }

    public void setImagetextclick(Imagetextclick imagetextclick) {
        this.imagetextclick = imagetextclick;
    }
}
