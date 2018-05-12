package ru.ocrimea;

import java.util.HashMap;

public class CarParser {

    private char delimeter = ',';
    private HashMap<String, Integer> structure = new HashMap<>();

    public CarParser(char delimeter) {
        this.delimeter = delimeter;
        setDeafaultFileStructure();
    }
    private void setDeafaultFileStructure() {
        structure.put("carFirm", 0);
        structure.put("name", 1);
        structure.put("engine", 2);
        structure.put("power", 3);
        structure.put("torgue", 4);
        structure.put("year", 5);
        structure.put("carColor", 6);
        structure.put("price", 7);
    }

    public Car parseStringToCar(String line) throws IllegalArgumentException {

        String[] carString = line.split(String.valueOf(delimeter));
        if (carString.length < structure.keySet().size()) {
            throw new IllegalArgumentException();
        }
        Car car = new Car();
        try {
            car.setCarFirm(parseCarFirmFromString(carString[structure.get("carFirm")]));
            car.setCarColor(parseCarColorFromString(carString[structure.get("carColor")]));
            car.setName(carString[structure.get("name")]);
            car.setEngine(carString[structure.get("engine")]);
            car.setPower(parsePowerFromString(carString[structure.get("power")]));
            car.setTorgue(parseTorgueFromString(carString[structure.get("torgue")]));
            car.setYear(parseYearFromString(carString[structure.get("year")]));
            car.setPrice(parsePriceFromString(carString[structure.get("price")]));
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return car;
    }

    private int parsePowerFromString(String power) throws IllegalArgumentException {
        int result;
        try {
            result = Integer.parseInt(power);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return result;
    }

    private int parseTorgueFromString(String torgue) throws IllegalArgumentException {
        int result;
        try {
            result = Integer.parseInt(torgue);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return result;
    }

    private int parseYearFromString(String year) throws IllegalArgumentException {
        int result;
        try {
            result = Integer.parseInt(year);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return result;
    }

    private float parsePriceFromString(String price) throws IllegalArgumentException {
        float result;
        try {
            result = Float.parseFloat(price);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return result;
    }

    private Car.CarColor parseCarColorFromString(String carColor) {
        Car.CarColor color;
        try {
            color = Car.CarColor.valueOf(carColor);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return color;
    }

    private Car.CarFirm parseCarFirmFromString(String carFirm) {
        Car.CarFirm firm;
        try {
            firm = Car.CarFirm.valueOf(carFirm);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return firm;
    }





}
