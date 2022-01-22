package com.ford.busreservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ford.busreservation.h2connection.DatabaseConnection;
import com.ford.busreservation.model.BusDetails;

public class BusDetailsDAO {
	DatabaseConnection databaseConnection;
	Connection connection;
	int statement;
	ResultSet resultSet;
	PreparedStatement preparedStatement;

	public BusDetailsDAO() {
		databaseConnection = new DatabaseConnection();
		connection = databaseConnection.getConnection();
	}

	public void createBusDetailTable() {
		String query = "CREATE TABLE BUSDETAIL" + "(busNumber VARCHAR(255) PRIMARY KEY," + "totalSeats INTEGER,"
				+ "totalCommonSeats INTEGER," + "totalWomenSeats INTEGER," + "totalSpecialSeats INTEGER,"
				+ "availableCommonSeats INTEGER," + "availableWomenSeats INTEGER," + "availableSpecialSeats INTEGER)";

		try {
			statement = connection.createStatement().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Bus master table is created in database");

		}
	}

	public boolean addValidEntriesToBusDetailTable(BusDetails busDetails) {
		try {
			preparedStatement = connection.prepareStatement(
					"insert into busDetail(BUSNUMBER, TOTALSEATS, TOTALCOMMONSEATS, TOTALWOMENSEATS, TOTALSPECIALSEATS, AVAILABLECOMMONSEATS, AVAILABLEWOMENSEATS, AVAILABLESPECIALSEATS )values(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, busDetails.getBusNo());
			preparedStatement.setInt(2, busDetails.getTotalSeats());
			preparedStatement.setInt(3, busDetails.getTotalCommonSeats());
			preparedStatement.setInt(4, busDetails.getAvailableWomenSeats());
			preparedStatement.setInt(5, busDetails.getTotalSpecialSeats());
			preparedStatement.setInt(6, busDetails.getAvailableCommonSeats());
			preparedStatement.setInt(7, busDetails.getAvailableWomenSeats());
			preparedStatement.setInt(8, busDetails.getAvailableSpecialSeats());
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			System.out.println("New Row added to bus detail");
		}

	}

	public BusDetails loadBusDetails(String busNo) {
		String query = "SELECT * FROM BUSDETAIL WHERE BUSNUMBER=?";

		BusDetails busDetails = null;

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, busNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			busDetails = new BusDetails(resultSet.getString("BUSNUMBER"), resultSet.getInt("TOTALSEATS"),
					resultSet.getInt("TOTALCOMMONSEATS"), resultSet.getInt("TOTALWOMENSEATS"),
					resultSet.getInt("TOTALSPECIALSEATS"), resultSet.getInt("AVAILABLECOMMONSEATS"),
					resultSet.getInt("AVAILABLEWOMENSEATS"), resultSet.getInt("AVAILABLESPECIALSEATS"));
			return busDetails;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("BusDetails fetched successfully");
		}
		return busDetails;
	}
}
