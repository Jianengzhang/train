package com.hdu.train.pojo.Vo;

import java.util.Date;

public class DisplayVo {
    String stationName1;
    String stationName2;
    String trainName;
    Date arriveTime;
    Date leaveTime;
    double price1;
    int restSite1;
    double price2;
    int restSite2;
    double price3;
    int restSite3;

    public DisplayVo(String stationName1, String stationName2, String trainName, Date arriveTime, Date leaveTime, double price1, int restSite1, double price2, int restSite2, double price3, int restSite3) {
        this.stationName1 = stationName1;
        this.stationName2 = stationName2;
        this.trainName = trainName;
        this.arriveTime = arriveTime;
        this.leaveTime = leaveTime;
        this.price1 = price1;
        this.restSite1 = restSite1;
        this.price2 = price2;
        this.restSite2 = restSite2;
        this.price3 = price3;
        this.restSite3 = restSite3;
    }

    public String getStationName1() {
        return stationName1;
    }

    public void setStationName1(String stationName1) {
        this.stationName1 = stationName1;
    }

    public String getStationName2() {
        return stationName2;
    }

    public void setStationName2(String stationName2) {
        this.stationName2 = stationName2;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public double getPrice1() {
        return price1;
    }

    public void setPrice1(double price1) {
        this.price1 = price1;
    }

    public int getRestSite1() {
        return restSite1;
    }

    public void setRestSite1(int restSite1) {
        this.restSite1 = restSite1;
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(double price2) {
        this.price2 = price2;
    }

    public int getRestSite2() {
        return restSite2;
    }

    public void setRestSite2(int restSite2) {
        this.restSite2 = restSite2;
    }

    public double getPrice3() {
        return price3;
    }

    public void setPrice3(double price3) {
        this.price3 = price3;
    }

    public int getRestSite3() {
        return restSite3;
    }

    public void setRestSite3(int restSite3) {
        this.restSite3 = restSite3;
    }
}
