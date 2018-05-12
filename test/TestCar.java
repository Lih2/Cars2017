import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.ocrimea.Car;

public class TestCar {

    public Car originCar, destCar;

    @Before
    public void initCars() {

        originCar= new Car();
        originCar.setCarFirm(Car.CarFirm.AUDI);
        originCar.setCarColor(Car.CarColor.RED);
        originCar.setPrice(700000);
        originCar.setYear(2013);
        originCar.setTorgue(350);
        originCar.setPower(240);
        originCar.setEngine("3.0TDI");
        originCar.setName("Audi A8");

        destCar= new Car();
        destCar.setCarFirm(Car.CarFirm.AUDI);
        destCar.setCarColor(Car.CarColor.RED);
        destCar.setPrice(700000);
        destCar.setYear(2013);
        destCar.setTorgue(350);
        destCar.setPower(240);
        destCar.setEngine("3.0TDI");
        destCar.setName("Audi A8");
    }

    @Test
    public void testCarEqual() {
        Assert.assertEquals(originCar, destCar);
    }

    @Test
    public void testCarFailCarFirm() {
        destCar.setCarFirm(Car.CarFirm.BMW);
        Assert.assertNotEquals(originCar, destCar);
    }

    @Test
    public void testCarFailCarColor() {
        destCar.setCarColor(Car.CarColor.BLACK);
        Assert.assertNotEquals(originCar, destCar);
    }

    @Test
    public void testCarFailPrice() {
        destCar.setPrice(200000);
        Assert.assertNotEquals(originCar, destCar);
    }

    @Test
    public void testCarFailYear() {
        destCar.setYear(2011);
        Assert.assertNotEquals(originCar, destCar);
    }

    @Test
    public void testCarFailTorgue() {
        destCar.setTorgue(500);
        Assert.assertNotEquals(originCar, destCar);
    }

    @Test
    public void testCarFailPower() {
        destCar.setPower(100);
        Assert.assertNotEquals(originCar, destCar);
    }

    @Test
    public void testCarFailEngine() {
        destCar.setEngine("TEST");
        Assert.assertNotEquals( originCar, destCar);
    }

    @Test
    public void testCarFailName() {
        destCar.setName("TEST");
        Assert.assertNotEquals(originCar, destCar);
    }
}
