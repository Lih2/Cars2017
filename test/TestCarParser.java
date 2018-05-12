import org.junit.Assert;
import org.junit.Test;
import ru.ocrimea.CarParser;
import ru.ocrimea.Car;

public class TestCarParser {

    @Test
    public void testCarParser() throws Exception {

        String Test="AUDI,Audi A8,3.0TDI,240,350,2013,RED,700000";
        Car originCar= new Car();
        originCar.setCarFirm(Car.CarFirm.AUDI);
        originCar.setCarColor(Car.CarColor.RED);
        originCar.setPrice(700000);
        originCar.setYear(2013);
        originCar.setTorgue(350);
        originCar.setPower(240);
        originCar.setEngine("3.0TDI");
        originCar.setName("Audi A8");

        CarParser carParser=new CarParser(',');

        Car testCar = carParser.parseStringToCar(Test);
        Assert.assertEquals(originCar,testCar);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCarParserFailNumber() throws Exception {

        String Test="AUDI,Audi A8,3.0TDI,240,350,2013,RED";
        CarParser carParser=new CarParser(',');
        Car testCar = carParser.parseStringToCar(Test);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCarParserFailFirmName() throws Exception {
        String Test="111,Audi A8,3.0TDI,240,350,2013,RED,700000";
        CarParser carParser=new CarParser(',');
        Car testCar = carParser.parseStringToCar(Test);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCarParserFailPower() throws Exception {
        String Test="AUDI,Audi A8,3.0TDI,TEST,350,2013,RED,700000";
        CarParser carParser=new CarParser(',');
        Car testCar = carParser.parseStringToCar(Test);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCarParserFailTorque() throws Exception {
        String Test="AUDI,Audi A8,3.0TDI,240,TEST,2013,RED,700000";
        CarParser carParser=new CarParser(',');
        Car testCar = carParser.parseStringToCar(Test);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCarParserFailColor() throws Exception {
        String Test="AUDI,Audi A8,3.0TDI,240,320,2013,TEST,700000";
        CarParser carParser=new CarParser(',');
        Car testCar = carParser.parseStringToCar(Test);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCarParserFailYear() throws Exception {
        String Test="AUDI,Audi A8,3.0TDI,240,320,TEST,RED,700000";
        CarParser carParser=new CarParser(',');
        Car testCar = carParser.parseStringToCar(Test);
    }



}