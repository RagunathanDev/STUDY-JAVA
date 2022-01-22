package com.ford.busreservation.dao;

import com.ford.busreservation.model.BusMaster;
import com.ford.busreservation.h2connection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusMasterDAO {
    DatabaseConnection databaseConnection;
    Connection connection;
    int statement;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    public BusMasterDAO(){
        databaseConnection = new DatabaseConnection();
        connection = databaseConnection.getConnection();
    }

    public void createBusMasterTable(){
        String query = "CREATE TABLE BUSMASTER"+
                "(busNumber VARCHAR(255) PRIMARY KEY,"+
                "startPoint VARCHAR(255),"+
                "endPoint VARCHAR(255),"+
                "startingDate VARCHAR(255),"+
                "startingTime VARCHAR(255),"+
                "journeyTime VARCHAR(255),"+
                "totalStops INTEGER,"+
                "busType VARCHAR(255))";

        try {
            statement = connection.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Bus master table is created in database");

        }
    }

    public boolean addValidEntriesToBusMasterTable(BusMaster busMaster)  {
        try {
            preparedStatement = connection.prepareStatement("insert into busMaster(BUSNUMBER, STARTPOINT, ENDPOINT, STARTINGDATE, STARTINGTIME, JOURNEYTIME, TOTALSTOPS, BUSTYPE )values(?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,busMaster.getBusNo());
            preparedStatement.setString(2,busMaster.getFrom());
            preparedStatement.setString(3,busMaster.getTo());
            preparedStatement.setString(4,busMaster.getStartingDate());
            preparedStatement.setString(5,busMaster.getStartingTime());
            preparedStatement.setString(6,busMaster.getJourneyTime());
            preparedStatement.setInt(7,busMaster.getTotalStop());
            preparedStatement.setString(8,busMaster.getType());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            System.out.println("New Row added to bus master");
        }



    }

    public List<BusMaster> loadBusMaster() {
        String query = "SELECT * FROM BUSMASTER";
        Statement statement;
        ResultSet resultSet;
        ArrayList<BusMaster> busMasterList = null;
        try {

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            busMasterList = new ArrayList<BusMaster>();
            while (resultSet.next()) {
                BusMaster busMaster = new BusMaster(resultSet.getString("BUSNUMBER"), resultSet.getString("STARTPOINT"), resultSet.getString("ENDPOINT"), resultSet.getString("STARTINGDATE"), resultSet.getString("STARTINGTIME"), resultSet.getString("JOURNEYTIME"), resultSet.getInt("TOTALSTOPS"), resultSet.getString("BUSTYPE"));
                busMasterList.add(busMaster);
            }
            return busMasterList;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("fetch all bus master data");

        }
        return busMasterList;
    }

}
