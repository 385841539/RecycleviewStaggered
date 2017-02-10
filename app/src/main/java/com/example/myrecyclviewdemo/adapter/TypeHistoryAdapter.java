package com.example.myrecyclviewdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myrecyclviewdemo.R;
import com.example.myrecyclviewdemo.bean.RefreshBean;
import com.example.myrecyclviewdemo.weidget.ImageUtils;


import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 丁瑞 on 2017/1/3.
 * 首页热议
 */
public class TypeHistoryAdapter extends RecyclerView.Adapter<TypeHistoryAdapter.TypeHistoryHolder> {

    private Context mContext;

    private List<RefreshBean.DataBean> mHomehopspot;

    private LayoutInflater inflater;


    public TypeHistoryAdapter(Context mContext, List<RefreshBean.DataBean> mHomeCategory) {
        this.mContext = mContext;
        this.mHomehopspot = mHomeCategory;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public TypeHistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TypeHistoryHolder(inflater.inflate(R.layout.item_raiders, parent, false));
    }

    @Override
    public void onBindViewHolder(TypeHistoryHolder holder, int position) {
        RefreshBean.DataBean contentBean = mHomehopspot.get(position);
        ImageUtils.load(mContext, contentBean.getCpThree().getImgUrl(), holder.homeReadPivIv);
        holder.homeReadTitle.setText("#" + contentBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return mHomehopspot == null ? 0 : mHomehopspot.size();
    }

    public class TypeHistoryHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.home_read_piv_iv)
        ImageView homeReadPivIv;
        @Bind(R.id.home_read_title)
        TextView homeReadTitle;


        public TypeHistoryHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
