package commonPage;

import net.datafaker.Faker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataHelper {
    public static String generateRandomName() {
        return new Faker().name().firstName();
    }

    public static String generateRandomGender() {
        return new Faker().gender().binaryTypes();
    }

    public static String getStringJson(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + path, e);
        }
    }
}
