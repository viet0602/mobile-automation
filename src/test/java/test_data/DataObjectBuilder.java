package test_data;


import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.io.Reader;

public class DataObjectBuilder {

    public static <T> T buildDataObject(String filePath, Class<T> dataType) {
        T returnedData;
        //Khi đọc file phải biết dg dẫn chính xác ở đâu, nhưng đưa vào thì là tương đối vì ở mỗi máy nó có vị trí khác nhau
        String absoluteFilePath = System.getProperty("user.dir").concat(filePath);
        //Đưa data từ file mình đọc được vào GSON
        // try with resource
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
