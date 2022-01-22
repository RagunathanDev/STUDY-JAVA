package com.ford.busreservation.fileoperations;

import com.ford.busreservation.validation.Validate;
import com.ford.busreservation.model.BusDetails;
import com.ford.busreservation.model.BusMaster;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileOperations {
    Validate validate = new Validate();


    public List<BusMaster> readFromACSVFile(String filePath, String errorFilePath) throws IOException {
        List<BusMaster> detailsInFile = new ArrayList<>();
        //List<BusMaster> validDetailsInFile = new ArrayList<>();

        //For ErrorFile
        File errorFile = null;
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        errorFile = new File(errorFilePath);
        writer = new FileWriter(errorFile,true);
        bufferedWriter = new BufferedWriter(writer);


        File file =  new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        line= bufferedReader.readLine();
        while ((line = bufferedReader.readLine())!=null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
            String busNo = stringTokenizer.nextToken();
            String from = stringTokenizer.nextToken();
            String to= stringTokenizer.nextToken();
            String startingDate = stringTokenizer.nextToken();
            String startingTime = stringTokenizer.nextToken();
            String journeyTime = stringTokenizer.nextToken();
            int totalStop = Integer.parseInt(stringTokenizer.nextToken());
            String type = stringTokenizer.nextToken();
            BusMaster busMaster = new BusMaster(busNo,from,to,startingDate,startingTime,journeyTime,totalStop,type);
            if(validate.isValidForBusMaster(busMaster)){
                detailsInFile.add(busMaster);
                // System.out.println("InValid :: "+busDetails);
            }else{
                // System.out.println("InValid :: "+busDetails);
                bufferedWriter.write(busMaster.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }




        return detailsInFile;
    }

    public List<BusDetails> readFromACSVFileForBusDetails(String filePath, String errorFilePath) throws IOException {
        List<BusDetails> detailsInFile = new ArrayList<>();
        //List<BusDetails> validDetailsInFile = new ArrayList<>();

        //For ErrorFile
        File errorFile = null;
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        errorFile = new File(errorFilePath);
        writer = new FileWriter(errorFile,true);
        bufferedWriter = new BufferedWriter(writer);

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
            if(validate.isValidForBusDetails(busDetails)){
                //System.out.println("Valid ::"+busDetails);
                detailsInFile.add(busDetails);
            }else{
               // System.out.println("InValid :: "+busDetails);
                bufferedWriter.write(busDetails.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();


        }
        bufferedReader.close();
       // writer.close();
        //bufferedWriter.close();

        return detailsInFile;
    }
}
