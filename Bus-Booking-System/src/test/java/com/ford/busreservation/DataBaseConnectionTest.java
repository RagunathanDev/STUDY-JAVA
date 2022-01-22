package com.ford.busreservation;

import com.ford.busreservation.h2connection.DatabaseConnection;
import org.junit.Before;

public class DataBaseConnectionTest {
    DatabaseConnection databaseConnection;

    @Before
    public void setUp(){
        databaseConnection = new DatabaseConnection();
    }

}
