package config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnvLoader {
    private static final Map<String, String> env = new HashMap<>();

    public static void loadEnv() {
        try (BufferedReader reader = new BufferedReader(new FileReader(".env"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    env.put(parts[0].trim(), parts[1].trim());
                }
            }
            
            // Setelah semua env dimuat, lakukan interpolasi
            for (Map.Entry<String, String> entry : env.entrySet()) {
                env.put(entry.getKey(), interpolate(entry.getValue()));
            }
        } catch (Exception e) {
            System.out.println("Gagal memuat file .env: " + e.getMessage());
        }
    }

    private static String interpolate(String value) {
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String var = matcher.group(1);
            String replacement = env.getOrDefault(var, "");
            matcher.appendReplacement(sb, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String get(String key) {
        return env.get(key);
    }
}
