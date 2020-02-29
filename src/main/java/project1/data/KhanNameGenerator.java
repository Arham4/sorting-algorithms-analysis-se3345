package project1.data;

import java.util.concurrent.ThreadLocalRandom;

public final class KhanNameGenerator {
    private static final String[] POSSIBLE_NAMES = {
            "Kamran Khan", "Ziaullah Khan",
            "Genghis Khan", "Nusrat Fateh Ali Khan",
            "Imran Khan", "Shahrukh Khan", "Amir Khan"
    };

    public static String getRandomName() {
        return POSSIBLE_NAMES[ThreadLocalRandom.current().nextInt(POSSIBLE_NAMES.length)];
    }
}
