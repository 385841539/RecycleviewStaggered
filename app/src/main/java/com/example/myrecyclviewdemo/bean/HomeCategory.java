package com.example.myrecyclviewdemo.bean;


import android.app.Application;

import com.example.myrecyclviewdemo.app.Myappplication;

/**
 * Created by ruedy on 2016/11/30.
 */

public class HomeCategory {

    private int imageid;
    private String typename;

    public HomeCategory(int imageid, String typename) {

        this.imageid = imageid;
        this.typename = typename;
    }

    public HomeCategory(int imageid, int stringID) {

        this.imageid = imageid;
        typename = Myappplication.mContext.getResources().getString(stringID);
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
