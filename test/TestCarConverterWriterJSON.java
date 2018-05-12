
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import ru.ocrimea.Car;
import ru.ocrimea.CarParser;
import ru.ocrimea.CarConverterWriterJSON;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;


public class TestCarConverterWriterJSON {

    private File file;
    private String[] data=new String[10];
    private ArrayList<Car> cars=new ArrayList<>();

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    private void initData() {
        data[0]="AUDI,Audi A8,3.0TDI,240,350,2013,RED,700000";
        data[1]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[2]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[3]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[4]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[5]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[6]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[7]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[8]="BMW,BMW X5,3.0TDI,240,350,2013,BLACK,700000";
        data[9]="Mercedes,Mercedes GLK,3.0TDI,240,350,2013,BLACK,700000";
    }
    private void initCars() {
        CarParser carParser = new CarParser(',');
        for(int i=0;i<data.length;i++) {
            cars.add(carParser.parseStringToCar(data[i]));
        }
    }

    @Test
    public void createFile() throws IOException {

        initData();
        initCars();

        file=folder.newFile();

        BufferedReader reader=null;

        try
        {
            CarConverterWriterJSON json=new CarConverterWriterJSON(file.getAbsolutePath(),cars);
            json.writeFile();

            reader=new BufferedReader(new FileReader(file));
            String line=reader.readLine();
            String test="[{\"name\":\"Audi A8\",\"engine\":\"3.0TDI\",\"power\":240,\"torgue\":350,\"year\":2013,\"price\":700000.0,\"carColor\":\"RED\",\"carFirm\":\"AUDI\"},{\"name\":\"BMW X5\",\"engine\":\"3.0TDI\",\"power\":240,\"torgue\":350,\"year\":2013,\"price\":700000.0,\"carColor\":\"BLACK\",\"carFirm\":\"BMW\"},{\"name\":\"BMW X5\",\"engine\":\"3.0TDI\",\"power\":240,\"torgue\":350,\"year\":2013,\"price\":700000.0,\"carColor\":\"BLACK\",\"carFirm\":\"BMW\"},{\"name\":\"BMW X5\",\"engine\":\"3.0TDI\",\"power\":240,\"torgue\":350,\"year\":2013,\"price\":700000.0,\"carColor\":\"BLACK\",\"carFirm\":\"BMW\"},{\"name\":\"BMW X5\",\"engine\":\"3.0TDI\",\"power\":240,\"torgue\":350,\"year\":2013,\"price\":700000.0,\"carColor\":\"BLACK\",\"carFirm\":\"BMW\"},{\"name\":\"BMW X5\",\"engine\":\"3.0TDI\",\"power\":240,\"torgue\":350,\"year\":2013,\"price\":700000.0,\"carColor\":\"BLACK\",\"carFirm\":\"BMW\"},{\"name\":\"BMW X5\",\"engine\":\"3.0TDI\",\"power\":240,\"torgue\":350,\"year\":2013,\"price\":700000.0,\"carColor\":\"BLACK\",\"carFirm\":\"BMW\"},{\"name\":\"BMW X5\",\"engine\":\"3.0TDI\",\"power\":240,\"torgue\":350,\"year\":2013,\"price\":700000.0,\"carColor\":\"BLACK\",\"carFirm\":\"BMW\"},{\"name\":\"BMW X5\",\"engine\":\"3.0TDI\",\"power\":240,\"torgue\":350,\"year\":2013,\"price\":700000.0,\"carColor\":\"BLACK\",\"carFirm\":\"BMW\"},{\"name\":\"Mercedes GLK\",\"engine\":\"3.0TDI\",\"power\":240,\"torgue\":350,\"year\":2013,\"price\":700000.0,\"carColor\":\"BLACK\",\"carFirm\":\"Mercedes\"}]";
            Assert.assertEquals("Reading line",line,test);
            reader.close();
        }
        catch(IOException e) {
            e.printStackTrace();
            throw e;
        }
        finally {
            if( reader != null ) reader.close();
        }
    }








}
