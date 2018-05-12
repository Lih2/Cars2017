

import ru.ocrimea.Car;
import ru.ocrimea.CarParser;
import ru.ocrimea.CarConverterReaderCSV;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TestCarConverterReaderCSV {

    private File file;
    private String[] data=new String[6];
    private Car[] cars=new Car[6];

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();


    private void initData() {

        data[0]="AUDI,Audi A8,3.0TDI,240,350,2013,RED,700000";
        data[1]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[2]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[3]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[4]="AUDI,Audi A8,3.0TDI,240,350,2013,RED,700000";
        data[5]="Mercedes,Mercedes GLK,3.0TDI,240,350,2013,BLACK,700000";
    }

    private void initDataWrong() {

        data[0]="AUDI,Audi A8,3.0TDI,240,350,2013,RED";
        data[1]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[2]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[3]="BMW,BMW X5,3.0TDI,240,350,2013,700000";
        data[4]="AUDI,Audi A8,3.0TDI,240,350,2013,RED,700000";
        data[5]="Mercedes,Mercedes GLK,3.0TDI,240,350,2013,BLACK,700000";
    }

    private void initCars() {

        CarParser carParser = new CarParser(',');
        for(int i=0;i<data.length;i++) {
            cars[i]=carParser.parseStringToCar(data[i]);
        }
    }


    private void createTmpFile() throws IOException {

        FileWriter writer=null;

        try
        {
            file = folder.newFile("test.csv");
            writer= new FileWriter(file);

            for(int i=0;i<data.length;i++) {
                writer.write(data[i]);
                if( i != (data.length-1))
                    writer.write("\n");
            }
            writer.flush();
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
            throw e;
        }
        finally {
            writer.close();
        }
    }

    @Test
    public void testCarConverterReaderCSVNum() throws IOException {

        initData();
        initCars();

        try {
            createTmpFile();
            CarConverterReaderCSV csv=new CarConverterReaderCSV(file.getAbsolutePath());
            ArrayList<Car> carsFromFile=csv.readFile();
            Assert.assertEquals("Number of Cars", carsFromFile.size(),data.length);
            for(int i=0;i<carsFromFile.size();i++) {
                Assert.assertEquals("Car"+i,carsFromFile.get(i),cars[i]);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCarConverterReaderCSVFormat() throws IOException {

        ArrayList<Car> cars= new ArrayList<>();
        initDataWrong();

        try {
            createTmpFile();
            CarConverterReaderCSV csv=new CarConverterReaderCSV(file.getAbsolutePath());
            cars=csv.readFile();
        }
        catch(IOException e) {

        }
    }




}
