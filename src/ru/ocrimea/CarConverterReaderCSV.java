package ru.ocrimea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/// carFirm, name, engine, power, torgue, year, carColor, price

public class CarConverterReaderCSV {

    private String fileName;
    private CarParser carParser=new CarParser(',');

    public CarConverterReaderCSV(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Car> readFile () throws IOException, IllegalArgumentException {

        ArrayList<Car> cars = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader((new FileReader(fileName))))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                cars.add(carParser.parseStringToCar(line));
            }
        }
        catch (FileNotFoundException e) {
            throw e;
        }
        catch (IllegalArgumentException e) {
            throw e;
        }
        return cars;
    }




}
