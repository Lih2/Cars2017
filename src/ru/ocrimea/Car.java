package ru.ocrimea;


public class Car {

    private String name;
    private String engine;
    private int power, torgue;
    private int year;
    private float price;
    private CarColor carColor;
    private CarFirm carFirm;

    public void setName(String name) {
        this.name = name;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setTorgue(int torgue) {
        this.torgue = torgue;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCarColor(CarColor color) {
        this.carColor = color;
    }

    public void setCarFirm(CarFirm firm) {
        this.carFirm = firm;
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

    public enum CarColor {
        RED, BLACK, WHITE, BLUE, GREEN, UNDEFINED
    }

    public enum CarFirm {
        AUDI, BMW, Mercedes, VW, UNDEFINED
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(getClass() == obj.getClass())) return false;
        else {
            Car tmp = (Car) obj;
            if (this.name.equals(tmp.getName()) &&
                    this.carFirm.equals(tmp.getCarFirm()) &&
                    this.carColor.equals(tmp.getCarColor()) &&
                    this.year == tmp.getYear() &&
                    this.power == tmp.getPower() &&
                    this.torgue == tmp.getTorgue() &&
                    this.engine.equals(tmp.getEngine()) &&
                    this.price == tmp.getPrice()
                    ) return true;
            else return false;
        }
    }

}
