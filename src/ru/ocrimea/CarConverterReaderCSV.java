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
    private char delimeter=';';
    private HashMap<String,Integer> structure = new HashMap<>();
    private BufferedReader reader=null;

    public CarConverterReaderCSV(String fileName, char delimeter) {
        this.fileName=fileName;
        this.delimeter=delimeter;
        setDeafaultFileStructure();
    }
    private void setDeafaultFileStructure() {
        structure.put("carFirm",0);
        structure.put("name",1);
        structure.put("engine",2);
        structure.put("power",3);
        structure.put("torgue",4);
        structure.put("year",5);
        structure.put("carColor",6);
        structure.put("price",7);
    }

    public ArrayList<Car> readFile() throws IOException, IllegalArgumentException {

        ArrayList<Car> cars = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] carString = line.split(String.valueOf(delimeter));

                if( carString.length < structure.keySet().size()) {
                   throw new IllegalArgumentException();
                }
                Car car=new Car();
                car.setCarFirm(carString[structure.get("carFirm")]);
                car.setName(carString[structure.get("name")]);
                car.setEngine(carString[structure.get("engine")]);
                car.setPower(carString[structure.get("power")]);
                car.setTorgue(carString[structure.get("torgue")]);
                car.setYear(carString[structure.get("year")]);
                car.setCarColor(carString[structure.get("carColor")]);
                car.setPrice(carString[structure.get("price")]);
                cars.add(car);
            }
        }
        catch(FileNotFoundException e) {
            throw e;
        }
        catch( IllegalArgumentException e ) {
            throw e;
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {

                }
            }
        }

        return cars;
    }


}
