package com.example.myrecyclviewdemo.bean;

import java.util.List;

/**
 * Created by 丁瑞 on 2017/2/2.
 */

public class RefreshBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cpOne : {"id":17,"title":"手机专享","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/555c6c90Ncb4fe515.jpg"}
         * cpTwo : {"id":15,"title":"闪购","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/560a26d2N78974496.jpg"}
         * cpThree : {"id":11,"title":"团购","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/560be0c3N9e77a22a.jpg"}
         * id : 1
         * title : 超值购
         * campaignOne : 17
         * campaignTwo : 15
         * campaignThree : 11
         */

        private CpOneBean cpOne;
        private CpTwoBean cpTwo;
        private CpThreeBean cpThree;
        private int id;
        private String title;
        private int campaignOne;
        private int campaignTwo;
        private int campaignThree;

        public CpOneBean getCpOne() {
            return cpOne;
        }

        public void setCpOne(CpOneBean cpOne) {
            this.cpOne = cpOne;
        }

        public CpTwoBean getCpTwo() {
            return cpTwo;
        }

        public void setCpTwo(CpTwoBean cpTwo) {
            this.cpTwo = cpTwo;
        }

        public CpThreeBean getCpThree() {
            return cpThree;
        }

        public void setCpThree(CpThreeBean cpThree) {
            this.cpThree = cpThree;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCampaignOne() {
            return campaignOne;
        }

        public void setCampaignOne(int campaignOne) {
            this.campaignOne = campaignOne;
        }

        public int getCampaignTwo() {
            return campaignTwo;
        }

        public void setCampaignTwo(int campaignTwo) {
            this.campaignTwo = campaignTwo;
        }

        public int getCampaignThree() {
            return campaignThree;
        }

        public void setCampaignThree(int campaignThree) {
            this.campaignThree = campaignThree;
        }

        public static class CpOneBean {
            /**
             * id : 17
             * title : 手机专享
             * imgUrl : http://7mno4h.com2.z0.glb.qiniucdn.com/555c6c90Ncb4fe515.jpg
             */

            private int id;
            private String title;
            private String imgUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }
        }

        public static class CpTwoBean {
            /**
             * id : 15
             * title : 闪购
             * imgUrl : http://7mno4h.com2.z0.glb.qiniucdn.com/560a26d2N78974496.jpg
             */

            private int id;
            private String title;
            private String imgUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }
        }

        public static class CpThreeBean {
            /**
             * id : 11
             * title : 团购
             * imgUrl : http://7mno4h.com2.z0.glb.qiniucdn.com/560be0c3N9e77a22a.jpg
             */

            private int id;
            private String title;
            private String imgUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }
        }
    }
}
