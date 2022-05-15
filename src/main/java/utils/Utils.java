package utils;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    private static final Map<String, String> GENERATED_IDENTIFIERS = new HashMap<>();

    public static String createName(String base) {
        String[] emailParts = base.split("@");
        String generated = emailParts[0] + System.nanoTime();
        if (emailParts.length > 1) {
            generated += "@" + emailParts[1];
        }
        GENERATED_IDENTIFIERS.put(base, generated);
        return generated;
    }

    public String getIdentifier(String base) {
        return GENERATED_IDENTIFIERS.get(base);
    }
}
