package com.example.myrecyclviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.LinearLayout;

import com.cjj.MaterialRefreshLayout;
import com.example.myrecyclviewdemo.Constants.Contants;
import com.example.myrecyclviewdemo.adapter.HomepagerRecycleAdapter;
import com.example.myrecyclviewdemo.bean.Headerbean;
import com.example.myrecyclviewdemo.bean.HomeCategory;
import com.example.myrecyclviewdemo.bean.RefreshBean;
import com.example.myrecyclviewdemo.utils.RefreshUtils;
import com.example.myrecyclviewdemo.weidget.MyStaggerGrildLayoutManger;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements RefreshUtils.RefreshListenser {


    @Bind(R.id.rv_mainactivity)
    RecyclerView rvMainactivity;
    @Bind(R.id.mrl_mainactivity)
    MaterialRefreshLayout mrfMainactivity;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    private RefreshUtils refreshUtils;
    private Context mContext;
    private HomepagerRecycleAdapter homepagerRecycleAdapter;
    private boolean flagFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        initrefresh();
        initdata();

    }

    private void initdata() {
        //初始化recycleview 的适配器 以及布局管理器， 这里的管理器用的是流式布局，至于为何是流式布局，
        // 博客以及github上面有比较详细的讲解，欢迎查看，
        homepagerRecycleAdapter = new HomepagerRecycleAdapter(mContext);
        rvMainactivity.setAdapter(homepagerRecycleAdapter);
        //这里不用自定义的流式布局也是可以的，这里这是根据特定需要简单自定义了一个
        rvMainactivity.setLayoutManager(new MyStaggerGrildLayoutManger(mContext, 2, StaggeredGridLayoutManager.VERTICAL));


        //头部数据源
        getHeaderData();

        //获得分类数据源
        getcategoryData();


        //获取中间部分的数据源
        getCenterBean();


        //获取底部数据
        getRefreshData();

    }

    private void getHeaderData() {
        OkGo.get(Contants.API.HOST_SLIDLAYOUT)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        s = "{" + "\"data\":" + s + "}";

                        Headerbean headerbean = new Gson().fromJson(s, Headerbean.class);

                        if (headerbean != null) {

                            if (headerbean.getData().size() != 0) {
                                homepagerRecycleAdapter.setheaderbean(headerbean);

                            }
                        }

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        Log.e("ssss", "onError: " + e.toString());
                    }
                });
    }

    private void getcategoryData() {

        ArrayList<HomeCategory> homeCategories = new ArrayList<>();
        HomeCategory c1 = new HomeCategory(R.mipmap.icon_cart, "购物车");
        HomeCategory c2 = new HomeCategory(R.mipmap.icon_discover, "发现");
        HomeCategory c3 = new HomeCategory(R.mipmap.icon_hot, "热门");
        HomeCategory c4 = new HomeCategory(R.mipmap.icon_user, "寻找");
        homeCategories.add(c1);
        homeCategories.add(c2);
        homeCategories.add(c3);
        homeCategories.add(c4);
        homepagerRecycleAdapter.setCategoryBean(homeCategories);
    }

    private void getCenterBean() {

        OkGo.get(Contants.API.CAMPAIGN_HOME)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        s = "{" + "\"data\":" + s + "}";
                        RefreshBean refreshBean = new Gson().fromJson(s, RefreshBean.class);
                        if (refreshBean != null) {
                            if (refreshBean.getData().size() != 0) {
                                homepagerRecycleAdapter.setCenterBean(refreshBean);
                                refreshUtils.finishrefreshSleep();

                            }
                        }

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        Log.e("ssss", "onError: " + e.toString());
                        refreshUtils.finishrefresh();
                    }
                });


    }

    private void getRefreshData() {


        OkGo.get(Contants.API.CAMPAIGN_HOME)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        s = "{" + "\"data\":" + s + "}";
                        RefreshBean refreshBean = new Gson().fromJson(s, RefreshBean.class);
                        if (refreshBean != null) {
                            if (refreshBean.getData().size() != 0) {
                                homepagerRecycleAdapter.setRefreshBean(refreshBean, flagFirst);
                                if (flagFirst) {
                                    refreshUtils.finishrefreshSleep();
                                    flagFirst = false;
                                } else
                                    refreshUtils.finishrefresh();
                            }
                        }

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        Log.e("ssss", "onError: " + e.toString());
                        refreshUtils.finishrefresh();
                    }
                });

    }


    /**
     * 初始化刷新控件
     */
    private void initrefresh() {
        //用的是帮助类， 无需关心具体，可以用其他刷新控件
        refreshUtils = new RefreshUtils();
        refreshUtils.newBuilder(mContext).setRefreshLayout(mrfMainactivity)
                .setLoadMore(true).build(this);

    }

    @Override
    public void refreshdata() {
        //刷新控件下拉刷新的回掉方法
        flagFirst = true;

        initdata();//此处是为了模拟，直接用了这一个接口数据源




    }

    @Override
    public void loadrefreshdata() {
        //刷新控件上拉加载的回掉方法

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    getRefreshData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }


}
