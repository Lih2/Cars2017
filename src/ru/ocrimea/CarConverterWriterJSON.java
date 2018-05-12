package ru.ocrimea;

import java.util.ArrayList;
import java.io.IOException;
import java.io.StringWriter;
import java.io.File;
import java.io.FileWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CarConverterWriterJSON {

    private String fileName;
    ArrayList<Car> cars=new ArrayList<>();

    public CarConverterWriterJSON(String fileName, ArrayList<Car> cars) {
        this.fileName=fileName;
        this.cars=cars;
    }

    public void writeFile() throws IOException {

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, cars);

        FileWriter writeFile=null;
        try {
            writeFile = new FileWriter(new File(this.fileName));
            writeFile.write(writer.toString());
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
                    System.out.println(e.getStackTrace());
                }
            }
        }


    }



}
