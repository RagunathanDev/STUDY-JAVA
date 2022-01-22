package com.ford.busreservation;

import com.ford.busreservation.model.BusDetails;
import com.ford.busreservation.model.BusMaster;
import com.ford.busreservation.validation.Validate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class ValidationTest {
    BusMaster busMaster;
    BusDetails busDetails;
    Validate validate;
    @Before
    public void SetUp(){
        busMaster = new BusMaster();
        busDetails= new BusDetails();
        validate = new Validate();
    }

    @Test
    public void shouldReturnBusMasterValues() {
        DateTimeFormatter formatDate = new DateTimeFormatterBuilder().parseCaseSensitive().appendPattern("dd-MMM-yy")
                .toFormatter();
        DateTimeFormatter pojoFormat = DateTimeFormatter.ofPattern("dd-MMM-yy");
        LocalDate date = LocalDate.parse("21-Jan-21", formatDate);
        System.out.println(pojoFormat.format(date));

        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time2 = LocalTime.parse("22:33", time);
        System.out.println(time2);




    }


    @Test
    public void shouldReturnBusDetailsValues(){
        BusDetails busDetails1= new BusDetails("122S",32,26,4,2,26,4,2);
        String expected = "BusDetails{" +
                "busNo='" + "122S" + '\'' +
                ", totalSeats=" + "32" +
                ", totalCommonSeats=" + "26" +
                ", totalWomenOnlySeats=" + "4" +
                ", totalSpecialSeats=" + "2" +
                ", availableCommonSeats=" + "26" +
                ", availableWomenSeats=" + "4" +
                ", availableSpecialSeats=" + "2" +
                '}';
        Assert.assertEquals(expected,busDetails1.toString());
    }

    @Test
    public void validateBusMaster(){
        BusMaster busMaster1 = new BusMaster("122S","Chennai","Bangalore","1-Aug-22","22:00","435 minutes",4,"Superfast");
        Assert.assertTrue(validate.isValidForBusMaster(busMaster1));
    }

    @Test
    public void validateBusDetails(){
        BusDetails busDetails2 = new BusDetails("122S",32,26,4,2,26,4,2);
        Assert.assertTrue(validate.isValidForBusDetails(busDetails2));
    }
//    failing conditions
//    @Test
//    public void readTestOfBusMaster(){
//        Validate validate1 = new Validate();
//        validate1.readCSVBusMaster();
//    }

}
