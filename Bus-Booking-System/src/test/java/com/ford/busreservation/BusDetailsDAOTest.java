package com.ford.busreservation;

import com.ford.busreservation.dao.BusDetailsDAO;
import org.junit.Before;
import org.junit.Test;

public class BusDetailsDAOTest {
    BusDetailsDAO busDetailsDAO;


    @Before
    public void setUp() {
        busDetailsDAO = new BusDetailsDAO();
    }

    @Test
    public void shouldCreateBusDetailsInDataBase(){
        busDetailsDAO.createBusDetailTable();
    }



}
