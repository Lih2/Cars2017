package ru.ocrimea;

import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class CarConverterWriterJSON {

    private String fileName;
    ArrayList<Car> cars=new ArrayList<>();

    public CarConverterWriterJSON(String fileName, ArrayList<Car> cars) {
        this.fileName=fileName;
        this.cars=cars;
    }

    public void writeFile() throws IOException {

        FileWriter writeFile=null;

        try {
            writeFile = new FileWriter(new File(this.fileName));
            writeFile.write("{\n");

            writeFile.write(" \"Cars\":\n");
            writeFile.write(" [\n");

            for(int i=0;i<cars.size(); i++) {

                Car car =cars.get(i);
                writeFile.write("  {\n");

/// carFirm, name, engine, power, torgue, year, carColor, price

                writeFile.write("   \"CarFirm\":" + "\"" + car.getCarFirm() + "\",\n");
                writeFile.write("   \"Name\":" + "\"" + car.getName() + "\",\n");
                writeFile.write("   \"Engine\":" + "\"" + car.getEngine() + "\",\n");
                writeFile.write("   \"Power\":" + car.getPower() + ",\n");
                writeFile.write("   \"Torgue\":" + car.getTorgue() + ",\n");
                writeFile.write("   \"Year\":" + car.getYear() + ",\n");
                writeFile.write("   \"CarColor\":" + "\"" + car.getCarColor() + "\",\n");
                writeFile.write("   \"Price\":" + car.getPrice() + "\n");

                if( i < cars.size()-1 )
                    writeFile.write("  },\n");
                else
                    writeFile.write("  }\n");
            }

            writeFile.write(" ]\n");
            writeFile.write("}");
        }
        catch (IOException e) {
            throw e;
        }
        finally {
            if( writeFile != null ) {
                try {
                    writeFile.close();
                }
                catch(IOException e) {

                }
            }
        }


    }



}
