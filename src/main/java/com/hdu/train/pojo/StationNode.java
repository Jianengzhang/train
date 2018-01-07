package com.hdu.train.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:28 18-1-7
 * @Modified By:
 */

@Entity
@Table(name = "station_node")
public class StationNode implements Serializable {
    private static final long serialVersionUID = 1L;

    int stationId1;
    int stationId2;
    int trainId;
    double distance;
    Date arriveTime;
    Date leaveTime;
    double price1;
    int restSite1;
    double price2;
    int restSite2;
    double price3;
    int restSite3;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStationId1() {
        return stationId1;
    }

    public void setStationId1(int stationId1) {
        this.stationId1 = stationId1;
    }

    public int getStationId2() {
        return stationId2;
    }

    public void setStationId2(int stationId2) {
        this.stationId2 = stationId2;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
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
