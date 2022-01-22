package com.ford.busreservation.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Reservation {
    private int seatNumber;
    private PassengerInformation passengerInformation;
    private BusMaster busMaster;

    public Reservation() {
    }

    public Reservation(int seatNumber, PassengerInformation passengerInformation, BusMaster busMaster) {
        this.seatNumber = seatNumber;
        this.passengerInformation = passengerInformation;
        this.busMaster = busMaster;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public PassengerInformation getPassengerInformation() {
        return passengerInformation;
    }

    public void setPassengerInformation(PassengerInformation passengerInformation) {
        this.passengerInformation = passengerInformation;
    }

    public BusMaster getBusMaster() {
        return busMaster;
    }

    public void setBusMaster(BusMaster busMaster) {
        this.busMaster = busMaster;
    }

    @Override
    public String toString() {

//        From: Chennai To: Madurai Date: 02-Aug-2019 Time: 20:30	Seat No: 7
//        Passenger Name: Ramkumar Age: 34 Sex: Male Seat Preferences: Normal [other values may be Woman Only or Special].


        return "From: " + busMaster.getFrom() + " To: " + busMaster.getTo() + " Date: " + busMaster.getStartingDate()
                + " Time: " + busMaster.getStartingTime() + " Seat No: " + seatNumber + "\n" +
                "Passenger Name: " + passengerInformation.getName() + " Age: " + passengerInformation.getAge() +
                " Sex: " +(String.valueOf(passengerInformation.getSex()).equals("F") ? "Female" : "Male") + " Seat Preferences: " + ((passengerInformation.isSpecialSeatNeeded() == true ? "Special" : (passengerInformation.isWomenOnlySeatNeeded() == true ? "Women" : "Normal")));

    }

//    public static void main(String[] args) throws ParseException {
//        Reservation reservation = new Reservation();
//        reservation.setSeatNumber(4);
//        reservation.setPassengerInformation(new PassengerInformation(123007l, "Bavadharini", 'F', 21, "Trichy", "Madurai", new SimpleDateFormat("dd-MMM-yy").parse("05-Aug-22"), false, true));
//        reservation.setBusMaster(new BusMaster("122S","Chennai","Bangalore","01-Aug-22","22:00","435 minutes",4,"Superfast"));
//
//        System.out.println(reservation);
//
//
//    }
}
