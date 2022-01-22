package com.ford.busreservation.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PassengerInformation {
    private long passengerId;
    private String name;
    private char sex;
    private int age;
    private String startingPoint;
    private String endingPoint;
    @DateTimeFormat(pattern = "dd-MMM-yy")
    private Date travelDate;
    private boolean isSpecialSeatNeeded;
    private boolean isWomenOnlySeatNeeded;

    public PassengerInformation() {
    }

    public PassengerInformation(long passengerId, String name, char sex, int age, String startingPoint, String endingPoint, Date travelDate, boolean isSpecialSeatNeeded, boolean isWomenOnlySeatNeeded) {
        this.passengerId = passengerId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.travelDate = travelDate;
        this.isSpecialSeatNeeded = isSpecialSeatNeeded;
        this.isWomenOnlySeatNeeded = isWomenOnlySeatNeeded;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        this.endingPoint = endingPoint;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public boolean isSpecialSeatNeeded() {
        return isSpecialSeatNeeded;
    }

    public void setSpecialSeatNeeded(boolean specialSeatNeeded) {
        isSpecialSeatNeeded = specialSeatNeeded;
    }

    public boolean isWomenOnlySeatNeeded() {
        return isWomenOnlySeatNeeded;
    }

    public void setWomenOnlySeatNeeded(boolean womenOnlySeatNeeded) {
        isWomenOnlySeatNeeded = womenOnlySeatNeeded;
    }


    @Override
    public String toString() {
        return "PassengerInformation{" +
                "passengerId=" + passengerId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", startingPoint='" + startingPoint + '\'' +
                ", endingPoint='" + endingPoint + '\'' +
                ", travelDate=" + travelDate +
                ", isSpecialSeatNeeded=" + isSpecialSeatNeeded +
                ", isWomenOnlySeatNeeded=" + isWomenOnlySeatNeeded +
                '}';
    }

    public static List<PassengerInformation> passengerInformationList() throws ParseException {

        PassengerInformation passenger1 = new PassengerInformation(123001l, "Bavadharini", 'F', 21, "Trichy", "Madurai", new SimpleDateFormat("dd-MMM-yy").parse("05-Aug-22"), false, true);
        PassengerInformation passenger2 = new PassengerInformation(123002l, "Kavya", 'F', 25, "Chennai", "Bangalore", new SimpleDateFormat("dd-MMM-yy").parse("01-Aug-22"), false, true);
        PassengerInformation passenger3 = new PassengerInformation(123004l, "Kiran", 'F', 23, "Chennai", "Madurai", new SimpleDateFormat("dd-MMM-yy").parse("02-Aug-22"), true, false);
        PassengerInformation passenger4 = new PassengerInformation(123005l, "Swathi", 'F', 32, "Madurai", "Bangalore", new SimpleDateFormat("dd-MMM-yy").parse("02-Aug-22"), false, true);
        PassengerInformation passenger5 = new PassengerInformation(123007l, "Raghu", 'F', 23, "Chennai", "Goa", new SimpleDateFormat("dd-MMM-yy").parse("03-Aug-22"), false, false);
        PassengerInformation passenger6 = new PassengerInformation(123003l, "Kousik", 'F', 24, "Trichy", "Madurai", new SimpleDateFormat("dd-MMM-yy").parse("05-Aug-22"), true, false);
        PassengerInformation passenger7 = new PassengerInformation(123006l, "Swetha", 'F', 28, "Chennai", "Bangalore", new SimpleDateFormat("dd-MMM-yy").parse("06-Aug-22"), true, false);
        PassengerInformation passenger8 = new PassengerInformation(123007l, "Bavadharini", 'F', 21, "Trichy", "Madurai", new SimpleDateFormat("dd-MMM-yy").parse("05-Aug-22"), false, true);
        return Arrays.asList(passenger1,passenger2,passenger3,passenger3,passenger4,passenger5,passenger6,passenger7,passenger8);


    }
//    public static List<Programmer> programmers(){
//        Programmer bavu = new Programmer(1, "bavu", Gender.FEMALE, LocalDate.of(1999, Month.OCTOBER, 16), 6000.0);
//        Programmer kiran = new Programmer(2, "kiran", Gender.MALE, LocalDate.of(1998, Month.JULY, 3), 14000.0);
//        Programmer swathi = new Programmer(3, "swathi", Gender.FEMALE, LocalDate.of(1996, Month.JUNE, 12), 23000.0);
//        Programmer abhi = new Programmer(4, "abhi", Gender.MALE, LocalDate.of(1997, Month.MARCH, 13), 2000.0);
//        Programmer kavya = new Programmer(5, "kavya", Gender.FEMALE, LocalDate.of(1993, Month.MARCH, 13), 2000.0);
//        Programmer praveen= new Programmer(6, "praveen", Gender.MALE, LocalDate.of(1995, Month.MARCH, 13), 9000.0);
//        //List<Programmer> programmerList = new ArrayList<Programmer>();
//        return Arrays.asList(bavu,kiran,swathi,abhi,kavya,praveen);



    }
