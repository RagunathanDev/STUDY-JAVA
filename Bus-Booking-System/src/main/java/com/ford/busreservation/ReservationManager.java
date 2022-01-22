package com.ford.busreservation;

import com.ford.busreservation.dao.BusDetailsDAO;
import com.ford.busreservation.dao.BusMasterDAO;
import com.ford.busreservation.model.BusDetails;
import com.ford.busreservation.model.BusMaster;
import com.ford.busreservation.model.PassengerInformation;
import com.ford.busreservation.model.Reservation;
import com.ford.busreservation.validation.Validate;

import java.io.*;
import java.util.*;

public class ReservationManager {
   private List<BusMaster> busMasterList;
   private List<PassengerInformation> currentPassengerList;
   private List<Reservation> currentReservationList;

   Validate validate = new Validate();
   BusMasterDAO busMasterDAO = new BusMasterDAO();
   BusDetailsDAO busDetailsDAO = new BusDetailsDAO();


    public ReservationManager() {
    }

    public ReservationManager(List<BusMaster> busMasterList, List<PassengerInformation> currentPassengerList, List<Reservation> currentReservationList) {
        this.busMasterList = busMasterList;
        this.currentPassengerList = currentPassengerList;
        this.currentReservationList = currentReservationList;
    }

    public List<BusMaster> getBusMasterList() {
        return busMasterList;
    }

    public void setBusMasterList(List<BusMaster> busMasterList) {
        this.busMasterList = busMasterList;
    }

    public List<PassengerInformation> getCurrentPassengerList() {
        return currentPassengerList;
    }

    public void setCurrentPassengerList(List<PassengerInformation> currentPassengerList) {
        this.currentPassengerList = currentPassengerList;
    }

    public List<Reservation> getCurrentReservationList() {
        return currentReservationList;
    }

    public void setCurrentReservationList(List<Reservation> currentReservationList) {
        this.currentReservationList = currentReservationList;
    }

        public List<BusMaster> readBusMasterCSVFile(String filePath) throws IOException {
            List<BusMaster> detailsInFile = new ArrayList<>();

            File file =  new File(filePath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            line= bufferedReader.readLine();
            while ((line = bufferedReader.readLine())!=null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
                String busNo = stringTokenizer.nextToken();
                String from = stringTokenizer.nextToken();
                String to = stringTokenizer.nextToken();
                String startingDate = stringTokenizer.nextToken();
                String startingTime = stringTokenizer.nextToken();
                String journeyTime = stringTokenizer.nextToken();
                int totalStop = Integer.parseInt(stringTokenizer.nextToken());
                String type = stringTokenizer.nextToken();
                BusMaster busMaster = new BusMaster(busNo, from, to, startingDate, startingTime, journeyTime, totalStop, type);
                detailsInFile.add(busMaster);

            }

            return detailsInFile;

        }


    public List<BusDetails> readBusDetailsCSVFile(String filePath) throws IOException {
        List<BusDetails> detailsInFile = new ArrayList<>();

        File file =  new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        line= bufferedReader.readLine();
        while ((line = bufferedReader.readLine())!=null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
            String busNo = stringTokenizer.nextToken();
            int totalSeats = Integer.parseInt(stringTokenizer.nextToken());
            int totalCommonSeats= Integer.parseInt(stringTokenizer.nextToken());
            int totalWomanOnlySeats = Integer.parseInt(stringTokenizer.nextToken());
            int totalSpecialSeats = Integer.parseInt(stringTokenizer.nextToken());
            int availableCommonSeats = Integer.parseInt(stringTokenizer.nextToken());
            int availableWomanSeats = Integer.parseInt(stringTokenizer.nextToken());
            int availableSpecialSeats = Integer.parseInt(stringTokenizer.nextToken());
            BusDetails busDetails = new BusDetails(busNo,totalSeats,totalCommonSeats,totalWomanOnlySeats,totalSpecialSeats,availableCommonSeats,availableWomanSeats,availableSpecialSeats);
                detailsInFile.add(busDetails);
        }
        return detailsInFile;
    }

    public Boolean writeBusMasterCsvDetailsToDB(String busMasterFilePath,String busDetailsFilePath,String errorFilePath) {
        boolean flag = true;
        //For ErrorFile
        File errorFile = null;
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;


        try {
            List<BusMaster> details = readBusMasterCSVFile(busMasterFilePath);
            errorFile = new File(errorFilePath);
            writer = new FileWriter(errorFile,true);
            bufferedWriter = new BufferedWriter(writer);

            Iterator iterator = details.iterator();
            while(iterator.hasNext()){
                BusMaster busMaster = (BusMaster) iterator.next();

                if (validate.isValidForBusMaster(busMaster)) {
                    flag =busMasterDAO.addValidEntriesToBusMasterTable(busMaster);
                    if(!flag){
                        return flag;
                    }
                } else {

                    bufferedWriter.write(busMaster.toString());
                    bufferedWriter.newLine();
                }
            }

            //For BusDetails
            List<BusDetails> listBusDetails = readBusDetailsCSVFile(busDetailsFilePath);


            Iterator iteratorBusDetails = listBusDetails.iterator();
            while(iteratorBusDetails.hasNext()){
                BusDetails busDetails = (BusDetails) iteratorBusDetails.next();
                if (validate.isValidForBusDetails(busDetails)) {
                    flag =busDetailsDAO.addValidEntriesToBusDetailTable(busDetails);
                    if(!flag){
                        return flag;
                    }
                } else {
                    bufferedWriter.write(busDetails.toString());
                    bufferedWriter.newLine();
                }
            }


            bufferedWriter.flush();
            return true;

        }catch(Exception e){
           e.printStackTrace();
           return false;
        }

    }

    public void loadBusMasterDetails() {
        busMasterList = busMasterDAO.loadBusMaster();


        busMasterList.stream().forEach(s -> {
            BusDetails busDetails = busDetailsDAO.loadBusDetails(s.getBusNo());
            s.getBusDetails(busDetails);
        });
        busMasterList.stream().forEach(s -> {
            System.out.println(s);
                });
        //System.out.println(busMasterList);
    }


}

