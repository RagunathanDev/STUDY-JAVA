package com.ford.busreservation;

import com.ford.busreservation.dao.BusDetailsDAO;
import com.ford.busreservation.dao.BusMasterDAO;
import com.ford.busreservation.model.BusDetails;
import com.ford.busreservation.model.BusMaster;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReservationManagerTest {
    ReservationManager reservationManager;
    BusMasterDAO busMasterDAO;
    BusDetailsDAO busDetailsDAO;
    @Before
    public void setUp(){
        reservationManager = new ReservationManager();
        busMasterDAO = new BusMasterDAO();
        busDetailsDAO = new BusDetailsDAO();
    }
    @Test
    public void shouldWriteValidatedBusMasterDetailsToDB(){
        busMasterDAO.createBusMasterTable();
        busDetailsDAO.createBusDetailTable();

        Assert.assertTrue(reservationManager.writeBusMasterCsvDetailsToDB("C:\\temp\\BusReservation\\Bus-Master.csv","C:\\temp\\BusReservation\\Bus-Details.csv","C:\\temp\\BusReservation\\error.txt"));
    }
    @Test
    public void shouldLoadDetails(){
        reservationManager.loadBusMasterDetails();
    }
}
