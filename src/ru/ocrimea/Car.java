package ru.ocrimea;

enum  CarColor {
    RED, BLACK, WHITE,BLUE, GREEN, UNDEFINED
}
enum CarFirm {
    AUDI, BMW, Mercedes, VW, UNDEFINED
}

public class Car {

    private String name;
    private String engine;
    private Integer power,torgue;
    private Integer year;
    private Float price;
    private CarColor carColor;
    private CarFirm carFirm;

    public void setName(String name) {
        this.name = name;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setPower(String power) throws IllegalArgumentException {
        try {
            this.power = Integer.parseInt(power);
        }
        catch (IllegalArgumentException e) {
            throw e;
        }
    }
    public void setTorgue(String torgue) throws IllegalArgumentException {
        try {
            this.torgue = Integer.parseInt(torgue);
        }
        catch (IllegalArgumentException e) {
            throw e;
        }
    }
    public void setYear(String year) throws IllegalArgumentException {
        try {
            this.year = Integer.parseInt(year);
        }
        catch (IllegalArgumentException e) {
            throw e;
        }
    }
    public void setPrice(String price) throws IllegalArgumentException {
        try {
            this.price = Float.parseFloat(price);
        }
        catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void setCarColor(String carColor)  {
        try {
            this.carColor=CarColor.valueOf(carColor);
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }

    public void setCarFirm(String carFirm) {
        try {
            this.carFirm=CarFirm.valueOf(carFirm);

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public String getName() {
        return name;
    }

    public String getEngine() {
        return engine;
    }

    public int getPower() {
        return power;
    }

    public int getTorgue() {
        return torgue;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public CarFirm getCarFirm() {
        return carFirm;
    }
}
