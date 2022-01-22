package com.ford.busreservation;

import com.ford.busreservation.dao.BusDetailsDAO;
import com.ford.busreservation.dao.BusMasterDAO;
import com.ford.busreservation.fileoperations.FileOperations;
import com.ford.busreservation.model.BusDetails;
import com.ford.busreservation.model.BusMaster;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FileOperationsTest {
    FileOperations fileOperations;
    BusMasterDAO busMasterDAO;
    BusDetailsDAO busDetailsDAO;

    @Before
    public void setUp(){
        fileOperations = new FileOperations();
        busMasterDAO = new BusMasterDAO();
        busDetailsDAO = new BusDetailsDAO();
    }

    @Test
    public void shouldReadFromCSVFileBusMaster() throws IOException {

        List<BusMaster> details = fileOperations.readFromACSVFile("C:\\temp\\BusReservation\\Bus-Master.csv","C:\\temp\\BusReservation\\error.txt");
        Iterator iterator = details.iterator();
        while(iterator.hasNext()){
            BusMaster object = (BusMaster) iterator.next();
            //busMasterDAO.addValidEntriesToBusMasterTable(object);

        }

    }

    @Test
    public void shouldReadFromCSVFileBusDetails() throws IOException {

        List<BusDetails> details = fileOperations.readFromACSVFileForBusDetails("C:\\temp\\BusReservation\\Bus-Details.csv","C:\\temp\\BusReservation\\error.txt");
        Iterator iterator = details.iterator();
        while(iterator.hasNext()){
            BusDetails object = (BusDetails) iterator.next();
            //busDetailsDAO.addValidEntriesToBusDetailTable(object);
            System.out.println("Database Obj::"+object);
        }

    }
}
