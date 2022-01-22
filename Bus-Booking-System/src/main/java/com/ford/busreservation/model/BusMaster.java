package com.ford.busreservation.model;

import com.ford.busreservation.model.BusDetails;

import javax.validation.constraints.Pattern;


public class BusMaster {
    @Pattern(regexp="^[0-9]{3}[a-zA-z]",message = "should contain three digits and a alphabet")
    private String busNo;
    //@Pattern(regexp="^[a-zA-z]",message = "should not have numbers")
    private String from;
    private String to;
    private String startingDate;
    private String startingTime;
    private String journeyTime;
    private int totalStop;
    private String type;
    private BusDetails busDetails;

    public BusMaster() {
    }

    public BusMaster(String busNo, String from, String to, String startingDate, String startingTime, String journeyTime, int totalStop, String type) {
        this.busNo = busNo;
        this.from = from;
        this.to = to;
        this.startingDate = startingDate;
        this.startingTime = startingTime;
        this.journeyTime = journeyTime;
        this.totalStop = totalStop;
        this.type = type;
    }

    public BusMaster(String busNo, String from, String to, String startingDate, String startingTime, String journeyTime, int totalStop, String type, BusDetails busDetails) {
        this.busNo = busNo;
        this.from = from;
        this.to = to;
        this.startingDate = startingDate;
        this.startingTime = startingTime;
        this.journeyTime = journeyTime;
        this.totalStop = totalStop;
        this.type = type;
        this.busDetails = busDetails;
    }


    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getJourneyTime() {
        return journeyTime;
    }

    public void setJourneyTime(String journeyTime) {
        this.journeyTime = journeyTime;
    }

    public int getTotalStop() {
        return totalStop;
    }

    public void setTotalStop(int totalStop) {
        this.totalStop = totalStop;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BusDetails getBusDetails(BusDetails busDetails) {
        return this.busDetails;
    }

    public void setBusDetails(BusDetails busDetails) {
        this.busDetails = busDetails;
    }

    @Override
    public String toString() {
        return "BusMaster{" +
                "busNo='" + busNo + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", startingDate='" + startingDate + '\'' +
                ", startingTime='" + startingTime + '\'' +
                ", journeyTime='" + journeyTime + '\'' +
                ", totalStop=" + totalStop +
                ", type='" + type + '\'' +
//                ", busDetails=" + busDetails +
                '}';
    }
}

