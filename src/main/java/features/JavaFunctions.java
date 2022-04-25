package features;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class JavaFunctions {

    public int getJasonSize() {
        int size = 0;
        try {
            File jsonFile = Paths.get("src", "main", "java", "features", "Complaints_Complements_Data.json").toFile();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(jsonFile);
            size = node.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }
    public int getRandomNumber() {
        int b = (int) (Math.random() * (getJasonSize() - 0 + 1) + 0);
        return b;
    }
}

