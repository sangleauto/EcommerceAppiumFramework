package commonTest;

import net.datafaker.Faker;

public class DataHelper {
    public static String generateRandomName() {
        return new Faker().name().firstName();
    }

    public static String generateRandomGender() {
        return new Faker().gender().binaryTypes();
    }
}
