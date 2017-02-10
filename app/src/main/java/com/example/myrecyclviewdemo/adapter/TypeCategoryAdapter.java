package com.example.myrecyclviewdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myrecyclviewdemo.R;
import com.example.myrecyclviewdemo.bean.HomeCategory;
import com.example.myrecyclviewdemo.weidget.AsImageTextView;


import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 666 on 2017/1/3.
 * 首页分类
 */
public class TypeCategoryAdapter extends RecyclerView.Adapter<TypeCategoryAdapter.TypetypeHolder> {

    private Context mContext;

    private List<HomeCategory> mHomeCategory;

    private LayoutInflater inflater;


    public TypeCategoryAdapter(Context mContext, List<HomeCategory> mHomeCategory) {
        this.mContext = mContext;
        this.mHomeCategory = mHomeCategory;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public TypetypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TypetypeHolder(inflater.inflate(R.layout.item_homepageradapter_ivtv, null));
    }

    @Override
    public void onBindViewHolder(TypetypeHolder holder, int position) {
        HomeCategory homeCategory = mHomeCategory.get(position);
        holder.asivtvHomepageradapter.setTvImagetext(homeCategory.getTypename());
        holder.asivtvHomepageradapter.setIvImagetext(homeCategory.getImageid());
    }

    @Override
    public int getItemCount() {
        return mHomeCategory == null ? 0 : mHomeCategory.size();
    }

    //中间的四个type
    public class TypetypeHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.asivtv_homepageradapter)
        AsImageTextView asivtvHomepageradapter;

        public TypetypeHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
