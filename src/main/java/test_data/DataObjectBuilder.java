package test_data;


import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.io.Reader;

public class DataObjectBuilder {

    public static <T> T buildDataObject(String filePath, Class<T> dataType) {
        T returnedData;
        String absoluteFilePath = System.getProperty("user.dir").concat(filePath);
        try (
                Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath));
        ) {
                Gson gson = new Gson();
                returnedData = gson.fromJson(reader,dataType);
        }catch ( NoSuchFileException noSuchFieldException){
            throw new RuntimeException("ERR: Can't locate the file: ".concat(absoluteFilePath));
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return returnedData;
    }
}
