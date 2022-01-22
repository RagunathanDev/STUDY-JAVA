package com.ford.busreservation;

import com.ford.busreservation.dao.BusMasterDAO;
import com.ford.busreservation.model.BusMaster;
import org.junit.Before;
import org.junit.Test;

public class BusMasterDAOTest {
    BusMasterDAO busMasterDAO;

    @Before
    public void setUp(){
        busMasterDAO = new BusMasterDAO();
    }
    @Test
    public void shouldCreateBusMasterDetailsInDataBase(){
        busMasterDAO.createBusMasterTable();
    }

    @Test
    public void shouldAddDetailsToBusMaster(){
        BusMaster busMaster = new BusMaster("122S","Chennai","Bangalore","1-Aug-22","22:00","435 minutes",4,"Superfast");
        busMasterDAO.addValidEntriesToBusMasterTable(busMaster);
    }
}
