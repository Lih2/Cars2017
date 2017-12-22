package ru.ocrimea;

import java.io.IOException;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        String fileNameIn, fileNameOut;

        if(args.length != 2 ) {
            System.out.println("PROGRAM USAGE ERROR: Cars2017 fileIn fileOut\n");
            return;
        }
        fileNameIn=args[0];
        fileNameOut=args[1];

        CarConverterReaderCSV converterReader;
        CarConverterWriterJSON converterWriter;

        ArrayList<Car> cars=new ArrayList<>();

        try {
            converterReader= new CarConverterReaderCSV(fileNameIn, ',');
            cars=converterReader.readFile();
        }
        catch(IOException e) {
            System.out.println("READ FILE ERROR");
            return;
        }
        catch(IllegalArgumentException e) {
            System.out.println("FORMAT FILE ERROR");
            return;
        }

        System.out.println("TOTAL CARS " + cars.size() +"\n");

        try {
            converterWriter = new CarConverterWriterJSON (fileNameOut, cars);
            converterWriter.writeFile();
        }
        catch(IOException e) {
            System.out.println("WRITE FILE ERROR");
            return;
        }
        System.out.println("DONE\n");
    }

}
